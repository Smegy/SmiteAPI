package smitegee.smiteapi.ingame.Commands.Economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import smitegee.smiteapi.economy.EconomyManager;

import java.util.UUID;

public class transferBalance implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        // Check if the sender is a player
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§cOnly players can execute this command.");
            return true;
        }

        Player player = (Player) commandSender;
        UUID playerUUID = player.getUniqueId();

        // Check for command permission
        if (!player.hasPermission("smiteapi.transferbalance")) {
            commandSender.sendMessage("§cYou do not have permission to use this command.");
            return true;
        }

        // Validate arguments
        if (args.length != 3) {
            commandSender.sendMessage("§cUsage: /transferbalance <player> <amount>");
            return true;
        }

        // Get target player and amount
        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            commandSender.sendMessage("§cPlayer not found.");
            return true;
        }

        double amount;
        try {
            amount = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            commandSender.sendMessage("§cInvalid amount.");
            return true;
        }

        // Transfer balance
        UUID targetPlayerUUID = targetPlayer.getUniqueId();
        if (EconomyManager.transferBalance(playerUUID, targetPlayerUUID, amount)) {
            commandSender.sendMessage("§aSuccessfully transferred " + amount + " to " + targetPlayer.getName() + ".");
            targetPlayer.sendMessage("§aYou have received " + amount + " from " + player.getName() + ".");
        } else {
            commandSender.sendMessage("§cInsufficient balance.");
        }

        return true;
    }
}

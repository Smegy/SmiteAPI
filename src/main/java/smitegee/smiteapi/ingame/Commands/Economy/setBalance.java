package smitegee.smiteapi.ingame.Commands.Economy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import smitegee.smiteapi.economy.EconomyManager;
import smitegee.smiteapi.Utils.PlayerUtils.getPlayerData;

import java.util.UUID;

public class setBalance implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players can execute this command.");
            return true;
        }

        if (!commandSender.hasPermission("smiteapi.setbalance")) {
            commandSender.sendMessage("You do not have permission to execute this command.");
            return true;
        }

        if (args.length != 2) {
            commandSender.sendMessage("Usage: /setbalance <player> <amount>");
            return true;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            commandSender.sendMessage("Player not found.");
            return true;
        }

        UUID targetUUID = getPlayerData.getPlayerUUID(targetPlayer);
        double amount;

        try {
            amount = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            commandSender.sendMessage("The amount must be a valid number.");
            return true;
        }


        EconomyManager.setBalance(targetUUID, amount);
        commandSender.sendMessage("Successfully set " + targetPlayer.getName() + "'s balance to " + amount);

        return true;
    }
}

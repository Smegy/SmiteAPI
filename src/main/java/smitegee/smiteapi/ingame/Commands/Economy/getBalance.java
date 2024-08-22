package smitegee.smiteapi.ingame.Commands.Economy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import smitegee.smiteapi.Utils.PlayerUtils.getPlayerData;
import smitegee.smiteapi.economy.EconomyManager;

public class getBalance implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {



        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            double balance = EconomyManager.getBalance(getPlayerData.getPlayerUUID(player));

            player.sendMessage("Your current balance is: $" + balance);
        } else {
            commandSender.sendMessage("Only players can execute this command.");
            return true;
        }
        return false;
    }
}
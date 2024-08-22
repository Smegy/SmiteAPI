package smitegee.smiteapi.Utils.CommandHelper;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import java.util.logging.Level;

public class CommandDebugger {

    // Execute a command and provide feedback on success or failure
    public static void executeCommand(CommandSender sender, String command) {
        try {
            // Check if the command is valid
            if (Bukkit.getServer().getPluginCommand(command) == null) {
                sender.sendMessage("§cCommand not found.");
                return;
            }

            // Execute the command
            Bukkit.getServer().dispatchCommand(sender, command);

            // Optionally, you could add custom logic here to handle success
            sender.sendMessage("§aCommand executed successfully!");

        } catch (Exception e) {
            // Log the error and notify the player
            Bukkit.getLogger().log(Level.SEVERE, "Error executing command: " + command, e);
            sender.sendMessage("§cAn error occurred while executing the command. Please message the admins to tell them.");
        }
    }
}

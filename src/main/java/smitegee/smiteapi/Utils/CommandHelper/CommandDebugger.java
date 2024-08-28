package smitegee.smiteapi.Utils.CommandHelper;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import java.util.logging.Level;

public class CommandDebugger {

    // Execute a command and provide feedback on success or failure
    public static void executeCommand(CommandSender sender, String command) {
        try {
            // Check if the command is valid
            if (Bukkit.getServer().getPluginCommand(command) == null) {
                //Make an action bar
                sender.sendActionBar(Component.text("Command not found", TextColor.color(255, 135, 148)));
                return;
            }

            // Execute the command
            Bukkit.getServer().dispatchCommand(sender, command);

            // Optionally, you could add custom logic here to handle success
            sender.sendActionBar(Component.text("Command Executed correctly.", TextColor.color(0, 255, 0)));

        } catch (Exception e) {
            // Log the error and notify the player
            Bukkit.getLogger().log(Level.SEVERE, "Error executing command: " + command, e);
            sender.sendActionBar(Component.text("An error occurred while executing the command. Please message the admins to tell them.", TextColor.color(100, 0, 0)));
        }
    }
}

package smitegee.smiteapi.CommandHelper;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandScheduler {

    // Schedules a command to be run after a specified delay in seconds
    public static void scheduleCommand(final Plugin plugin, final CommandSender sender, final String command, int delaySeconds) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.dispatchCommand(sender, command);
            }
        }.runTaskLater(plugin, delaySeconds * 20L); // 20 ticks per second
    }

    // Schedules a repeating command to run every interval seconds, with an initial delay
    public static void scheduleRepeatingCommand(final Plugin plugin, final CommandSender sender, final String command, int initialDelaySeconds, int intervalSeconds) {
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.dispatchCommand(sender, command);
            }
        }.runTaskTimer(plugin, initialDelaySeconds * 20L, intervalSeconds * 20L); // 20 ticks per second
    }

    // Cancels all scheduled tasks associated with the plugin
    public static void cancelAllScheduledTasks(final Plugin plugin) {
        Bukkit.getScheduler().cancelTasks(plugin);
    }
}

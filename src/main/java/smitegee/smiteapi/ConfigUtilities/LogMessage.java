package smitegee.smiteapi.ConfigUtilities;

import org.bukkit.plugin.java.JavaPlugin;

public class LogMessage {

    private final JavaPlugin plugin;

    public LogMessage(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Logs an informational message.
     *
     * @param message The message to log.
     */
    public void info(String message) {
        plugin.getLogger().info(message);
    }

    /**
     * Logs a warning message.
     *
     * @param message The message to log.
     */
    public void warn(String message) {
        plugin.getLogger().warning(message);
    }

    /**
     * Logs a severe error message.
     *
     * @param message The message to log.
     */
    public void error(String message) {
        plugin.getLogger().severe(message);
    }

    /**
     * Logs an exception with a custom message.
     *
     * @param message The custom message.
     * @param throwable The exception to log.
     */
    public void error(String message, Throwable throwable) {
        plugin.getLogger().log(java.util.logging.Level.SEVERE, message, throwable);
    }
}

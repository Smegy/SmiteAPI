package smitegee.smiteapi.Utils.ConfigUtilities;

import org.bukkit.plugin.java.JavaPlugin;

public class LogMessage {

    /**
     * Logs an informational message.
     *
     * @param plugin The plugin instance used for logging.
     * @param message The message to log.
     */
    public static void info(JavaPlugin plugin, String message) {
        plugin.getLogger().info(message);
    }

    /**
     * Logs a warning message.
     *
     * @param plugin The plugin instance used for logging.
     * @param message The message to log.
     */
    public static void warn(JavaPlugin plugin, String message) {
        plugin.getLogger().warning(message);
    }

    /**
     * Logs a severe error message.
     *
     * @param plugin The plugin instance used for logging.
     * @param message The message to log.
     */
    public static void error(JavaPlugin plugin, String message) {
        plugin.getLogger().severe(message);
    }

    /**
     * Logs an exception with a custom message.
     *
     * @param plugin The plugin instance used for logging.
     * @param message The custom message.
     * @param throwable The exception to log.
     */
    public static void error(JavaPlugin plugin, String message, Throwable throwable) {
        plugin.getLogger().log(java.util.logging.Level.SEVERE, message, throwable);
    }

    /*
    * EXAMPLE:
    * LogMessage.warn(MainClass, "message")
     */
}

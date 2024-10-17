public class Logger {
    private static Logger instance; // The single instance

    // Private constructor to prevent external instantiation
    private Logger() {
        // Initialize logger settings here (e.g., log file path, log level)
    }

    // Static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Log a message
    public void log(String message) {
        System.out.println("Logging: " + message);
        // Actual logging logic (write to file, console, etc.)
    }
    public static void main(String[] args) {
        // Get the singleton instance
        Logger logger = Logger.getInstance();

        // Use the instance to log messages
        logger.log("Application started");
        logger.log("Processing user request");
        logger.log("Error: Database connection failed");

        // Other parts of your application
    }
}
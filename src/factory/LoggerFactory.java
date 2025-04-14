package factory;

import model.Logger;

public class LoggerFactory {
    public static Logger createLogger(String sourceName) {
        String logFile = "log/log_study.log";
        Logger logger = new Logger(logFile, sourceName);
        return logger;
    }
}

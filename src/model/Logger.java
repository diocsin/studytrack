package model;

import factory.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private final Logger logger = LoggerFactory.createLogger("logger");
    private String logFile;
    private String sourceName;

    public Logger(String logFile, String sourceName) throws IOException {
        this.logFile = logFile;
        this.sourceName = sourceName;
    }

    public void log(String message) {
        String time = LocalDateTime.now().toString();
        String st = String.format("[%s] [%s] Студент создан", time, sourceName);

        try (BufferedWriter writer = new BufferedWriter(new
                FileWriter("Log.txt", true))) {
            writer.write(st);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Неудалось записать в файл");
        }
    }

    public String getLogFile() {
        return logFile;
    }

    public String getSourceName() {
        return sourceName;
    }
}

package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private String logFile;
    private String sourceName;

    public Logger(String logFile, String sourceName) {
        this.logFile = logFile;
        this.sourceName = sourceName;
    }

    public void log(String message) {
        String time = LocalDateTime.now().toString();
        String st = String.format("[%s] [%s] Студент создан", time, sourceName);

        try (BufferedWriter writer = new BufferedWriter(new
                FileWriter(logFile, true))) {
            writer.write(st);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл");
        }
    }
}

package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private String logFile;
    private String sourceName;

    public Logger(String logFile, String sourceName) throws IOException {
        this.logFile = logFile;
        this.sourceName = sourceName;
    }

    public void log(String message) {
        LocalDateTime time = LocalDateTime.now();
        String time1 = time.toString();
        String.format("[%s] [%s] Студент создан", time1, sourceName);

        try (
                FileWriter fileWriter = new FileWriter("",
                        true)) {
            fileWriter.write();
        } catch (
                IOException e) {
            log("Неудалось записать в файл");
        }

        try (
                BufferedWriter writer = new BufferedWriter(new
                        FileWriter(""))) {
            writer.write("Строка 1");
            writer.newLine();
            writer.write("Строка 2");
        } catch (
                IOException e) {
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

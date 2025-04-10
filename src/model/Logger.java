package model;

import factory.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private final Logger logger = LoggerFactory.createLogger("logger");
    private String logFile;
    private String sourceName;

    public Logger(String logFile, String sourceName) {
        this.logFile = logFile;
        this.sourceName = sourceName;
    }

    public void log(String message) {


        try (
                FileWriter fileWriter = new FileWriter("",
                        true)) {
            fileWriter.write();
        } catch (
                IOException e) {
            logger.log("Неудалось записать в файл");
        }

        try (
                BufferedWriter writer = new BufferedWriter(new
                        FileWriter(""))) {
            writer.write("Строка 1");
            writer.newLine();
            writer.write("Строка 2");
        } catch (
                IOException e) {
            logger.log("Неудалось записать в файл");
        }
    }

    public String getLogFile() {
        return logFile;
    }

    public String getSourceName() {
        return sourceName;
    }
}

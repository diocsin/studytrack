package utils;

import manager.StudyManager;
import model.Course;
import model.Grade;
import model.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ExportService {

    public static final String FILE_NAME = "export/Export.txt";
    private static ExportService instance;

    public void exportStudentsToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : StudyManager.getInstance().getStudents()) {
                writer.write("Student: " + student.getName());
                writer.newLine();
                for (Map.Entry<Course, Grade> entry : student.getGrades().entrySet()) {
                    writer.write("Course: " + entry.getKey().getTitle()
                            + ", Grade: " + entry.getValue().getValue());
                    writer.newLine();
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error exporting students to file: " + e.getMessage());
        }
    }
}
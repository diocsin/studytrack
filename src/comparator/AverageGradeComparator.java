package comparator;
import model.Student;

import java.util.Comparator;

public class AverageGradeComparator  implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.calculateAverageGrade(), s2.calculateAverageGrade());
    }
}

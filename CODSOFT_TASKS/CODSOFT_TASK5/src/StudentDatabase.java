import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {

    private final List<Student> students;

    public StudentDatabase() {
        students = new ArrayList<>();
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    public boolean studentExists(String studentId) {
        return findStudentById(studentId) != null;
    }

    public Student addStudent(String studentId, String name) {
        Student student = new Student(studentId, name);
        students.add(student);
        return student;
    }

    public Student getOrCreateStudent(String studentId, String name) {
        Student existing = findStudentById(studentId);
        if (existing != null) {
            return existing;
        }
        return addStudent(studentId, name);
    }
}

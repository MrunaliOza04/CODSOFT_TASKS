import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String studentId;
    private final String name;
    private final List<String> registeredCourseCodes;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourseCodes = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<String> getRegisteredCourseCodes() {
        return registeredCourseCodes;
    }

    public boolean isRegisteredFor(String courseCode) {
        return registeredCourseCodes.contains(courseCode);
    }

    public void addCourse(String courseCode) {
        registeredCourseCodes.add(courseCode);
    }

    public void removeCourse(String courseCode) {
        registeredCourseCodes.remove(courseCode);
    }

    @Override
    public String toString() {
        return studentId + " - " + name;
    }
}

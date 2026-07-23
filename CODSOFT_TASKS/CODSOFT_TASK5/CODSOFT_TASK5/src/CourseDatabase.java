import java.util.ArrayList;
import java.util.List;

public class CourseDatabase {

    private final List<Course> courses;

    public CourseDatabase() {
        courses = new ArrayList<>();
        loadSampleCourses();
    }

    private void loadSampleCourses() {
        courses.add(new Course("CS101", "Introduction to Programming",
                "Fundamentals of programming using Java.", 3, "Mon & Wed, 9:00 AM - 10:30 AM"));
        courses.add(new Course("CS102", "Data Structures",
                "Arrays, linked lists, stacks, queues, trees and graphs.", 2, "Tue & Thu, 11:00 AM - 12:30 PM"));
        courses.add(new Course("CS201", "Database Management Systems",
                "Relational databases, SQL and normalization.", 3, "Mon & Fri, 1:00 PM - 2:30 PM"));
        courses.add(new Course("CS301", "Object Oriented Programming",
                "Core OOP concepts including encapsulation, inheritance and polymorphism.", 2, "Wed & Fri, 3:00 PM - 4:30 PM"));
        courses.add(new Course("CS401", "Web Development",
                "HTML, CSS, JavaScript and server-side basics.", 3, "Tue & Thu, 2:00 PM - 3:30 PM"));
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public boolean courseExists(String courseCode) {
        return findCourseByCode(courseCode) != null;
    }

    public void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses are currently available.");
            return;
        }

        System.out.println("==================================================");
        System.out.println("                 AVAILABLE COURSES");
        System.out.println("==================================================");

        for (Course course : courses) {
            System.out.println(course.getFullDetails());
            System.out.println("--------------------------------------------------");
        }
    }
}

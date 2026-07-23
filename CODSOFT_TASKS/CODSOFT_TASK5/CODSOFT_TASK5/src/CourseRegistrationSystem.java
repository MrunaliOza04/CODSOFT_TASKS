import java.util.List;
import java.util.Scanner;

public class CourseRegistrationSystem {

    private final CourseDatabase courseDatabase;
    private final StudentDatabase studentDatabase;
    private final Scanner scanner;

    public CourseRegistrationSystem() {
        this.courseDatabase = new CourseDatabase();
        this.studentDatabase = new StudentDatabase();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("==================================================");
        System.out.println("     WELCOME TO THE COURSE REGISTRATION SYSTEM");
        System.out.println("==================================================");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    courseDatabase.displayAllCourses();
                    break;
                case 2:
                    registerCourse();
                    break;
                case 3:
                    dropCourse();
                    break;
                case 4:
                    viewRegisteredCourses();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the Course Registration System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
            System.out.println();
        }

        scanner.close();
    }

    private void printMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("MAIN MENU");
        System.out.println("1. View Available Courses");
        System.out.println("2. Register for a Course");
        System.out.println("3. Drop a Course");
        System.out.println("4. View Registered Courses");
        System.out.println("5. Exit");
        System.out.println("--------------------------------------------------");
        System.out.print("Enter your choice (1-5): ");
    }

    private int readMenuChoice() {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private String promptForStudentId() {
        System.out.print("Enter your Student ID: ");
        return scanner.nextLine().trim();
    }

    private void registerCourse() {
        System.out.println("\n--- Course Registration ---");
        String studentId = promptForStudentId();

        if (studentId.isEmpty()) {
            System.out.println("Error: Student ID cannot be empty.");
            return;
        }

        Student student = studentDatabase.findStudentById(studentId);
        if (student == null) {
            System.out.print("Enter your Name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                name = "Unknown";
            }
            student = studentDatabase.addStudent(studentId, name);
            System.out.println("New student profile created for " + student.getName() + ".");
        }

        courseDatabase.displayAllCourses();

        System.out.print("Enter the Course Code to register: ");
        String courseCode = scanner.nextLine().trim();

        Course course = courseDatabase.findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Error: Invalid course code '" + courseCode + "'. No such course exists.");
            return;
        }

        if (student.isRegisteredFor(course.getCourseCode())) {
            System.out.println("Error: You are already registered for " + course.getCourseCode() + " - " + course.getTitle() + ".");
            return;
        }

        if (!course.hasAvailableSeat()) {
            System.out.println("Error: Course " + course.getCourseCode() + " is full. Registration failed.");
            return;
        }

        boolean seatReserved = course.reserveSeat();
        if (seatReserved) {
            student.addCourse(course.getCourseCode());
            System.out.println("Success: You have been registered for " + course.getCourseCode() + " - " + course.getTitle() + ".");
            System.out.println("Remaining seats: " + course.getAvailableSeats());
        } else {
            System.out.println("Error: Course " + course.getCourseCode() + " is full. Registration failed.");
        }
    }

    private void dropCourse() {
        System.out.println("\n--- Drop Course ---");
        String studentId = promptForStudentId();

        Student student = studentDatabase.findStudentById(studentId);
        if (student == null) {
            System.out.println("Error: No student found with ID '" + studentId + "'.");
            return;
        }

        if (student.getRegisteredCourseCodes().isEmpty()) {
            System.out.println(student.getName() + ", you are not registered for any courses.");
            return;
        }

        System.out.println("Your registered courses:");
        for (String code : student.getRegisteredCourseCodes()) {
            Course c = courseDatabase.findCourseByCode(code);
            if (c != null) {
                System.out.println(" - " + c.getCourseCode() + " : " + c.getTitle());
            }
        }

        System.out.print("Enter the Course Code to drop: ");
        String courseCode = scanner.nextLine().trim();

        Course course = courseDatabase.findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Error: Invalid course code '" + courseCode + "'. No such course exists.");
            return;
        }

        if (!student.isRegisteredFor(course.getCourseCode())) {
            System.out.println("Error: You are not registered for " + course.getCourseCode() + ", so it cannot be dropped.");
            return;
        }

        student.removeCourse(course.getCourseCode());
        course.releaseSeat();
        System.out.println("Success: You have dropped " + course.getCourseCode() + " - " + course.getTitle() + ".");
        System.out.println("Available seats now: " + course.getAvailableSeats());
    }

    private void viewRegisteredCourses() {
        System.out.println("\n--- View Registered Courses ---");
        String studentId = promptForStudentId();

        Student student = studentDatabase.findStudentById(studentId);
        if (student == null) {
            System.out.println("Error: No student found with ID '" + studentId + "'.");
            return;
        }

        List<String> registeredCodes = student.getRegisteredCourseCodes();
        if (registeredCodes.isEmpty()) {
            System.out.println(student.getName() + ", you are not registered for any courses yet.");
            return;
        }

        System.out.println("Registered courses for " + student.getName() + " (" + student.getStudentId() + "):");
        System.out.println("--------------------------------------------------");
        for (String code : registeredCodes) {
            Course course = courseDatabase.findCourseByCode(code);
            if (course != null) {
                System.out.println(course.getFullDetails());
                System.out.println("--------------------------------------------------");
            }
        }
    }
}

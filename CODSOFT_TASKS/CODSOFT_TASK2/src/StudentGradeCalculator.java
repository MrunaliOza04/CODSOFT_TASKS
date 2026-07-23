import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("====================================");

        System.out.print("Enter the number of subjects: ");
        int subjects = scanner.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {

            int marks;

            while (true) {
                System.out.print("Enter marks for Subject " + i + " (0-100): ");
                marks = scanner.nextInt();

                if (marks >= 0 && marks <= 100) {
                    break;
                } else {
                    System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                }
            }

            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / subjects;

        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\n========== RESULT ==========");
        System.out.println("Total Marks        : " + totalMarks);
        System.out.println("Average Percentage : " + averagePercentage + "%");
        System.out.println("Grade              : " + grade);
        System.out.println("============================");

        scanner.close();
    }
}
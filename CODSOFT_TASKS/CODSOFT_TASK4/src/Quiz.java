import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {

    private Question[] questions;
    private int score = 0;
    private Scanner scanner = new Scanner(System.in);

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

    public void startQuiz() {

        for (int i = 0; i < questions.length; i++) {

            Question q = questions[i];

            System.out.println("\nQuestion " + (i + 1));
            System.out.println(q.question);

            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            final boolean[] timeUp = {false};

            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeUp[0] = true;
                    System.out.println("\nTime's Up!");
                }
            }, 10000);

            System.out.print("Enter your answer (1-4): ");

            int answer = scanner.nextInt();

            timer.cancel();

            if (!timeUp[0]) {

                if (answer == q.correctAnswer) {
                    score++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong!");
                }

            }
        }

        System.out.println("\n========== RESULT ==========");
        System.out.println("Total Questions : " + questions.length);
        System.out.println("Correct Answers : " + score);
        System.out.println("Wrong Answers   : " + (questions.length - score));
        System.out.println("Final Score     : " + score + "/" + questions.length);
    }
}
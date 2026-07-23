import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        boolean playAgain = true;

        System.out.println("======================================");
        System.out.println("     WELCOME TO NUMBER GUESS GAME");
        System.out.println("======================================");

        while (playAgain) {

            int number = random.nextInt(100) + 1;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempt + 1);
                    break;
                } else if (guess < number) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You lost! The correct number was: " + number);
            }

            System.out.println("Current Score: " + score);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n==============================");
        System.out.println("Final Score: " + score);
        System.out.println("Thank you for playing!");
        System.out.println("==============================");

        scanner.close();
    }
}
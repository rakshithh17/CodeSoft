import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        playGuessingGame();
    }

    public static void playGuessingGame() {
        int lowerRange = 1;
        int upperRange = 100;
        int maxAttempts = 10;
        boolean playAgain = true;
        int rounds = 0;
        int totalAttempts = 0;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            rounds++;
            int targetNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = 0;
            System.out.println("\nRound " + rounds + ":");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + "/" + maxAttempts + ". Guess the number between " + lowerRange + " and " + upperRange + ": ");
                int userGuess = scanner.nextInt();

                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("\nRound " + rounds + ": Out of attempts! The correct number was " + targetNumber + ".");
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("\nGame over! You played " + rounds + " rounds and your average number of attempts per round was " + (double) totalAttempts / rounds + ".");
    }
}

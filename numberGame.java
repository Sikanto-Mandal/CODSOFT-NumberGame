
import java.util.*;

public class numberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minimumRange = 1;
        int maximumRange = 100;
        int maximumGuesses = 10;
        int totalRounds = 0;
        int roundsWon = 0;

        boolean tryAgain = true;

        while (tryAgain) {
            totalRounds++;
            boolean roundWon = tryAgain(minimumRange, maximumRange, maximumGuesses);

            if (roundWon) {
                roundsWon++;
            }
            System.out.println("Your current score: " + roundsWon + " out of " + totalRounds + " rounds won.");

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainChoice = sc.next().toLowerCase();

            if (!playAgainChoice.equals("yes")) {
                tryAgain = false;
                System.out.println("\nThanks for playing! Your final score: " + roundsWon + " out of " + totalRounds
                        + " rounds won. Goodbye!");
            }
        }

        sc.close();

    }

    public static boolean tryAgain(int minRange, int maxRange, int maxGuesses) {
        Random random = new Random();

        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        System.out.println(
                "\nHey buddy! Welcome to the game. I've generated a Random number between 1 to 100." +
                        "You've 10 chances to guessed the number. Let's play the GAME.\n");

        int guesses = 0;
        boolean guessedCorrectly = false;

        while (!guessedCorrectly && guesses < maxGuesses) {
            System.out.print("Enter your number : ");
            Scanner sc = new Scanner(System.in);

            if (sc.hasNextInt()) {
                int userNumber = sc.nextInt();
                guesses++;
                if (userNumber == randomNumber) {
                    guessedCorrectly = true;
                    System.out.println("\nCongratuation!, You guessed the correct number i.e., " + randomNumber + "\n");
                } else if (userNumber < randomNumber) {
                    System.out.println("\nTry a  'HIGHER' number.");
                } else {
                    System.out.println("\nTry a 'LOWER' number.");
                }
            } else {
                System.out.println("\nOpps!,Invalid input. Please enter a valid integer between 1 and 100.");
                sc.nextLine();

            }

        }
        if (!guessedCorrectly) {
            System.out.println("Sorry, you have run out of guesses. The number was : " + randomNumber + ".");
        }

        return guessedCorrectly;

    }
}

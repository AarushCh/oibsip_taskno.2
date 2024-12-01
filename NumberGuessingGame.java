package Number_Guessing_Game_AUC.src;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    private int totalScore = 0;
    private int maxAttempts = 10;

    public void startGame(int rounds) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int round = 1; round <= rounds; round++) {
            int attempts = 0;
            int numberToGuess = random.nextInt(100) + 1;
            boolean guessedCorrectly = false;

            System.out.println("Round " + round + ": Try to guess the number between 1 and 100!");
            System.out.println("\nYou can type 'quit' anytime to stop playing.\n");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + " of " + maxAttempts + "): ");

                String input = scanner.nextLine().trim().toLowerCase();

                if (input.equals("quit")) {
                    System.out.println("\nYou chose to quit the game. Thanks for playing!\n");
                    scanner.close();
                    return;
                }

                try {
                    int userGuess = Integer.parseInt(input);
                    attempts++;

                    if (userGuess == numberToGuess) {
                        guessedCorrectly = true;
                        System.out.println("\nCongratulations! You've guessed the number correctly.");
                        totalScore += (maxAttempts - attempts + 1);
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid input! Please enter a number or 'quit' to exit.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nSorry! You've used all your attempts. The number was " + numberToGuess + ".");
            }
        }

        System.out.println("\nGame Over! Your total score is: " + totalScore);
        scanner.close();
    }
}

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + maxAttempts + " attempts per round.");
        
        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("\nRound " + (rounds + 1) + ":");
            
            int attempts = 0;
            boolean roundWon = false;
            
            while (attempts < maxAttempts) {
                try {
                    System.out.print("Enter your guess between " + lowerBound + " and " + upperBound + ": ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! Your guess is correct.");
                        roundWon = true;
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Your guess is too low.");
                    } else {
                        System.out.println("Your guess is too high.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.next(); // Clear the input buffer
                }
            }
            
            if (!roundWon) {
                System.out.println("Round " + (rounds + 1) + ": You ran out of attempts. The number was " + targetNumber + ".");
            } else {
                score += maxAttempts - attempts + 1;
            }

            rounds++;

            boolean validInput = false;
            while (!validInput) {
                System.out.print("Do you want to play another round? (yes/no): ");
                String playAgainInput = scanner.next().toLowerCase();
                if (playAgainInput.equals("yes")) {
                    validInput = true;
                } else if (playAgainInput.equals("no")) {
                    validInput = true;
                    playAgain = false;
                } else {
                    System.out.println("Please enter only 'yes' or 'no'.");
                }
            }
        }

        System.out.println("\nGame over! You played " + rounds + " rounds and your total score is " + score + ".");
        scanner.close();
    }
}

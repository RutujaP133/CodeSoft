import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            totalScore += playGame(scanner);
            System.out.println("Your total score: " + totalScore);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing! Your final score: " + totalScore);
        scanner.close();
    }

    public static int playGame(Scanner scanner) {
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int attemptsLeft = 10;
        int score = 0;

        System.out.println("\nGuess the number between " + lowerBound + " and " + upperBound + ". You have " + attemptsLeft + " attempts.");

        while (attemptsLeft > 0) {
            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); 
                continue;
            }

            int guess = scanner.nextInt();

            if (guess < lowerBound || guess > upperBound) {
                System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                continue;
            }

            attemptsLeft--;

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly!");
                score = 1; 
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            System.out.println("Attempts left: " + attemptsLeft);
        }

        if (attemptsLeft == 0) {
            System.out.println("Sorry, you ran out of attempts. The number was " + numberToGuess + ".");
        }

        return score;
    }
}
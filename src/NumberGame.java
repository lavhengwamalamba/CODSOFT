package src;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int tries;
    static int rounds = 0;
    static int wins;
    static int score;
    static int currentLevel = 1; // Starting level

    // Define level ranges
    static final int[] LEVEL_RANGES = {50, 100, 150,200,500,750,1000,2000}; // Add more ranges as needed

    public static void triesCheck() {
        if (tries == 1) {
            System.out.println("You have " + tries + " more try!");
        } else {
            System.out.println("You have " + tries + " more tries!");
        }
    }

    public static void checkGuess(int secretNum) {
        System.out.println("Enter your guess:");
        int guess = scanner.nextInt();
        scanner.nextLine();
        if (guess < secretNum) {
            System.out.println("Your guess was too low!");
            tries--;
        } else if (guess > secretNum) {
            System.out.println("Your guess was too high!");
            tries--;
        } else {
            System.out.println("Your guess was correct!");
            score++;
            tries = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Do you want to play a round? [y/n]:");
        String choice = scanner.nextLine();
        while (choice.equalsIgnoreCase("y")) {
            rounds++;
            System.out.println("Round number: " + rounds);
            System.out.println("Current Score: " + score);
            tries = 10;
            int secretNum = random.nextInt(LEVEL_RANGES[currentLevel - 1]) + 1; // Generate secret number based on level range
            while (tries > 0) {
                checkGuess(secretNum);
                if (tries != 0) {
                    triesCheck();
                } else {
                    System.out.println("The correct number was: " + secretNum);
                }
            }
            if (score % 1 == 0) { // Increase level every 3 successful guesses
                currentLevel++;
                System.out.println("Congratulations! You have advanced to level " + currentLevel);
            }
            System.out.println("Do you want to play another round? [y/n]");
            choice = scanner.nextLine();
        }
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

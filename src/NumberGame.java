package src;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    static boolean correct = false;
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int tries;
    static int rounds = 0;
    static int wins;
    static int score;
    static int currentLevel = 1; // Starting level

    // Define level ranges
    static final int[] LEVEL_RANGES = { 50, 100, 150, 200, 500, 750, 1000, 2000 }; // Add more ranges as needed

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
            correct = true;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Number Game!\n\n"
                + "In this game, your goal is to guess the secret number within a limited number of tries. Here's how it works:\n\n"
                + "1. You will be given a range within which the secret number lies.\n"
                + "2. You have 10 tries to guess the correct number.\n"
                + "3. After each guess, you'll be told if your guess was too high or too low.\n"
                + "4. If you guess the number correctly, you earn a point!\n"
                + "5. Every three correct numbers gotten, you level up!\n"
                + "6. With every 3 successful guesses, you'll advance to the next level, where the range of numbers increases, making the game more challenging.\n\n"
                + "Are you ready to test your guessing skills? Let's play!");
        System.out.println("Do you want to play a round? [y/n]:");
        String choice = scanner.nextLine();
        while (choice.equalsIgnoreCase("y")) {
            rounds++;
            System.out.println("Round number: " + rounds);
            System.out.println("Current Score: " + score);
            System.out.println("Level: " + currentLevel);
            System.out.println("Guess a number between 1 and " + LEVEL_RANGES[currentLevel - 1] + ":");
            tries = 10;
            correct = false;
            int secretNum = random.nextInt(LEVEL_RANGES[currentLevel - 1]) + 1; // Generate secret number based on level
                                                                                // range
            while (tries > 0) {
                checkGuess(secretNum);
                if (tries != 0) {
                    triesCheck();
                } else {
                    System.out.println("The correct number was: " + secretNum);
                    break; // Exit the loop if the player runs out of tries
                }
            }

            if (score % 3 == 0 && score != 0 && correct) { // Increase level every 3 successful guesses
                currentLevel++;
                System.out.println("Congratulations! You have advanced to level " + currentLevel);
            }

            System.out.println("Do you want to play another round? [y/n]");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("n")) {
                break; // Exit the loop if the player chooses not to play another round
            }
        }
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

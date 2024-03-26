import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    static Random random = new Random();
    static boolean correct = false;
    static Scanner scanner = new Scanner(System.in);
    static int tries;
    static int rounds = 0;
    static int wins;

    public static void tries_check() {
        if (tries == 1) {
            System.out.println("You have " + tries + " more try!");
        } else {
            System.out.println("You have " + tries + " more tries!");
        }
    }

    public static void check_guess(int secret_num) {
        System.out.println("Enter your Guess");
        int guess = scanner.nextInt();
        scanner.nextLine();
        if (guess < secret_num) {
            System.out.println("Your Guess was too low!");
            tries -= 1;
        } else if (guess > secret_num) {
            System.out.println("Your Guess was too High!");
            tries -= 1;
        } else {
            System.out.println("Your Guess was correct");
            correct = true;
        }
    }

    public static void main(String[] args) {
        System.out.println("Do you want to play a round?[y/n]:");
        String choice = scanner.nextLine();
        while (choice.equals("y")) {
            rounds +=1;
            System.out.println("Round number: " + rounds);
            tries = 3;
            correct = false;
            int secret_num = random.nextInt(100);
            while (!correct) {
                check_guess(secret_num);
                tries_check();
                if (tries == 0) {
                    System.out.println("The correct number was: " + secret_num );
                    break;
                }
            }
            System.out.println("Do you want to play another round?[y/n]");
            choice = scanner.nextLine();
        }
        System.out.println("Thank you for Playing!");
        scanner.close();
    }
}
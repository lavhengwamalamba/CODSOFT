import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    static Random random = new Random();
    static boolean correct = false;
    static Scanner scanner = new Scanner(System.in);
    static int tries;

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
        String round = "y";

        while (round == "y") {
            tries = 3;
            int secret_num = random.nextInt(100);
            System.out.println(secret_num);
            while (!correct) {
                check_guess(secret_num);
                tries_check();
                if (tries == 0) {
                    break;
                }
            }
            System.out.println("Do you want to play another round?[y/n]");
            round = scanner.nextLine();
        }
        System.out.println("Thank you for Playing!");
        scanner.close();
    }
}
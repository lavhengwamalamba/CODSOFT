import java.util.Random;
import java.util.Scanner;
public class Number_Game {
    static Random random = new Random();

    public static void check_guess(int secret_num) {
        boolean correct = false;
        while (!correct) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your Guess");
            int guess = scanner.nextInt();
            if (guess < secret_num) {
                System.out.println("Your Guess was too low!");
            }
            else if (guess > secret_num) {
                System.out.println("Your Guess was too High!");            
            }
            else{
                System.out.println("Your Guess was correct");
                correct = true;
            }
        }
    }
    public static void main(String[] args) {
        int secret_num = random.nextInt(100);
        System.out.println(secret_num);
        check_guess(secret_num);
    }
}
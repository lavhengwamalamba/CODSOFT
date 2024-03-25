public class Number_Game {
    public void check_guess(int guess, int secret_num) {
        if (guess < secret_num) {
            System.out.println("Your Guess was too low!");
        }
        else if (guess < secret_num) {
            System.out.println("Your Guess was too High!");            
        }
        else{
            System.out.println("Your Guess was correct");
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Student_Grade_Calculator {
    static ArrayList<Integer> marks = new ArrayList<Integer>();
    static int total_marks = 0;
    static int average = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number_of_courses = scanner.nextInt();
        scanner.nextLine();
        while (true) {
            System.out.println("Enter mark (out of 100%):");
            int mark = scanner.nextInt();
            scanner.nextLine();
            marks.add(mark);
            System.out.println("Do you want to add another mark? yes/no");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Student_Grade_Calculator {
    static ArrayList<Integer> marks = new ArrayList<Integer>();
    static int total_marks = 0;
    static int average = 0;

    public static String grader(float mark) {
        if (mark >= 80) {
            return "A";
        } else if (70 <= mark && mark < 80) {
            return "B";
        } else if (60 <= mark && mark < 70) {
            return "C";
        } else if (50 <= mark && mark < 60) {
            return "D";
        } else if (40 <= mark && mark < 50) {
            return "E";
        } else if (mark < 40) {
            return "F";
        }
        return "Mark invalid";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many subjects do you have: ");
        int count = scanner.nextInt();
        scanner.nextLine();        
        int i = 1;
        System.out.println("Enter marks (out of 100%):");
        while (i <= count) {
            System.out.print("" + i + ".");
            int mark = scanner.nextInt();
            scanner.nextLine();
            marks.add(mark);
            total_marks += mark;
            i++;

        }
        float ave = total_marks / marks.size();
        System.out.println("Total Marks: " + total_marks + "\nAverage: " + ave + "\nGrade: " + grader(ave));
        scanner.close();
    }
}

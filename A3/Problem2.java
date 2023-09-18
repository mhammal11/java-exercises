import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //taking the input as a string
        String input = keyboard.nextLine();
        /**
         * loop through the input and replace every valid occurrence of a rock,
         * paper, scissors game with the proper winner of that game until the
         * length of the input is equal to 1 which determines the winner
         */
        while (input.length() > 1) {
            if (input.contains("R&P")) {
                input = input.replace("(R&P)", "P");
            } else if (input.contains("R&S")) {
                input = input.replace("(R&S)", "R");
            } else if (input.contains("P&R")) {
                input = input.replace("(P&R)", "P");
            } else if (input.contains("P&S")) {
                input = input.replace("(P&S)", "S");
            } else if (input.contains("S&R")) {
                input = input.replace("(S&R)", "R");
            } else if (input.contains("S&P")) {
                input = input.replace("(S&P)", "S");
            } else if (input.contains("R&R")) {
                input = input.replace("(R&R)", "R");
            } else if (input.contains("P&P")) {
                input = input.replace("(P&P)", "P");
            } else if (input.contains("S&S")) {
                input = input.replace("(S&S)", "S");
            }
        }
        System.out.println(input);
        keyboard.close();
    }
}

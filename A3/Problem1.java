import java.util.Scanner;
import java.util.regex.Pattern;

public class Problem1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //taking the input as a string
        String input = keyboard.nextLine();
        //using patter matching to indicate valid statements when they contain R,P,S,(,),&
        if (Pattern.matches("[RPS()&]+", input)) {
            /**
             * loop through the input and replace every valid occurrence of R,P,S,(,),&
             * with the proper winner of that game until we can no longer replace anything
             * or the length of the input is equal to 1
             */
            while (input.length() > 1) {
                if (input.contains("(R&P)")) {
                    input = input.replace("(R&P)", "P");
                } else if (input.contains("(R&S)")) {
                    input = input.replace("(R&S)", "R");
                } else if (input.contains("(P&R)")) {
                    input = input.replace("(P&R)", "P");
                } else if (input.contains("(P&S)")) {
                    input = input.replace("(P&S)", "S");
                } else if (input.contains("(S&R)")) {
                    input = input.replace("(S&R)", "R");
                } else if (input.contains("(S&P)")) {
                    input = input.replace("(S&P)", "S");
                } else if (input.contains("(R&R)")) {
                    input = input.replace("(R&R)", "R");
                } else if (input.contains("(P&P)")) {
                    input = input.replace("(P&P)", "P");
                } else if (input.contains("(S&S)")) {
                    input = input.replace("(S&S)", "S");
                } else {
                    System.out.println("INVALID");
                    break;
                }
            }
        } else {
            System.out.println("INVALID");
        }
        if (input.length() == 1) {
            System.out.println("VALID");
        }
        keyboard.close();
    }
}



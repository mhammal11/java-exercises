import java.util.Scanner;

public class StylizedCupcakeCostCalculator {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //taking the 4 inputs in a separate string for each
        String input1 = keyboard.next();
        String input2 = keyboard.next();
        String input3 = keyboard.next();
        String input4 = keyboard.next();


        //initialize variables
        int t = 0; //the number of cupcakes we are purchasing
        int k = 0; //the minimum number of cupcakes required to get the bulk discount
        double d = 0; //the price of each cupcake without discount
        double D = 0; //the price of each cupcake after discount

        //check all inputs to determine the value of each variable
        //checking input1
        if (input1.startsWith("t")) {
            t += Integer.parseInt(input1.substring(2));
        }
        else if (input1.startsWith("k")) {
            k += Integer.parseInt(input1.substring(2));
        }
        else if (input1.startsWith("d")) {
            d += Integer.parseInt(input1.substring(2));
        }
        else if (input1.startsWith("D")) {
            D += Integer.parseInt(input1.substring(2));
        }

        //checking input2
        if (input2.startsWith("t")) {
            t += Integer.parseInt(input2.substring(2));
        }
        else if (input2.startsWith("k")) {
            k += Integer.parseInt(input2.substring(2));
        }
        else if (input2.startsWith("d")) {
            d += Integer.parseInt(input2.substring(2));
        }
        else if (input2.startsWith("D")) {
            D += Integer.parseInt(input2.substring(2));
        }

        //checking input3
        if (input3.startsWith("t")) {
            t += Integer.parseInt(input3.substring(2));
        }
        else if (input3.startsWith("k")) {
            k += Integer.parseInt(input3.substring(2));
        }
        else if (input3.startsWith("d")) {
            d += Integer.parseInt(input3.substring(2));
        }
        else if (input3.startsWith("D")) {
            D += Integer.parseInt(input3.substring(2));
        }

        //checking input4
        if (input4.startsWith("t")) {
            t += Integer.parseInt(input4.substring(2));
        }
        else if (input4.startsWith("k")) {
            k += Integer.parseInt(input4.substring(2));
        }
        else if (input4.startsWith("d")) {
            d += Integer.parseInt(input4.substring(2));
        }
        else if (input4.startsWith("D")) {
            D += Integer.parseInt(input4.substring(2));
        }


        //initialize variables
        int price1 = 0;
        int price2 = 0;
        price1 = (int)(t*d);
        price2 = (int)(t*D);

        //output calculation
        if (t <= k) {
            //convert calculation to integer to account for doubles
            //convert calculation to string for formatting
            String noDiscount = Integer.toString(price1) + " Dollars";
            //add number signs that equal the number of characters in the second line
            String numberSigns = "*".repeat(noDiscount.length());
            System.out.println(numberSigns);
            System.out.println(noDiscount);
            System.out.println(numberSigns);
        } else {
            String discount = Integer.toString(price2) + " Dollars";
            String numberSigns2 = "*".repeat(discount.length());
            System.out.println(numberSigns2);
            System.out.println(discount);
            System.out.println(numberSigns2);
        }
    }
}

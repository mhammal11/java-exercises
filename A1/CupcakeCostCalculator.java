import java.util.Scanner;

public class CupcakeCostCalculator {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int t = keyboard.nextInt(); //the number of cupcakes we are purchasing
        int k = keyboard.nextInt(); //the minimum number of cupcakes required to get the bulk discount
        double d = keyboard.nextInt(); //the price of each cupcake without discount
        double D = keyboard.nextInt(); //the price of each cupcake after discount

        //calculation
        if (t <= k){
            System.out.println((int)(t * d));
        } else {
            System.out.println((int)(t * D));
        }
    }
}

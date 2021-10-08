/**
 * Title: hw6_1.java
 * Abstract: This program reads a positive integer number from a user and displays the reverse of the number.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 10/7/2021
 */
import java.util.Scanner;
public class hw6_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.print(reverse(num, 0));
    }
    public static int reverse(int number, int result) {
        if (number == 0) {
            return result;
        }
        result *= 10;
        result += number % 10;
        return reverse(number / 10, result);
    }
}
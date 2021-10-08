/**
 * Title: hw2_3.java
 * Abstract: This program reads a string and checks if it is a palindrome or not.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 09/09/2021
 */
import java.util.Scanner;
public class hw2_3 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        boolean isPalindrome = true;
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome ? "TRUE" : "FALSE");
    }
}
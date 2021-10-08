/**
 * Title: hw2_2.java
 * Abstract: This program reads two strings and checks if they are anagrams of each other or not.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 09/09/2021
 */
import java.util.Scanner;
import java.util.ArrayList;
public class hw2_2 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Character> chars = new ArrayList<>();
        String s1 = in.next();
        String s2 = in.next();
        boolean isAnagram = true;
        for (int i = 0; i < s1.length(); i++) {
            chars.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if (chars.remove(Character.valueOf(s2.charAt(i))) == false) {
                isAnagram = false;
                break;
            }
        }
        System.out.println(isAnagram ? "ANAGRAM" : "NO ANAGRAM");
    }
}
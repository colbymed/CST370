/**
 * Title: hw3_2.java
 * Abstract: This program reads in a set, and outputs corresponding representations of all possible subsets.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 09/16/2021
 */
import java.util.Scanner;
import java.util.ArrayList;
public class hw3_2 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        ArrayList<String> elements = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            elements.add(in.next());
        }
        for (int i = 0; i < Math.pow(2, count); i++) {
            System.out.print(i + ":");
            String binary = makeBinaryString(i, count);
            System.out.print(binary + ":");
            printCorresponding(elements, binary);
            System.out.println();
        }
    }
    public static String makeBinaryString(int decimal, int count) {
        String binary = "";
        if (count > 0) {
            while (decimal > 0) {
                binary = Integer.toString(decimal % 2) + binary;
                decimal = decimal / 2;
            }
            while (binary.length() < count) {
                binary = "0" + binary;
            }
        } else {
            binary = "0";
        }
        return binary;
    }
    public static void printCorresponding(ArrayList<String> elements, String binary) {
        boolean empty = true;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                empty = false;
                System.out.print(elements.get(i) + " ");
            }
        }
        if (empty) {
            System.out.print("EMPTY");
        }
    }
}
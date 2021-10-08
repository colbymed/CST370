/**
 * Title: hw3_1.java
 * Abstract: This program reads and adds two timestamps, and displays the final timestamp.
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 09/16/2021
 */
import java.util.Scanner;
public class hw3_1 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        String time1 = in.next();
        String time2 = in.next();
        int hours = Integer.valueOf(time1.substring(0,2)) + Integer.valueOf(time2.substring(0,2));
        int minutes = Integer.valueOf(time1.substring(3,5)) + Integer.valueOf(time2.substring(3,5));
        int seconds = Integer.valueOf(time1.substring(6,8)) + Integer.valueOf(time2.substring(6,8));
        if (seconds >= 60) {
            minutes++;
        }
        if (minutes >= 60) {
            hours++;
        }
        seconds %= 60;
        minutes %= 60;
        hours %= 24;
        System.out.printf("%02d:%02d:%02d%n", hours, minutes, seconds);
    }
}
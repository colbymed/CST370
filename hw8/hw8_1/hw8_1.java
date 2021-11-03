/**
 * Title: hw8_1.java
 * Abstract: This program partitions input values into negative and positive using two different approaches
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 10/28/2021
 */
import java.util.Scanner;
public class hw8_1 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] nums1 = new int[count];
        int[] nums2 = new int[count];
        for (int i = 0; i < count; i++) {
            int num = in.nextInt();
            nums1[i] = num;
            nums2[i] = num;
        }
        int i = 0;
        int j = nums1.length - 1;
        while (i < j) {
            if (nums1[i] > 0 && nums1[j] < 0) {
                int temp = nums1[i];
                nums1[i] = nums1[j];
                nums1[j] = temp;
                i++;
                j--;
            }
            else {
                if (nums1[i] < 0) {
                    i++;
                }
                if (nums1[j] > 0) {
                    j--;
                }
            }
        }
        int a = 0;
        int b = 1;
        while (b < nums2.length && a < nums2.length) {
            if (nums2[a] > 0 && nums2[b] < 0) {
                int temp = nums2[a];
                nums2[a] = nums2[b];
                nums2[b] = temp;
                a++;
                b++;
            }
            else {
                if (nums2[a] < 0) {
                    a++;
                }
                if (nums2[b] > 0 || b == a) {
                    b++;
                }
            }
        }
        for(int n : nums1) {
            System.out.print(n + " ");
        }
        System.out.println();
        for(int n : nums2) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
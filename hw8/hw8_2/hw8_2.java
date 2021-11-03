/**
 * Title: hw8_2.java
 * Abstract: This program performs various functions for a binary tree
 * Author: Colby Medeiros
 * ID: 2749
 * Date: 10/28/2021
 */
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class hw8_2 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int rootVal = in.nextInt();
        Node root = new Node(rootVal);
        int numCommands = in.nextInt();
        for (int i = 0; i < numCommands; i++) {
            switch (in.next()) {
                case "append":
                    append(root, in.nextInt());
                    break;
                case "isBST":
                    System.out.println(isBST(root));
                    break;
                case "height":
                    System.out.println(height(root));
                    break;
                case "findFirstNode":
                    System.out.println(findFirstNode(root).getData());
                    break;
                case "levelOrder":
                    System.out.println(levelOrder(root));
                    break;
                case "inOrder":
                    System.out.println(inOrder(root));
                    break;
                case "preOrder":
                    System.out.println(preOrder(root));
                    break;
                case "postOrder":
                    System.out.println(postOrder(root));
                    break;
                default:
                    break;
            }
        }
        in.close();
    }
    public static void append(Node root, int num) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current.getLeft() == null) {
                current.setLeft(num);
                break;
            }
            else {
                queue.add(current.getLeft());
            }
            if (current.getRight() == null) {
                current.setRight(num);
                break;
            }
            else {
                queue.add(current.getRight());
            }
        }
    }
    public static boolean isBST(Node root) {
        String[] arr = inOrder(root).split(" ");
        for (int i = 0; i < arr.length - 1; i++) {
            if (Integer.parseInt(arr[i]) > Integer.parseInt(arr[i + 1])) {
                return false;
            }
        }
        return true;
    }
    public static int height(Node root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }
    public static Node findFirstNode(Node root) {
        if (root.getLeft() == null) {
            return root;
        }
        else {
            return findFirstNode(root.getLeft());
        }
    }
    public static String levelOrder(Node root) {
        String output = "";
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current != null) {
                output += current.getData() + " ";
                queue.add(current.getLeft());
                queue.add(current.getRight());
            }
        }
        return output.trim();
    }
    public static String inOrder(Node root) {
        String output = "";
        if (root != null) {
            output += inOrder(root.getLeft()) + " ";
            output += root.getData() + " ";
            output += inOrder(root.getRight()) + " ";
            return output.trim();
        }
        else {
            return "";
        }
    }
    public static String preOrder(Node root) {
        String output = "";
        if (root != null) {
            output += root.getData() + " ";
            output += inOrder(root.getLeft()) + " ";
            output += inOrder(root.getRight()) + " ";
            return output.trim();
        }
        else {
            return "";
        }
    }
    public static String postOrder(Node root) {
        String output = "";
        if (root != null) {
            output += inOrder(root.getLeft()) + " ";
            output += inOrder(root.getRight()) + " ";
            output += root.getData() + " ";
            return output.trim();
        }
        else {
            return "";
        }
    }
}
class Node {
    private int data;
    private Node left;
    private Node right;
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public Node getLeft() {
        return this.left;
    }
    public void setLeft(int num) {
        setLeft(new Node(num));
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return this.right;
    }
    public void setRight(int num) {
        setRight(new Node(num));
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public int getData() {
        return this.data;
    }
    public void setData(int data) {
        this.data = data;
    }
}
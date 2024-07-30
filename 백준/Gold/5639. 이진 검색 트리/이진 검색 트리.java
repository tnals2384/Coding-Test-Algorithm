import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String k;
        while (true) {
            k = br.readLine();
            if (k == null || k.isEmpty()) break;

            int key = Integer.parseInt(k);
            insert(root, key);
        }

        postOrder(root);
    }

    public static void insert(Node cur, int key) {
        if (cur.key > key) {
            if (cur.left == null)
                cur.left = new Node(key);
            else insert(cur.left, key);
        } else {
            if (cur.right == null)
                cur.right = new Node(key);
            else insert(cur.right, key);
        }
    }

    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.key);
    }

}


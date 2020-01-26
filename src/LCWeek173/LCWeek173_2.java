import java.util.LinkedList;
import java.util.List;

public class LCWeek173_2 {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Node root = null;
        List<Integer> ret = new LinkedList<>();
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i][2] >= veganFriendly && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                root = insert(root, restaurants[i]);
            }
        }
        inOrder(root, ret);
        return ret;
    }

    private void inOrder(Node root, List<Integer> ret) {
        if (root != null) {
            inOrder(root.right, ret);
            ret.add(root.rest[0]);
            inOrder(root.left, ret);
        }
    }

    private class Node {
        int[] rest;
        Node left, right;

        Node(int[] r) {
            rest = r;
            left = null;
            right = null;
        }
    }

    private Node insert(Node curr, int[] rest) {
        if (curr==null) {
            return new Node(rest);
        } else if (curr.rest[1] > rest[1]) {
            curr.left = insert(curr.left, rest);
        } else if (curr.rest[1] < rest[1]) {
            curr.right = insert(curr.right,rest);
        } else {
            if (curr.rest[0] > rest[0]) {
                curr.left = insert(curr.left, rest);
            } else {
                curr.right = insert(curr.right, rest);
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        LCWeek173_2 ans = new LCWeek173_2();
        System.out.println(ans.filterRestaurants(new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}},1,50,10));
    }
}

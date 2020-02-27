import java.util.Arrays;

public class LC177_2 {
    boolean[] seen;
    int[] parent;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        seen = new boolean[n];
        parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                if (!dfs(i, leftChild, rightChild)) return false;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                return false;
            }
            if (parent[i]==-1) {
                if (count==1) return false;
                count++;
            }
        }
        return true;
    }

    boolean dfs(int i, int[] leftChild, int[] rightChild) {
        if (seen[i]) return false;
        seen[i] = true;
        if (leftChild[i]!=-1) {
            parent[leftChild[i]] = i;
            if (!dfs(leftChild[i], leftChild, rightChild)) return false;
        }
        if (rightChild[i]!=-1) {
            parent[rightChild[i]] = i;
            if (!dfs(rightChild[i], leftChild, rightChild)) return false;
        }
        return true;
    }
}

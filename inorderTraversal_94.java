import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class inorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentRoot = root;

        while (true) {
            while (currentRoot != null) {
                stack.add(currentRoot);
                currentRoot = currentRoot.left;
            }
            if (stack.isEmpty()) break;
            currentRoot = stack.pop();
            list.add(currentRoot.value);
            currentRoot = currentRoot.right;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        inorderTraversal_94 traversal = new inorderTraversal_94();
        List<Integer> result = traversal.inorderTraversal(root);

        System.out.println("Inorder Traversal: " + result);
    }
}

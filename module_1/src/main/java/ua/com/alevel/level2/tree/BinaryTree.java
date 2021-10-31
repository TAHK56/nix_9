package ua.com.alevel.level2.tree;

public class BinaryTree {

    private  TreeNode root;

    public BinaryTree(int val) {
        root = new TreeNode(val);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public  void insertNode(TreeNode node, int value) {
        if (value < node.getVal()) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode(value));
            } else {
                insertNode(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new TreeNode(value));
            } else {
                insertNode(node.getRight(), value);
            }
        }
    }
}

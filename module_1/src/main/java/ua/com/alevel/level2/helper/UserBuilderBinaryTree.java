package ua.com.alevel.level2.helper;

import ua.com.alevel.level2.tree.BinaryTree;
import ua.com.alevel.level1.validinput.InputUser;
import ua.com.alevel.level2.tree.TreeNode;

public class UserBuilderBinaryTree {

    public static void run() {
        System.out.println("Please input value for root:");
        String userValue = InputUser.checkInput();
        BinaryTree binaryTree = new BinaryTree(checkNumberNode(userValue));

        runNavigationBinaryTree();
        String userChoose = InputUser.checkInput();
        if (userChoose.equals("1")) {
            while (true) {
                System.out.println("Input value of node: ");
                binaryTree.insertNode(binaryTree.getRoot(), checkNumberNode(InputUser.checkInput()));
                System.out.println("Do you still go on insert: Y/N(or else)");
                String answer = InputUser.checkInput();
                if (!answer.equalsIgnoreCase("Y")) {
                    break;
                }
            }
        }
        System.out.println("The deep of my tree is: " + findDeep(binaryTree.getRoot()));
    }


    private static int checkNumberNode(String userInput) {
        while (!userInput.matches("^[+-]?\\d+$")) {
            System.out.println("Unfortunately you have chosen the incorrect symbol\n" +
                    "Try again");
            userInput = InputUser.checkInput();
        }
        return Integer.parseInt(userInput);
    }

    private static void runNavigationBinaryTree() {
        System.out.println("Please, choose something from my preview.\n" +
                "1-Insert Node\n" +
                "0(or another symbol)-Exit!!");
    }

    public static int findDeep(TreeNode root) {
        if (root == null) return 0;
        int nLeft = findDeep(root.getLeft());
        int nRight = findDeep(root.getRight());
        return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
    }

}

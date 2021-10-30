package ua.com.alevel.helper;

import ua.com.alevel.tree.BinaryTree;
import ua.com.alevel.tree.TreeNode;
import ua.com.alevel.validinput.InputUser;

public class UserBuilderBinaryTree {

    public static void run() {
        System.out.println("Please input value for root:");
        String userValue = InputUser.checkInput();
        BinaryTree binaryTree = new BinaryTree(checkNumberNode(userValue));

        runNavigationBinaryTree();
        String userChoose = InputUser.checkInput();
        switch (userChoose) {
            case "1":
                while (true) {
                    System.out.println("Input value of node: ");
                    binaryTree.insertNode(binaryTree.getRoot(), checkNumberNode(InputUser.checkInput()));
                    System.out.println("Do you still go on insert: Y/N(or else)");
                    String answer = InputUser.checkInput();
                    if (!answer.equalsIgnoreCase("Y")) {
                        break;
                    }
                }
            case "2":
                System.out.println("The deep of my tree is: " + findDeep(binaryTree.getRoot()));
                break;
            default:
                System.out.println("Maybe next time..");
                break;
        }
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
                "2-Find max deep\n" +
                "0(or another symbol)-Exit!!");
    }

    public static int findDeep(TreeNode root) {
        if (root == null) return 0;
        int nLeft = findDeep(root.getLeft());
        int nRight = findDeep(root.getRight());
        return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
    }

}

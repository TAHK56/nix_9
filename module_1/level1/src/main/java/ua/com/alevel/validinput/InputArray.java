package ua.com.alevel.validinput;

public class InputArray {

    public static int[] create() {
        System.out.println("Input the numbers of an array are divided by one space");
        System.out.println("For example: 1 4 5 1 1 3");
        String array = InputUser.checkInput();

        while (!array.matches("(^[+-]?\\d+)( [+-]?\\d+)+")){
            System.out.println("Please try again");
            array = InputUser.checkInput();
        }

        String[] ar = array.split(" ");
        int[] userArray = new int[ar.length];

        for (int i = 0; i < userArray.length; i++) {
            userArray[i] = Integer.parseInt(ar[i]);
        }

        return userArray;
    }
}

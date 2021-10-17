package ua.com.alevel;

import ua.com.alevel.file.ReverseString;

public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();

        preview();
        String inputNumber = userInput.checkInput();

        while (!inputNumber.equals("0")) {
            if (checkNumber(inputNumber)) {
                switch (inputNumber) {
                    case "1":
                        System.out.println("Enter string for reverse");
                        String reverseAllString = userInput.checkInput();
                        System.out.println("Result:");
                        System.out.println(ReverseString.reverse(reverseAllString));
                        break;
                    case "2":
                        System.out.println("Enter string and substring where first part string and second substring");
                        System.out.println("For example : hello world - this is string");
                        System.out.println("substring: ld");
                        String reverseString = userInput.checkInput();
                        String substringUser = userInput.checkInput();
                        System.out.println("Result:");
                        System.out.println(ReverseString.reverse(reverseString, substringUser));
                        break;
                    case "3":
                        System.out.println("Enter string , firstIndex, lastIndex");
                        System.out.println("For example : hello world - this is string");
                        System.out.println("firstIndex: 2");
                        System.out.println("lastIndex: 5");
                        String reverseStringWithIndex = userInput.checkInput();
                        String firstIndex = userInput.checkInput();
                        String lastIndex = userInput.checkInput();

                        if (firstIndex.matches("\\d") && lastIndex.matches("\\d")) {
                            int index1 = Integer.parseInt(firstIndex);
                            int index2 = Integer.parseInt(lastIndex);
                            if (index1 < index2 && index2 < reverseStringWithIndex.length()) {
                                System.out.println("Result:");
                                System.out.println(ReverseString.reverse(reverseStringWithIndex, index1, index2));
                            }

                        } else {
                            System.out.println("You inputted incorrect Indexes");
                        }
                        break;

                }

            } else {
                System.out.println("You have inputted the wrong number");
            }
            inputNumber = userInput.checkInput();
        }

    }

    private static void preview() {
        System.out.println("You can reverse a string: ");
        System.out.println("All string input 1:");
        System.out.println("All substring input 2:");
        System.out.println("All substring from the given firstIndex and LastIndex input 3:");
        System.out.println("If you want finish input 0");
    }

    private static boolean checkNumber(String src) {
        return src.length() == 1 && src.matches("[1-3]");
    }
}

package ua.com.alevel.validinput;

public class InputCell {

    public static String checkInputNotation() {
        final String NOTATION = "^[a-h][1-8]$";

        String userNotation = InputUser.checkInput();
        while (!userNotation.matches(NOTATION)) {
            System.out.println("Choose correct cell!! Try again");
            userNotation = InputUser.checkInput();
        }
        return userNotation;
    }

}

package ua.com.alevel;

import java.util.List;

public class ProgramRun {

    public static void run(List<TaskHelper> taskHelpers) {
        preview();
        UserInput userInput = new UserInput();
        String event = userInput.checkInput();

        while (!event.equals("0")) {
           if (checkNumberTask(event)) {
               taskHelpers.get(Integer.parseInt(event) - 1).run();
           } else {
               System.out.println("You have inputted the wrong number of task");
           }
           event = userInput.checkInput();
        }
    }

    private static void preview() {
        System.out.println("If you need first task, please select 1");
        System.out.println("If you need second task, please select 2");
        System.out.println("If you need exit task, please select 0");
        System.out.println("Select your event:");
    }

    private static boolean checkNumberTask(String task) {
        return task.length() == 1 && task.substring(0, 1).matches("[1-2]");
    }
}

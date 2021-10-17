package ua.com.alevel.lesson;

import ua.com.alevel.TaskHelper;
import ua.com.alevel.UserInput;

public class EndLesson implements TaskHelper {
    private final int LESSON_MINUTES = 45;
    private final int SHORT_BREAK_MINUTES = 5;
    private final int LONG_BREAK_MINUTES = 15;
    private final int HOUR = 60;
    private final int START_LESSON_IN_HOURS = 9;

    public void run() {
        System.out.println("Please input number a lesson from 1 to 10");
        UserInput userInput = new UserInput();

        String ourLesson = userInput.checkInput();
        while (!checkNumberLesson(ourLesson)) {
            System.out.println("You have inputted the incorrect lesson try again!!");
            ourLesson = userInput.checkInput();
        }
        showTime(Integer.parseInt(ourLesson));

    }

    private void showTime(int ourLesson) {
        int timeLessons = ourLesson * LESSON_MINUTES;
        int timeBreak = defineBreak(ourLesson);
        int endLesson = timeLessons + timeBreak;

        System.out.println("Our lesson is " + ourLesson);
        System.out.println("End Lesson is " + (START_LESSON_IN_HOURS + endLesson / HOUR) + ":" + (endLesson % HOUR));
    }

    private int defineBreak(int lesson) {
        if (lesson == 1) return 0;
        int breakLesson = lesson % 2 == 0 ? SHORT_BREAK_MINUTES : LONG_BREAK_MINUTES;
        return breakLesson + defineBreak(--lesson);
    }

    private boolean checkNumberLesson(String lesson) {
        return (lesson.substring(0, 1).matches("[1-9]") && lesson.length() == 1) || lesson.equals("10");
    }
}

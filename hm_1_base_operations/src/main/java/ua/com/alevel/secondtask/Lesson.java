package ua.com.alevel.secondtask;

public class Lesson {
    private final int LESSON_MINUTES = 45;
    private final int SHORT_BREAK_MINUTES = 5;
    private final int LONG_BREAK_MINUTES = 15;
    private final int HOUR = 60;
    private final int START_LESSON_IN_HOURS = 9;

    public void begin() {
        UserConsole userConsole = new UserConsole();
        int ourLesson = userConsole.inputLesson();

        showTime(ourLesson);
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
}

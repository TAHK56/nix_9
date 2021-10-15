package ua.com.alevel.secondtask;

public class Lesson {
    public static final int LESSON_MINUTES = 45;
    public static final int SHORT_BREAK_MINUTES = 5;
    public static final int LONG_BREAK_MINUTES = 15;
    public static final int HOUR = 60;
    public static final int START_LESSON_IN_HOURS = 9;

    public static void main(String[] args) {
        UserConsole userConsole = new UserConsole();
        int ourLesson = userConsole.inputLesson();

        int timeLessons = ourLesson * LESSON_MINUTES;
        int timeBreak = defineBreak(ourLesson);

        int endLesson = timeLessons + timeBreak;

        System.out.println("Our lesson is " + ourLesson);
        System.out.println("End Lesson is " + (START_LESSON_IN_HOURS + endLesson / HOUR) + ":" + (endLesson % HOUR));

    }

    static int defineBreak(int lesson) {
        if (lesson == 1) return 0;
        int breakLesson = lesson % 2 == 0 ? SHORT_BREAK_MINUTES : LONG_BREAK_MINUTES;
        return breakLesson + defineBreak(--lesson);
    }
}

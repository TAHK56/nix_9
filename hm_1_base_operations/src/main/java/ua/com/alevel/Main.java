package ua.com.alevel;

import ua.com.alevel.lesson.EndLesson;
import ua.com.alevel.symbol.FinderSymbols;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        List<TaskHelper> listTasks = new ArrayList<>();
        listTasks.add(new FinderSymbols());
        listTasks.add(new EndLesson());

        ProgramRun.run(listTasks);
    }
}

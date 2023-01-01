package service;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private static final int HISTORY_SIZE = 10;

    private List<Task> viewHistory = new ArrayList<>();

    @Override
    public void add(Task task) {
        if (viewHistory.size() > HISTORY_SIZE) {
            viewHistory.remove(0);
            viewHistory.add(task);
        } else {
            viewHistory.add(task);
        }
    }

    @Override
    public List<Task> getHistory() {
        return viewHistory;
    }
}

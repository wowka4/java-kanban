package service;

import model.Epic;
import model.Subtask;
import model.Task;

public interface TaskManager {
    void printAllTask();

    void removeAllTasks();

    void getById(int id);

    void removeById(int id);

    void createEpic(String name, String description);

    void createTask(String name, String description);

    void createSubtask(String name, String description, int epicID);

    void updateTask(Task task);

    void updateEpic(Epic epic);

    void updateSubtask(Subtask subtask);

    void getHistory();

    void getSubtasksByEpic(int epicId);
}

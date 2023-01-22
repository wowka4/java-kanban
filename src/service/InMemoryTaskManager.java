package service;

import model.Epic;
import model.Status;
import model.Subtask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryTaskManager implements TaskManager {
    private HistoryManager historyManager = Managers.getDefaultHistory();
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private int nextId = 1;

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public Epic getEpic(int id) {
        return epics.get(id);
    }

    public Subtask getSubtask(int id) {
        return subtasks.get(id);
    }

    @Override
    public void createEpic(String name, String description) {
        Epic epicObject = new Epic(nextId, name, description, Status.NEW);
        epics.put(nextId++, epicObject);
    }

    @Override
    public void createTask(String name, String description) {
        Task taskObject = new Task(nextId, name, description, Status.NEW);
        tasks.put(nextId++, taskObject);
    }

    @Override
    public void createSubtask(String name, String description, int epicID) {
        Subtask subtaskObject = new Subtask(nextId, name, description, Status.NEW, epicID);
        subtasks.put(nextId, subtaskObject);
        epics.get(epicID).addSubtaskId(nextId++);
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateEpic(Epic epic) {
        Status newStatus = null;
        for (int i = 0; i < epic.getSubtaskIds().size(); i++) {
            int id = epic.getSubtaskIds().get(i);
            if (subtasks.get(id).getStatus() == Status.DONE) {
                newStatus = Status.DONE;
            } else if (subtasks.get(id).getStatus() == Status.IN_PROGRESS) {
                newStatus = Status.IN_PROGRESS;
            } else {
                newStatus = Status.NEW;
            }
        }
        Epic epicNew = new Epic(epic.getId(), epic.getName(), epic.getDescription(), newStatus);
        for (int i = 0; i < epic.getSubtaskIds().size(); i++) {
            int id = epic.getSubtaskIds().get(i);
            epicNew.addSubtaskId(id);
        }
        epics.put(epic.getId(), epicNew);
    }

    @Override
    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
    }

    @Override
    public void printAllTask() {
        for (Integer key : tasks.keySet()) {
            System.out.println(tasks.get(key));
        }
        for (Integer key : epics.keySet()) {
            System.out.println(epics.get(key));
            for (int i = 0; i < epics.get(key).getSubtaskIds().size(); i++) {
                int id = epics.get(key).getSubtaskIds().get(i);
                System.out.println(subtasks.get(id));
            }
        }
    }

    @Override
    public void removeAllTasks() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

    @Override
    public void getById(int id) {
        if (tasks.containsKey(id)) {
            historyManager.add(tasks.get(id));
            System.out.println(tasks.get(id));
        } else if (epics.containsKey(id)) {
            historyManager.add(epics.get(id));
            System.out.println(epics.get(id));
        } else if (subtasks.containsKey(id)) {
            historyManager.add(subtasks.get(id));
            System.out.println(subtasks.get(id));
        } else {
            System.out.println("Идентификатор не найден");
        }
    }

    @Override
    public void removeById(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            historyManager.remove(id);
        } else if (epics.containsKey(id)) {
            removeSubtasksByEpicId(id);
            epics.remove(id);
            historyManager.remove(id);
        } else if (subtasks.containsKey(id)) {
            subtasks.remove(id);
            historyManager.remove(id);
        } else {
            System.out.println("Идентификатор не найден");
        }
    }

    public void removeSubtasksByEpicId(int id) {
        for (Integer integer : epics.get(id).getSubtaskIds()) {
            historyManager.remove(integer);
            subtasks.remove(integer);
        }
    }

    @Override
    public void getSubtasksByEpic(int epicId) {
        ArrayList<Integer> subsId = epics.get(epicId).getSubtaskIds();
        for (Integer number : subsId) {
            System.out.println(subtasks.get(number));
        }
    }

    @Override
    public void getHistory() {
        System.out.println(historyManager.getTasks());
    }
}

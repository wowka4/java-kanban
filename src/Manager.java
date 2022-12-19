import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    HashMap<Integer, Task> task = new HashMap<>();
    HashMap<Integer, Epic> epic = new HashMap<>();
    HashMap<Integer, Subtask> subtask = new HashMap<>();
    protected int nextId = 1;

    public void createEpic(String name, String description) {
        Epic epicObject = new Epic(nextId, name, description, "NEW");
        epic.put(nextId++, epicObject);
    }

    public void createTask(String name, String description) {
        Task taskObject = new Task(nextId, name, description, "NEW");
        task.put(nextId++, taskObject);
    }

    public void createSubtask(String name, String description, int idOfTask) {
        Subtask subtaskObject = new Subtask(nextId, name, description, "NEW", idOfTask);
        subtask.put(nextId, subtaskObject);
        epic.get(idOfTask).addIdOfSubtask(nextId++);
    }

    public void updateTask(Task task1) {
        task.put(task1.getId(), task1);
    }

    public void updateEpic(Epic epic1) {
        String newStatus = "";
        for (int i = 0; i < epic1.idsSubtasks.size(); i++) {
            int id = epic1.idsSubtasks.get(i);
            if (subtask.get(id).status.equals("DONE")) {
                newStatus = "DONE";
            } else if (subtask.get(id).status.equals("IN_PROGRESS")) {
                newStatus = "IN_PROGRESS";
            } else {
                newStatus = "NEW";
            }
        }
        Epic epicNew = new Epic(epic1.getId(), epic1.getName(), epic1.getDescription(), newStatus);
        for (int i = 0; i < epic1.idsSubtasks.size(); i++) {
            int id = epic1.idsSubtasks.get(i);
            epicNew.addIdOfSubtask(id);
        }
        epic.put(epic1.getId(), epicNew);
    }

    public void updateSubtask(Subtask subtask1) {
        subtask.put(subtask1.getId(), subtask1);
    }

    public void printAllTask() {
        for (Integer key : task.keySet()) {
            System.out.println(task.get(key));
        }
        for (Integer key : epic.keySet()) {
            System.out.println(epic.get(key));
            for (int i = 0; i < epic.get(key).idsSubtasks.size(); i++) {
                int id = epic.get(key).idsSubtasks.get(i);
                System.out.println(subtask.get(id));
            }
        }
    }

    public void removeAllTasks() {
        task.clear();
        epic.clear();
        subtask.clear();
    }

    public void getById(int id) {
        if (task.containsKey(id)) {
            System.out.println(task.get(id));
        } else if (epic.containsKey(id)) {
            System.out.println(epic.get(id));
        } else if (subtask.containsKey(id)) {
            System.out.println(subtask.get(id));
        } else {
            System.out.println("Идентификатор не найден");
        }
    }

    public void removeById(int id) {
        if (task.containsKey(id)) {
            task.remove(id);
        } else if (epic.containsKey(id)) {
            epic.remove(id);
        } else if (subtask.containsKey(id)) {
            subtask.remove(id);
        } else {
            System.out.println("Идентификатор не найден");
        }
    }

    public void getSubtasksByEpic(int epicId) {
        ArrayList<Integer> subsId = epic.get(epicId).getIdsSubtasks();
        for (Integer number : subsId) {
            System.out.println(subtask.get(number));
        }
    }
}

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private HashMap<Integer, Task> task = new HashMap<>();
    private HashMap<Integer, Epic> epic = new HashMap<>();
    private HashMap<Integer, Subtask> subtask = new HashMap<>();
    protected int nextId = 1;

    public void createEpic(String name, String description) {
        Epic epicObject = new Epic(nextId, name, description, "NEW");
        epic.put(nextId++, epicObject);
    }

    public void createTask(String name, String description) {
        Task taskObject = new Task(nextId, name, description, "NEW");
        task.put(nextId++, taskObject);
    }

    public void createSubtask(String name, String description, int epicID) {
        Subtask subtaskObject = new Subtask(nextId, name, description, "NEW", epicID);
        subtask.put(nextId, subtaskObject);
        epic.get(epicID).addSubtaskId(nextId++);
    }

    public void updateTask(Task newTask) {  //если без цифр, то тогда этот параметр у меня перекликается с полем класса
        task.put(newTask.getId(), newTask); // и при попытке положить элемент в коллекцию у меня активируется не поле класса,
        // а именно этот параметр. А так как я часто использую поле класса,очень неудобно будет его по другому назвать
        // переназвал его newTask, может так лучше? Или лучше все-таки поменять на task  и переназвать поле класса?
    }

    public void updateEpic(Epic newEpic) {
        String newStatus = "";
        for (int i = 0; i < newEpic.getSubtaskIds().size(); i++) {
            int id = newEpic.getSubtaskIds().get(i);
            if (subtask.get(id).status.equals("DONE")) {
                newStatus = "DONE";
            } else if (subtask.get(id).status.equals("IN_PROGRESS")) {
                newStatus = "IN_PROGRESS";
            } else {
                newStatus = "NEW";
            }
        }
        Epic epicNew = new Epic(newEpic.getId(), newEpic.getName(), newEpic.getDescription(), newStatus);
        for (int i = 0; i < newEpic.getSubtaskIds().size(); i++) {
            int id = newEpic.getSubtaskIds().get(i);
            epicNew.addSubtaskId(id);
        }
        epic.put(newEpic.getId(), epicNew);
    }

    public void updateSubtask(Subtask newSubtask) {
        subtask.put(newSubtask.getId(), newSubtask);
    }

    public void printAllTask() {
        for (Integer key : task.keySet()) {
            System.out.println(task.get(key));
        }
        for (Integer key : epic.keySet()) {
            System.out.println(epic.get(key));
            for (int i = 0; i < epic.get(key).getSubtaskIds().size(); i++) {
                int id = epic.get(key).getSubtaskIds().get(i);
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
        ArrayList<Integer> subsId = epic.get(epicId).getSubtaskIds();
        for (Integer number : subsId) {
            System.out.println(subtask.get(number));
        }
    }
}

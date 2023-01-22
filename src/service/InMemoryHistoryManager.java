package service;

import model.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private Node tail;
    private int size = 0;
    private HashMap<Integer, Node> nodes = new HashMap<>();

    public void add(Task task) {
        if (nodes.containsKey(task.getId())) {
            removeNode(nodes.get(task.getId()));
            nodes.remove(task.getId());
        }
        nodes.put(task.getId(), linkLast(task));
    }

    public Node linkLast(Task task) {
        Node newNode = new Node(null, task, null);
        if (!nodes.isEmpty()) {
            Node oldTail = tail;
            newNode.prevTask = oldTail;
            oldTail.nextTask = newNode;
        }
        tail = newNode;
        size++;
        return newNode;
    }

    public void removeNode(Node node) {
        if (node.nextTask == null) {
            tail = node.prevTask;
            tail.nextTask = null;
        } else if (node.prevTask == null) {
            node.nextTask.prevTask = null;
            node.nextTask = null;
        } else {
            node.nextTask.prevTask = node.prevTask;
            node.prevTask.nextTask = node.nextTask;
        }
    }

    @Override
    public void remove(int id) {
        removeNode(nodes.get(id));
        nodes.remove(id);
    }

    public List<Task> getTasks() {
        List<Task> viewHistory = new ArrayList<>();
        Node node = tail;
        while (node != null) {
            viewHistory.add(node.data);
            node = node.prevTask;
        }
        return viewHistory;
    }
}

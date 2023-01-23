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

    private Node linkLast(Task task) {
        Node newNode = new Node(null, task, null);
        if (!nodes.isEmpty()) {
            Node oldTail = tail;
            newNode.setPrevTask(oldTail);
            oldTail.setNextTask(newNode);
        }
        tail = newNode;
        size++;
        return newNode;
    }

    private void removeNode(Node node) {
        if (node.getNextTask() == null) {
            if (node.getPrevTask() == null) {
                tail = null;
                return;
            }
            tail = node.getPrevTask();
            tail.setNextTask(null);
        } else if (node.getPrevTask() == null) {
            node.getNextTask().setPrevTask(null);
            node.setNextTask(null);
        } else {
            node.getPrevTask().setNextTask(node.getNextTask());
            node.getNextTask().setPrevTask(node.getPrevTask());
        }
    }

    @Override
    public void remove(int id) {
        if (nodes.containsKey(id)) {
            removeNode(nodes.get(id));
            nodes.remove(id);
        }
    }

    public List<Task> getTasks() {
        List<Task> viewHistory = new ArrayList<>();
        if (!nodes.isEmpty()) {
            Node node = tail;
            while (node != null) {
                viewHistory.add(node.getData());
                node = node.getPrevTask();
            }
        }
        return viewHistory;
    }
}

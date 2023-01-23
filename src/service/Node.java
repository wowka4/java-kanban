package service;

import model.Task;

public class Node {
    private Node prevTask;
    private Task data;
    private Node nextTask;


    public Node(Node prevTask, Task data, Node nextTask) {
        this.prevTask = prevTask;
        this.data = data;
        this.nextTask = nextTask;
    }

    public Node getPrevTask() {
        return prevTask;
    }

    public void setPrevTask(Node prevTask) {
        this.prevTask = prevTask;
    }

    public Task getData() {
        return data;
    }

    public void setData(Task data) {
        this.data = data;
    }

    public Node getNextTask() {
        return nextTask;
    }

    public void setNextTask(Node nextTask) {
        this.nextTask = nextTask;
    }
}


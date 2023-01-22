package service;

import model.Task;

public class Node {
    public Node prevTask;
    public Task data;
    public Node nextTask;


    public Node(Node prevTask, Task data, Node nextTask) {
        this.prevTask = prevTask;
        this.data = data;
        this.nextTask = nextTask;
    }
}


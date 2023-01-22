import model.Task;
import service.Managers;
import service.TaskManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();
        taskManager.createEpic("Privet", "Hello");
        taskManager.createEpic("Buy some food", "I am gonna buy next food");
        taskManager.createSubtask("Orange", "3 ripe orange", 2);
        taskManager.createSubtask("Cucumbers", "2 cucumbers with pimples", 2);
        taskManager.createSubtask("Apples", " 4 red apples", 2);

        taskManager.getById(1);
        taskManager.getById(2);
        taskManager.getById(3);
        taskManager.getById(4);
        taskManager.getById(5);
        taskManager.getById(5);
        taskManager.getById(2);
        System.out.println();
        System.out.println(" Get History ");
        taskManager.getHistory();
        System.out.println();

        System.out.println("Deleted Epic\n");
        taskManager.removeById(2);
        System.out.println(" Get History ");
        taskManager.getHistory();


    }
}
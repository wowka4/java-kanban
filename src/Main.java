import model.Task;
import service.Managers;
import service.TaskManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = Managers.getDefault();
        taskManager.createEpic("Встретиться с другом", "Литейный 21 в 16:00");
        taskManager.createEpic("Купить еды", "Зайти в Магнит");
        taskManager.createSubtask("Хлеб", "Черный", 2);
        taskManager.createSubtask("Апельсины", "2 кг", 2);
        taskManager.createSubtask("Мороженое", "Шоколадное и клубничное", 2);

        taskManager.getById(1);
        taskManager.getById(2);
        System.out.println();
        System.out.println("Получить историю");
        taskManager.getHistory();
        System.out.println();

        taskManager.removeById(2);
        System.out.println("Удален эпик под номером 2");
        System.out.println("Получить историю");
        taskManager.getHistory();
    }
}
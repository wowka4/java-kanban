import service.Managers;
import service.TaskManager;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();

        taskManager.createTask("Купить еды", "Купить вкусной еды в магазине");
        taskManager.createTask("Купить воды", "Купить чистой воды в магазине");
        taskManager.createEpic("Купить авто", "Купить седан или хэтчбек");
        taskManager.createEpic("Деньги на авто", "Заработать деньги на авто");
        taskManager.createSubtask("Пойти в автосалон", "Посетить не менее 3-х автосалонов", 3);
        taskManager.createSubtask("Торговаться", "Просить менеджеров дать скидку, " +
                "потому что ты потратил все деньги на учебу java-разработке", 3);
        taskManager.createSubtask("Яблоки", "Купить яблоко за рубль, а продать его за два. " +
                "Написать цикл while, и повторять его пока не накопится нужная сумма на авто.", 4);

        taskManager.getById(1);
        taskManager.getById(2);
        taskManager.getById(3);
        taskManager.getById(4);
        taskManager.getById(5);
        taskManager.getById(6);



    }
}
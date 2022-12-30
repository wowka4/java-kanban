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
        taskManager.createEpic("8", "8");
        taskManager.createTask("9", "9");
        taskManager.createSubtask("10", "10", 8);
        taskManager.createEpic("11", "11");
        taskManager.createEpic("12", "12");
        taskManager.createEpic("13", "12");
        taskManager.createEpic("14", "12");
        taskManager.createEpic("15", "12");
        taskManager.createEpic("16", "12");
        taskManager.createEpic("17", "12");
        taskManager.createEpic("18", "12");
        taskManager.createEpic("19", "12");
        taskManager.createEpic("20", "12");
        taskManager.createEpic("21", "12");

        taskManager.getById(1);
        taskManager.getById(2);
        taskManager.getById(3);
        taskManager.getById(4);
        taskManager.getById(5);
        taskManager.getById(6);
        taskManager.getById(7);
        taskManager.getById(8);
        taskManager.getById(9);
        taskManager.getById(2);
        taskManager.getById(10);
        taskManager.getById(11);
        taskManager.getById(12);
        taskManager.getById(13);
        taskManager.getById(14);
        taskManager.getById(15);
        taskManager.getById(16);
        taskManager.getById(17);
        taskManager.getById(18);
        taskManager.getById(19);
        taskManager.getById(20);
        taskManager.getById(21);

        System.out.println("\n");
        System.out.println("History");
        taskManager.getHistory();

    }
}
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.createTask("Купить еды", "Купить вкусной еды в магазине");
        manager.createTask("Купить воды", "Купить чистой воды в магазине");
        manager.createEpic("Купить авто", "Купить седан или хэтчбек");
        manager.createEpic("Деньги на авто", "Заработать деньги на авто");
        manager.createSubtask("Пойти в автосалон", "Посетить не менее 3-х автосалонов", 3);
        manager.createSubtask("Торговаться", "Просить менеджеров дать скидку, " +
                "потому что ты потратил все деньги на учебу java-разработке", 3);
        manager.createSubtask("Яблоки", "Купить яблоко за рубль, а продать его за два. " +
                "Написать цикл while, и повторять его пока не накопится нужная сумма на авто.", 4);
        manager.updateEpic(manager.getEpic(3));

       manager.printAllTask();
    }
}
package ru.job4j.tracker;

/**
 * StartUI- start file
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 2.2
 * @version 1.0
 * @since 17.10.2018
 */
public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDE_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * method main - start of programm
     *
     * @param args - nothing
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    /**
     * method init - основное меню в консоли
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню  ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDE_BY_ID.equals(answer)) {
                this.findById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * method showMenu - показывает меню в конслои
     */
    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select");
        System.out.println();
    }

    /**
     * method createItem -запрашивает все параметры и добавляет заявку
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки ");
        String desc = this.input.ask("Введите описание заявки ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId  " + item.getId() + "  принята -----------");
    }

    /**
     * method showAllItems - выводит на консоль все имеющиеся заявки
     */
    private void showAllItems() {
        System.out.println("-------- List of all Items -------------------------");
        Item[] allItem = tracker.findAll();
        int count = 0;
        for (Item item : allItem) {
            System.out.println(" № по порядку " + (++count) + " id: " + item.getId());
            System.out.println(" Name " + item.getName());
            System.out.println(" Содержание: " + item.getDesctiption());
            System.out.println("---------------------------------------------------------");
        }
        System.out.println("===============================================================");
        System.out.println();
    }

    /**
     * method editItem запрашивает данные и изменяет заявку
     */
    private void editItem() {
        System.out.println("------------ Изменение  заявки --------------");
        String id = this.input.ask("Введите id  заявки которую нужно изменить ");

        String name = this.input.ask("Введите новое имя заявки ");
        String desc = this.input.ask("Введите новое описание заявки ");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println("------------ Обновление заявки  с id  " + item.getId() + "  выполненно -----------");
    }

    /**
     * method deleteItem - запрашивает данные и удаляет заявку по id
     */
    private void deleteItem() {
        System.out.println("------------ Удаление  заявки --------------");
        String id = this.input.ask("Введите id  заявки которую нужно удалить ");
        this.tracker.delete(id);
        System.out.println("------------ Заявка с id " + id + " удалена -----------");
    }

    /**
     * method findById запрашивает id выводит на консоль найденую заявку
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id  заявки которую нужно найти ");
        Item foundItemId = tracker.findById(id);
        System.out.println(" id: " + foundItemId.getId());
        System.out.println(" Name " + foundItemId.getName());
        System.out.println(" Содержание: " + foundItemId.getDesctiption());
        System.out.println("---------------------------------------------------------");
        System.out.println("===============================================================");
        System.out.println();
    }

    /**
     * method findByName запрашивает имя и выводит на консоль все найденые заявки
     */
    private void findByName() {
        System.out.println("------------ Поиск заявки по name --------------");
        String name = this.input.ask("Введите name  заявки которую нужно найти ");
        System.out.println("-------- List  Items by Name -------------------------");
        Item[] allItem = tracker.findByName(name);
        int count = 0;
        for (Item item : allItem) {
            System.out.println(" № по порядку " + (++count) + " id: " + item.getId());
            System.out.println(" Name " + item.getName());
            System.out.println(" Содержание: " + item.getDesctiption());
            System.out.println("---------------------------------------------------------");
        }
        System.out.println("===============================================================");
        System.out.println();
    }


}

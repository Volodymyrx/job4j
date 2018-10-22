package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuTracker
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.1
 * @version 1.4
 * @since 22.10.2018
 */
public class MenuTracker {
    /**
     *  хранит ссылку на объект .
     */
    private Input input;
    /**
     *  хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new MenuTracker.EditItem());
        this.actions.add(new MenuTracker.DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new ExitProgram());
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        System.out.println("Menu");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.key() + ". " + action.info());
            }
        }
        System.out.println("Select: ");
    }

    /**
     * AddItem  -запрашивает все параметры и добавляет заявку
     */
    public class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        /**
         * method  -запрашивает все параметры и добавляет заявку
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки ");
            String desc = input.ask("Введите описание заявки ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId  " + item.getId() + "  принята -----------");
        }

        @Override
        public String info() {
            return "Add new Item";
        }
    }

    /**
     * ShowItems выводит на консоль все имеющиеся заявки
     */
    public class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        /**
         * method  - выводит на консоль все имеющиеся заявки
         */
        @Override
        public void execute(Input input, Tracker tracker) {
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

        @Override
        public String info() {
            return "Show all items";
        }
    }

    /**
     * FindItemById запрашивает id выводит на консоль найденую заявку
     */
    public class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        /**
         * method  запрашивает id выводит на консоль найденую заявку
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id  заявки которую нужно найти ");
            Item foundItemId = tracker.findById(id);
            System.out.println(" id: " + foundItemId.getId());
            System.out.println(" Name " + foundItemId.getName());
            System.out.println(" Содержание: " + foundItemId.getDesctiption());
            System.out.println("---------------------------------------------------------");
            System.out.println("===============================================================");
            System.out.println();
        }

        @Override
        public String info() {
            return "Find item by Id";
        }
    }

    /**
     * FindItemByName запрашивает имя и выводит на консоль все найденые заявки
     */
    public class FindItemsByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        /**
         * method  запрашивает имя и выводит на консоль все найденые заявки
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по name --------------");
            String name = input.ask("Введите name  заявки которую нужно найти ");
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

        @Override
        public String info() {
            return "Find items by name";
        }
    }

    /**
     * ExitProgram запрашивает подтверждение на выход из программы
     */
    public class ExitProgram implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        /**
         * method запрашивает подтверждение на выход из программы
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            StartUI.stay = !("y".equals(input.ask("Do you realy want ot Exit? (y/n):  ")));
        }

        @Override
        public String info() {
            return "Exit Program";
        }
    }

    /**
     * EditItem запрашивает данные и изменяет заявку
     */
    public static class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
        }

        /**
         * method  запрашивает данные и изменяет заявку
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Изменение  заявки --------------");
            String id = input.ask("Введите id  заявки которую нужно изменить ");

            String name = input.ask("Введите новое имя заявки ");
            String desc = input.ask("Введите новое описание заявки ");
            Item item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println("------------ Обновление заявки  с id  " + item.getId() + "  выполненно -----------");
        }

        @Override
        public String info() {
            return "Edit item";
        }
    }

    /**
     * DeleteItem - запрашивает данные и удаляет заявку по id
     */
    public static class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        /**
         * method - запрашивает данные и удаляет заявку по id
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление  заявки --------------");
            String id = input.ask("Введите id  заявки которую нужно удалить ");
            tracker.delete(id);
            System.out.println("------------ Заявка с id " + id + " удалена -----------");
        }

        @Override
        public String info() {
            return "Delete item";
        }
    }


}
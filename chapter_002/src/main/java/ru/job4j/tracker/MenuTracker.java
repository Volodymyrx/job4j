package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * MenuTracker
 * part of project tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.2 lesson 004.1.2
 * @version 2.0
 * @since 21.01.2019
 */
public class MenuTracker {
    /**
     * System.out.printf
     */
    private final Consumer<String> output;
    /**
     * хранит ссылку на объект .
     */
    private Input input;
    /**
     * хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();
    /**
     * хранит  массив c номерами UserAction.
     */
    private List<Integer> range = new ArrayList<>();
    /**
     * temp parametr for Exit
     */
    private boolean stay = true;
    /**
     * array списка номеров действий
     */
    private int[] numberAnswer;

    /**
     * string for GUI
     */
    private final String lineShort = String.format("%0" + 15 + "d", 0).replace("0", "_");
    private final String lineLong = String.format("%0" + 50 + "d", 0).replace("0", "_");
    private final String lineLongDouble = String.format("%0" + 50 + "d", 0).replace("0", "=");


    /**
     * getter списка номеров действий
     */
    public int[] getNumberAnswer() {
        return this.numberAnswer;
    }

    /**
     * getter array списка номеров действий
     */
    public List<Integer> getRange() {
        return range;
    }

    /**
     * getter for boolean stay
     *
     * @return stay boolean
     */
    public boolean isStay() {
        return stay;
    }

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод заполняет массив действий
     * загрузка массива списка номеров действий
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new EditItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
        this.numberAnswer = new int[this.actions.size()];
        for (int i = 0; i < this.actions.size(); i++) {
            this.range.add(i);
            this.numberAnswer[i] = i;
        }
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute();
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        output.accept(String.format("Menu%n"));
        for (UserAction action : this.actions) {
            if (action != null) {
//                System.out.println(action.info());
                this.output.accept(String.format("%s%n", action.info()));
            }
        }
        this.output.accept(String.format("%s%n", "Select: "));
    }

    /**
     * Метод выводит на экран строку слева и справа прочерки
     *
     * @param title -title string
     */
    private void printTitle(String title) {
        this.output.accept(String.format("%s %s %s%n ", lineShort, title, lineShort));
    }

    /**
     * Метод проверяет есть ли заявка с таким id
     *
     * @param id - id of item
     * @return true if is
     */
    private boolean isId(String id) {
        boolean result = false;
        for (Item item : tracker.getItems()) {
            if ((item != null) && (id.equals(item.getId()))) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * AddItem  -запрашивает все параметры и добавляет заявку
     */
    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        /**
         * method  -запрашивает все параметры и добавляет заявку
         */
        @Override
        public void execute() {
            printTitle("Добавление новой заявки");
            String name = input.ask("Введите имя заявки ");
            String desc = input.ask("Введите описание заявки ");
            Item item = new Item(name, desc);
            tracker.add(item);
            printTitle("Новая заявка с getId  " + item.getId() + "  принята");
        }
    }

    /**
     * ShowItems выводит на консоль все имеющиеся заявки
     */
    public class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }

        /**
         * method  - выводит на консоль все имеющиеся заявки
         */
        @Override
        public void execute() {
            printTitle("List of all Items");
            List<Item> allItem = tracker.findAll();
            int count = 0;
            for (Item item : allItem) {
                output.accept(String.format(" № по порядку %d id: %s%n Name %s%n Содержание: %s%n%s%n",
                        ++count, item.getId(), item.getName(), item.getDesctiption(), lineLong));
            }
            output.accept(String.format("%s%n%n", lineLongDouble));
        }
    }

    /**
     * FindItemById запрашивает id выводит на консоль найденую заявку
     */
    public class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        /**
         * method  запрашивает id выводит на консоль найденую заявку
         */
        @Override
        public void execute() {
            printTitle("Поиск заявки по id");
            String id = input.ask("Введите id  заявки которую нужно найти ");
            if (isId(id)) {
                Item foundItemId = tracker.findById(id);
                output.accept(String.format("id: %s%n Name %s%n Содержание: %s%n%s%n",
                        foundItemId.getId(), foundItemId.getName(), foundItemId.getDesctiption(), lineLong));
                output.accept(String.format("%s%n%n", lineLongDouble));
            } else {
                output.accept(String.format("Item whith id %s is not found.%n%s%n%n", id, lineLongDouble));
            }
        }
    }

    /**
     * FindItemByName запрашивает имя и выводит на консоль все найденые заявки
     */
    public class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        /**
         * method  запрашивает имя и выводит на консоль все найденые заявки
         */
        @Override
        public void execute() {
            printTitle("Поиск заявки по name");
            String name = input.ask("Введите name  заявки которую нужно найти ");
            printTitle("List  Items by Name");
            List<Item> allItem = tracker.findByName(name);
            int count = 0;
            for (Item item : allItem) {
                output.accept(String.format(" № по порядку %d id: %s%n Name %s%n Содержание: %s%n%s%n",
                        ++count, item.getId(), item.getName(), item.getDesctiption(), lineLong));
            }
            output.accept(String.format("%s%n%n", lineLongDouble));
        }
    }

    /**
     * ExitProgram запрашивает подтверждение на выход из программы
     */
    public class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        /**
         * method запрашивает подтверждение на выход из программы
         */
        @Override
        public void execute() {
            stay = !("y".equals(input.ask("Do you realy want ot Exit? (y/n):  ")));
        }
    }

    /**
     * EditItem запрашивает данные и изменяет заявку
     */
    public class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        /**
         * method  запрашивает данные и изменяет заявку
         */
        @Override
        public void execute() {
            printTitle("Изменение  заявки");
            String id = input.ask("Введите id  заявки которую нужно изменить ");
            if (isId(id)) {
                String name = input.ask("Введите новое имя заявки ");
                String desc = input.ask("Введите новое описание заявки ");
                Item item = new Item(name, desc);
                tracker.replace(id, item);
                printTitle("Обновление заявки  с id  " + item.getId() + "  выполненно");
            } else {
                output.accept(String.format("Item whith id %s is not found.%n%s%n%n", id, lineLongDouble));
            }
        }
    }

    /**
     * DeleteItem - запрашивает данные и удаляет заявку по id
     */
    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        /**
         * method - запрашивает данные и удаляет заявку по id
         */
        @Override
        public void execute() {
            printTitle("Удаление  заявки");
            String id = input.ask("Введите id  заявки которую нужно удалить ");
            if (isId(id)) {
                tracker.delete(id);
                printTitle("Заявка с id " + id + " удалена");
            } else {
                output.accept(String.format("Item whith id %s is not found.%n%s%n%n", id, lineLongDouble));
            }
        }
    }
}

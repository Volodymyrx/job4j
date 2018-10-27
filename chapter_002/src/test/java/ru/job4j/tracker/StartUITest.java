package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StartUITest
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 5.2
 * @version 1.4
 * @since 27.10.2018
 */
public class StartUITest {
    final PrintStream stdout = System.out;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String ln = System.lineSeparator();
    private final String menu = ("Menu" + ln
            + "0. Add new Item" + ln
            + "1. Show all items" + ln
            + "2. Edit item" + ln
            + "3. Delete item" + ln
            + "4. Find item by Id" + ln
            + "5. Find items by name" + ln
            + "6. Exit Program" + ln
            + "Select: " + ln);


    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenShowAllThenPrintAll() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        tracker.add(new Item("test name1", "desc2"));
        Input input = new StubInput(new String[]{"1", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu
                        + "_______________ List of all Items _______________" + ln
                        + "  № по порядку 1 id: " + tracker.getItems()[0].getId() + ln
                        + " Name test name0" + ln
                        + " Содержание: desc0" + ln
                        + "__________________________________________________" + ln
                        + " № по порядку 2 id: " + tracker.getItems()[1].getId() + ln
                        + " Name test name1" + ln
                        + " Содержание: desc1" + ln
                        + "__________________________________________________" + ln
                        + " № по порядку 3 id: " + tracker.getItems()[2].getId() + ln
                        + " Name test name1" + ln
                        + " Содержание: desc2\r\n__________________________________________________" + ln
                        + "==================================================" + ln + ln
                        + menu
                )
        );
    }

    @Test
    public void whenFindeByIdThenPrintOne() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        tracker.add(new Item("test name1", "desc2"));
        Input input = new StubInput(new String[]{"4", tracker.getItems()[1].getId(), "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu
                        + "_______________ Поиск заявки по id _______________" + ln
                        + " id: " + tracker.getItems()[1].getId() + ln
                        + " Name test name1" + ln
                        + " Содержание: desc1" + ln
                        + "__________________________________________________" + ln
                        + "==================================================" + ln + ln
                        + menu
                )
        );
    }

    @Test
    public void whenFindeByIdWithBadIdThenPrintMessage() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        tracker.add(new Item("test name1", "desc2"));
        Input input = new StubInput(new String[]{"4", "555", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu
                        + "_______________ Поиск заявки по id _______________" + ln
                        + " Item whith id 555 is not found." + ln
                        + "==================================================" + ln + ln
                        + menu
                )
        );
    }

    @Test
    public void whenFindeByName1ThenPrintOne() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        tracker.add(new Item("test name1", "desc2"));
        Input input = new StubInput(new String[]{"5", "test name0", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu
                        + "_______________ Поиск заявки по name _______________" + ln
                        + " _______________ List  Items by Name _______________" + ln
                        + "  № по порядку 1 id: " + tracker.getItems()[0].getId() + ln
                        + " Name test name0" + ln
                        + " Содержание: desc0" + ln
                        + "__________________________________________________" + ln
                        + "==================================================" + ln + ln
                        + menu
                )
        );
    }

    @Test
    public void whenFindeByNameThenPrintTwo() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        tracker.add(new Item("test name1", "desc2"));
        Input input = new StubInput(new String[]{"5", "test name1", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu
                        + "_______________ Поиск заявки по name _______________" + ln
                        + " _______________ List  Items by Name _______________" + ln
                        + "  № по порядку 1 id: " + tracker.getItems()[1].getId() + ln
                        + " Name test name1" + ln
                        + " Содержание: desc1" + ln
                        + "__________________________________________________" + ln
                        + " № по порядку 2 id: " + tracker.getItems()[2].getId() + ln
                        + " Name test name1" + ln
                        + " Содержание: desc2\r\n__________________________________________________" + ln
                        + "==================================================" + ln + ln
                        + menu
                )
        );
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUserAddItemThenHaveSomeOutputToConsole() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu
                        + "_______________ Добавление новой заявки _______________" + ln
                        + " _______________ Новая заявка с getId  " + tracker.getItems()[0].getId() + "  принята _______________" + ln
                        + " " + menu
                )
        );
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUpdateThenHaveSomeOutputToConsole() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu
                        + "_______________ Изменение  заявки _______________" + ln
                        + " _______________ Обновление заявки  с id  " + tracker.getItems()[0].getId() + "  выполненно _______________" + ln
                        + " " + menu
                )
        );
    }

    @Test
    public void whenUpdateWithBadIdThenMessage() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", "555", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu
                        + "_______________ Изменение  заявки _______________" + ln
                        + " Item whith id 555 is not found." + ln
                        + "==================================================" + ln + ln
                        + menu
                )
        );
    }

    @Test
    public void whenDeleteThenTrackerHasNextValue() {
        Tracker tracker = new Tracker();
        Item item0 = tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        Input input = new StubInput(new String[]{"3", item0.getId(), "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name1"));
    }

    @Test
    public void whenDeleteThenHameSomeOutputToConsole() {
        Tracker tracker = new Tracker();
        Item item0 = tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        Input input = new StubInput(new String[]{"3", item0.getId(), "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu
                        + "_______________ Удаление  заявки _______________" + ln
                        + " _______________ Заявка с id " + item0.getId() + " удалена _______________" + ln
                        + " " + menu
                )
        );
    }

    @Test
    public void whenDeleteBadIdThenMessage() {
        Tracker tracker = new Tracker();
        Item item0 = tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        Input input = new StubInput(new String[]{"3", "555", "6", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu
                        + "_______________ Удаление  заявки _______________" + ln
                        + " Item whith id 555 is not found." + ln
                        + "==================================================" + ln + ln
                        + menu
                )
        );
    }

    @Test
    public void whenExitThenExit() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"6", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(menu)
        );
    }
}

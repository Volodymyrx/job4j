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
 * project job4j lesson 4.6
 * @version 1.0
 * @since 19.10.2018
 */
public class StartUITest {
    final PrintStream stdout = System.out;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();


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
        Tracker tracker = new Tracker() {
            int tempId = 555;

            @Override
            public String generateId() {
                return "unic0" + tempId++;
            }
        };
        tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        tracker.add(new Item("test name1", "desc2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                "Menu\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\nSelect\r\n\r\n"
                        + "-------- List of all Items -------------------------\r\n"
                        + " № по порядку 1 id: unic0555\r\n"
                        + " Name test name0\r\n"
                        + " Содержание: desc0\r\n"
                        + "---------------------------------------------------------\r\n"
                        + " № по порядку 2 id: unic0556\r\n"
                        + " Name test name1\r\n"
                        + " Содержание: desc1\r\n"
                        + "---------------------------------------------------------\r\n"
                        + " № по порядку 3 id: unic0557\r\n"
                        + " Name test name1\r\n"
                        + " Содержание: desc2\r\n---------------------------------------------------------\r\n"
                        + "===============================================================\r\n\r\n"
                        + "Menu\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\n"
                        + "Select\r\n\r\n"
                )
        );
    }

    @Test
    public void whenFindeByIdThenPrintOne() {
        Tracker tracker = new Tracker() {
            int tempId = 555;

            @Override
            public String generateId() {
                return "unic0" + tempId++;
            }
        };
        tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        tracker.add(new Item("test name1", "desc2"));
        Input input = new StubInput(new String[]{"4", "unic0556", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                "Menu\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\nSelect\r\n\r\n"
                        + "------------ Поиск заявки по id --------------\r\n"
                        + " id: unic0556\r\n"
                        + " Name test name1\r\n"
                        + " Содержание: desc1\r\n"
                        + "---------------------------------------------------------\r\n"
                        + "===============================================================\r\n\r\n"
                        + "Menu\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\n"
                        + "Select\r\n\r\n"
                )
        );
    }

    @Test
    public void whenFindeByNameThenPrintTwo() {
        Tracker tracker = new Tracker() {
            int tempId = 555;

            @Override
            public String generateId() {
                return "unic0" + tempId++;
            }
        };
        tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        tracker.add(new Item("test name1", "desc2"));
        Input input = new StubInput(new String[]{"5", "test name1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                "Menu\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\nSelect\r\n\r\n"
                        + "------------ Поиск заявки по name --------------\r\n"
                        + "-------- List  Items by Name -------------------------\r\n"
                        + " № по порядку 1 id: unic0556\r\n"
                        + " Name test name1\r\n"
                        + " Содержание: desc1\r\n"
                        + "---------------------------------------------------------\r\n"
                        + " № по порядку 2 id: unic0557\r\n"
                        + " Name test name1\r\n"
                        + " Содержание: desc2\r\n---------------------------------------------------------\r\n"
                        + "===============================================================\r\n\r\n"
                        + "Menu\r\n"
                        + "0. Add new Item\r\n"
                        + "1. Show all items\r\n"
                        + "2. Edit item\r\n"
                        + "3. Delete item\r\n"
                        + "4. Find item by Id\r\n"
                        + "5. Find items by name\r\n"
                        + "6. Exit Program\r\n"
                        + "Select\r\n\r\n"
                )
        );
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasNextValue() {
        Tracker tracker = new Tracker();
        Item item0 = tracker.add(new Item("test name0", "desc0"));
        tracker.add(new Item("test name1", "desc1"));
        Input input = new StubInput(new String[]{"3", item0.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name1"));
    }
}

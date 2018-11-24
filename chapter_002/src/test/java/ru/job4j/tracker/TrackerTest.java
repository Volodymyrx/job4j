package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tracker
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 2.2
 * @version 1.0
 * @since 16.10.2018
 */
public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("someId", "report", "any text");
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("123", "test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("1234", "test2", "testDescription2");
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(next.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindByNameReturnArrayName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("123", "test1", "testDescription");
        tracker.add(previous);
        Item previous2 = new Item("1233", "test1", "testDescription7777");
        tracker.add(previous2);
        Item next = new Item("1234", "test2", "testDescription2");
        tracker.add(next);
        Item nextnext = new Item("12345", "test2", "testDescription3");
        tracker.add(nextnext);
        assertThat(tracker.findByName("test2").get(1).getDesctiption(), is("testDescription3"));
    }

    @Test
    public void whenDeleteItemReturnNextItom() {
        Tracker tracker = new Tracker();
        Item previous = new Item("123", "test1", "testDescription");
        tracker.add(previous);
        Item previous2 = new Item("1233", "test1", "testDescription7777");
        tracker.add(previous2);
        Item next = new Item("1234", "test2", "testDescription2");
        tracker.add(next);
        Item nextnext = new Item("12345", "test2", "testDescription3");
        tracker.add(nextnext);
        tracker.delete(next.getId());
        assertThat(tracker.findAll().get(2).getDesctiption(), is("testDescription3"));
    }

    @Test
    public void whenFindByIdReturnRightDescription() {
        Tracker tracker = new Tracker();
        Item previous = new Item("123", "test1", "testDescription");
        tracker.add(previous);
        Item previous2 = new Item("1233", "test1", "testDescription7777");
        tracker.add(previous2);
        Item next = new Item("1234", "test2", "testDescription2");
        tracker.add(next);
        Item nextnext = new Item("12345", "test2", "testDescription3");
        tracker.add(nextnext);
        assertThat(tracker.findById(previous2.getId()).getDesctiption(), is("testDescription7777"));
    }

    @Test
    public void whenFindAllReturnRightDescription() {
        Tracker tracker = new Tracker();
        Item previous = new Item("123", "test1", "testDescription");
        tracker.add(previous);
        Item previous2 = new Item("1233", "test1", "testDescription7777");
        tracker.add(previous2);
        Item next = new Item("1234", "test2", "testDescription2");
        tracker.add(next);
        Item nextnext = new Item("12345", "test2", "testDescription3");
        tracker.add(nextnext);
        assertThat(tracker.findAll().get(3).getDesctiption(), is("testDescription3"));
    }


}

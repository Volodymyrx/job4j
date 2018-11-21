package ru.job4j.search;

import java.util.Comparator;

/**
 * class Task
 * project lesson 3.2
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 20.11.2018
 */
public class Task implements Comparable<Task>, Comparator<Task> {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }


    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }


    @Override
    public int compareTo(Task anotherTask) {
        return Integer.compare(this.priority, anotherTask.priority);
    }

    @Override
    public int compare(Task o1, Task o2) {
        return o1.compareTo(o2);
    }
}

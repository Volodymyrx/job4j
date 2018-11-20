package ru.job4j.search;

import java.util.LinkedList;

/**
 * class PriorityQueue
 * project lesson 3.2
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 20.11.2018
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {

        if (this.tasks.size() == 0) {
            this.tasks.add(task);
        } else {
            int index = this.tasks.size() - 1;
            for (Task task1 : tasks) {
                if (task1.getPriority() > task.getPriority()) {
                    index = tasks.indexOf(task1);
                    break;
                }
            }
            this.tasks.add(index, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}

package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * class PhoneDictionary
 * project lesson 3.1 search
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j task part2 plus
 * @version 1.0
 * @since 20.11.2018
 */
public class PhoneDictionary {
    private final List<Person> listPersons = new ArrayList();

    /**
     * add new person in arrayList this
     *
     * @param person new person
     */
    public void add(Person person) {
        this.listPersons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList();
        for (Person listPerson : listPersons) {
            if (listPerson.getName().contains(key)
                    || listPerson.getSurname().contains(key)
                    || listPerson.getPhone().contains(key)
                    || listPerson.getAddress().contains(key)) {
                result.add(listPerson);
            }
        }
        return result;
    }


}
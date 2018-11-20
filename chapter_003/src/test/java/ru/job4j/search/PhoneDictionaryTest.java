package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class PhoneDictionaryTest
 * project lesson 3.1 search
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j task part2 plus
 * @version 1.0
 * @since 20.11.2018
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Ivan", "Ivanov", "57348734872", "Kiev"));
        phones.add(new Person("Pavel", "Pavlov", "5783487872", "Ufa"));
        phones.add(new Person("Petr", "Petrov", "534523839752", "Odessa"));
        List<Person> persons = phones.find("Ivan");
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : persons) {
            stringBuilder.append(person.getSurname()).append(" ");
        }
        assertThat(stringBuilder.toString(), is("Ivanov "));
    }

    @Test
    public void whenFindByNameSome() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Ivan", "Ivanov", "57348734872", "Kiev"));
        phones.add(new Person("Pavel", "Pavlov", "5783487872", "Ufa"));
        phones.add(new Person("Petr", "Petrov", "534523839752", "Odessa"));
        List<Person> persons = phones.find("Petr");
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : persons) {
            stringBuilder.append(person.getSurname()).append(" ");
        }
        assertThat(stringBuilder.toString(), is("Arsentev Petrov "));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Ivan", "Ivanov", "57348734872", "Kiev"));
        phones.add(new Person("Pavel", "Pavlov", "5783487872", "Ufa"));
        phones.add(new Person("Petr", "Petrov", "534523839752", "Odessa"));
        List<Person> persons = phones.find("534872");
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : persons) {
            stringBuilder.append(person.getSurname()).append(" ");
        }
        assertThat(stringBuilder.toString(), is("Arsentev "));
    }

    @Test
    public void whenFindByPhoneSome() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Ivan", "Ivanov", "57348734872", "Odessa"));
        phones.add(new Person("Pavel", "Pavlov", "5783487872", "Ufa"));
        phones.add(new Person("Petr", "Petrov", "534523839752", "Odessa"));
        List<Person> persons = phones.find("872");
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : persons) {
            stringBuilder.append(person.getSurname()).append(" ");
        }
        assertThat(stringBuilder.toString(), is("Arsentev Ivanov Pavlov "));
    }

    @Test
    public void whenFindByAdres() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Ivan", "Ivanov", "57348734872", "Odessa"));
        phones.add(new Person("Pavel", "Pavlov", "5783487872", "Ufa"));
        phones.add(new Person("Petr", "Petrov", "534523839752", "Odessa"));
        List<Person> persons = phones.find("Bryansk");
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : persons) {
            stringBuilder.append(person.getSurname()).append(" ");
        }
        assertThat(stringBuilder.toString(), is("Arsentev "));
    }

    @Test
    public void whenFindByAdresSome() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Ivan", "Ivanov", "57348734872", "Odessa"));
        phones.add(new Person("Pavel", "Pavlov", "5783487872", "Ufa"));
        phones.add(new Person("Petr", "Petrov", "534523839752", "Odessa"));
        List<Person> persons = phones.find("Odessa");
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : persons) {
            stringBuilder.append(person.getSurname()).append(" ");
        }
        assertThat(stringBuilder.toString(), is("Ivanov Petrov "));
    }


}
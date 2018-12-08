package ru.job4j;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class DepartamentTest
 * project lesson Collection plus
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 08.12.2018
 */
public class DepartamentTest {

    @Test
    public void whenSortRightAndAddThenOk() {
        Departament departament = new Departament();
        Collection<String> departs = departament.addDepartInit(departament.departInit);
        departs = departament.sortRightPlus(departs);
        assertThat(departs.toString(), is("["
                + "K1, "
                + "K1\\SK1, "
                + "K1\\SK1\\SSK1, "
                + "K1\\SK1\\SSK2, "
                + "K1\\SK2, "
                + "K2, "
                + "K2\\SK1, "
                + "K2\\SK1\\SSK1, "
                + "K2\\SK1\\SSK2"
                + "]"));
    }

    @Test
    public void whenSortReversAndAddThenOk() {
        Departament departament = new Departament();
        Collection<String> departs = departament.addDepartInit(departament.departInit);
        departs = departament.sortReversPlus(departs);
        assertThat(departs.toString(), is("["
                + "K2, "
                + "K2\\SK1, "
                + "K2\\SK1\\SSK2, "
                + "K2\\SK1\\SSK1, "
                + "K1, "
                + "K1\\SK2, "
                + "K1\\SK1, "
                + "K1\\SK1\\SSK2, "
                + "K1\\SK1\\SSK1"
                + "]"));
    }
}




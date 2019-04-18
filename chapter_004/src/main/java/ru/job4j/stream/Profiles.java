package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * class Profiles
 * project lesson 4.2.2
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.1
 * @since 16.04.2019
 */
public class Profiles {

    /**
     * method convert List Profile to List Address without equals address an sort by city
     *
     * @param profiles List of Profile
     * @return List of Address
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(
                Profile::getAddress
        ).sorted(Comparator.comparing(Address::getCity)).distinct().collect(Collectors.toList());
    }


}
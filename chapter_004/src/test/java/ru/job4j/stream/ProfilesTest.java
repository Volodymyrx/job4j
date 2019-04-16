package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class ProfilesTest
 * project lesson 4.2.3
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.1
 * @since 16.04.2019
 */
public class ProfilesTest {


    private final Profiles profiles = new Profiles();
    private final List<Profile> profileLists = Arrays.asList(
            new Profile(new Address("Odessa", "Lenin", 10, 45)),
            new Profile(new Address("Ufa", "Victory", 122, 435)),
            new Profile(new Address("London", "Pushkins", 98, 67)),
            new Profile(new Address("London", "Pushkins", 98, 67)),
            new Profile(new Address("London", "Pushkins", 98, 67)),
            new Profile(new Address("London", "Pushkins", 98, 66)),
            new Profile(new Address("Odessa", "Lenin", 10, 45)),
            new Profile(new Address("Vologda", "Apples", 23, 34)),
            new Profile(new Address("Rostov", "Central", 54, 86))
    );
    private final List<Address> addressesExpect = Arrays.asList(
            new Address("London", "Pushkins", 98, 67),
            new Address("London", "Pushkins", 98, 66),
            new Address("Odessa", "Lenin", 10, 45),
            new Address("Rostov", "Central", 54, 86),
            new Address("Ufa", "Victory", 122, 435),
            new Address("Vologda", "Apples", 23, 34)
    );


    @Test
    public void profileToAddress() {
        List<Address> addressesResult = profiles.collect(profileLists);
        assertThat(toStringArray(addressesResult), is(toStringArray(addressesExpect)));
    }


    /**
     * util metod for correct assertThat List String and List String
     *
     * @param addresses List Address
     * @return List Address to String
     */
    private List<String> toStringArray(List<Address> addresses) {
        return addresses.stream().map(
                Address::toString
        ).collect(Collectors.toList());
    }

}



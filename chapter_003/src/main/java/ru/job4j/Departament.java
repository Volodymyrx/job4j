package ru.job4j;

import java.util.*;

/**
 * class Departament
 * project lesson Collection plus
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 08.12.2018
 */
public class Departament {
    List<String> departInit = new ArrayList<>();

    /**
     * upload start names of department
     *
     * @param departs collection of String name of department at first empty
     * @return uploaded collection
     */
    public Collection<String> addDepartInit(Collection<String> departs) {
        departs.add("K1\\SK1");
        departs.add("K1\\SK2");
        departs.add("K1\\SK1\\SSK1");
        departs.add("K1\\SK1\\SSK2");
        departs.add("K2");
        departs.add("K2\\SK1\\SSK1");
        departs.add("K2\\SK1\\SSK2");
        return departs;
    }

    /**
     * sort name of departaments natural style and add absent name of departaments
     *
     * @param departs collection of string name of departament
     * @return collection sorted natural style and complet name of departament
     */
    public Collection<String> sortRightPlus(Collection<String> departs) {
        Set<String> sortDep = new TreeSet<>();
        return addEmptyDepart(departs, sortDep);
    }

    /**
     * sort name of departaments origin revers style and add absent name of departaments
     *
     * @param departs collection of string name of departament
     * @return collection sorted origin revers style and complet name of departament
     */
    public Collection<String> sortReversPlus(Collection<String> departs) {
        ReversComparator reversComparator = new ReversComparator();
        Set<String> sortDep = new TreeSet<>(reversComparator);
        return addEmptyDepart(departs, sortDep);
    }

    /**
     * util methid add absent name of departaments
     *
     * @param departs sours of collection name departament
     * @param sortDep temp sorted TreeSet
     * @return collection sorted and complet name of departamen
     */
    private Collection<String> addEmptyDepart(Collection<String> departs, Set<String> sortDep) {
        sortDep.addAll(departs);
        for (String depart : departs) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depart.length(); i++) {
                if ((depart.charAt(i)) == '\\') {
                    sortDep.add(sb.toString());
                }
                sb.append(depart.charAt(i));
            }
        }
        return sortDep;
    }


    /**
     * iner class Comparator for comprare origin revers style of String name of departament
     */
    private class ReversComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int result;
            if (o1.length() == o2.length()) {
                result = o2.compareTo(o1);
            } else if (o1.length() < o2.length()) {
                result = comprareDifLengthRevers(o1, o2);
            } else {
                result = -comprareDifLengthRevers(o2, o1);
            }
            return result;
        }

        /**
         * util method comprare string diferent length
         * @param shortSt short String
         * @param longSt long String
         * @return int return -1 if short string bigest long Strhing, ziro if Equels , plus 1 if longString bigest
         */
        private int comprareDifLengthRevers(String shortSt, String longSt) {
            int result = -shortSt.compareTo(longSt.substring(0, (shortSt.length())));
            if (result == 0) {
                result = -1;
            }
            return result;
        }
    }
}

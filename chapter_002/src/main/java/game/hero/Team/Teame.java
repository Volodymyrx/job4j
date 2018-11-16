package game.hero.team;

import java.util.ArrayList;

/**
 * interface Team
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public interface Teame {

    /**
     * choise number Hero from list
     *
     * @param teame complet team
     * @return int number of Hero in list
     */
    int choiseHeroToStep(Teame teame);

    /**
     * ramndom choise number in list
     *
     * @param heroArrayLists list of Hero
     * @return int number of Hero in list
     */
    int choseHeroRandom(ArrayList heroArrayLists);

    /**
     * метод выбора действия команды
     *
     * @param teameOwn  своя команда
     * @param teameEnem враг команда
     */
    void act(Teame teameOwn, Teame teameEnem);

    /**
     * get list Heros of Team
     *
     * @return list
     */
    ArrayList getHeros();

    /**
     * method about Team an all hero in team
     *
     * @return string about Team
     */
    String raportTeam(Teame teame);

    /**
     * get name of Team
     *
     * @return String name
     */
    String getName();
}

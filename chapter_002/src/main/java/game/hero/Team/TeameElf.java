package game.hero.team;

import game.hero.hero.Hero;
import game.hero.hero.HeroHunter;
import game.hero.hero.HeroMagElf;
import game.hero.hero.HeroSworder;

import java.util.ArrayList;

/**
 * class TeamElf
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class TeameElf implements Teame {
    private final Teame teameBase;
    private final ArrayList<Hero> teamHeros = new ArrayList<>();

    public TeameElf(int quantityMag, int quantityGun, int quantitySworder) {
        this.teameBase = new TeameBase();
        for (int i = 0; i < quantityMag; i++) {
            teamHeros.add(new HeroMagElf("Mag Elf" + i, "Magic and Sword", 10, 100));
        }
        for (int i = 0; i < quantityGun; i++) {
            teamHeros.add(new HeroHunter("Hunter" + i, "Gun and Sword", 3, 7, 100));
        }
        for (int i = 0; i < quantitySworder; i++) {
            teamHeros.add(new HeroSworder("Sworder" + i, "Sword", 15, 100));
        }
    }

    /**
     * get list Heros of Team
     *
     * @return list
     */
    @Override
    public ArrayList<Hero> getHeros() {
        return teamHeros;
    }

    /**
     * get name of Team
     *
     * @return String name
     */
    @Override
    public String getName() {
        return "Team Elfs";
    }

    /**
     * choise number Hero from list
     *
     * @param teame complet team
     * @return int number of Hero in list
     */
    @Override
    public int choiseHeroToStep(Teame teame) {
        return this.teameBase.choiseHeroToStep(teame);
    }

    /**
     * ramndom choise number in list
     *
     * @param heroArrayLists list of Hero
     * @return int number of Hero in list
     */
    @Override
    public int choseHeroRandom(ArrayList heroArrayLists) {
        return this.teameBase.choseHeroRandom(heroArrayLists);
    }

    /**
     * метод выбора действия команды
     *
     * @param teameOwn  своя команда
     * @param teameEnem враг команда
     */
    @Override
    public void act(Teame teameOwn, Teame teameEnem) {
        this.teameBase.act(teameOwn, teameEnem);
    }

    /**
     * method about Team an all hero in team
     *
     * @return string about Team
     */
    @Override
    public String raportTeam(Teame teame) {
        return this.teameBase.raportTeam(teame);
    }
}

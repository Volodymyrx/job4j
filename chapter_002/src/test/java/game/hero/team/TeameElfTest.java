package game.hero.team;

import game.hero.hero.Hero;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class TeamElfTest
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class TeameElfTest {
    private final String ln = System.lineSeparator();

    /**
     * method
     * public int choiseHeroToStep(Teame team)
     */
    @Test
    public void whenOneMagThen0() {
        Teame teameElf = new TeameElf(1, 0, 0);
        assertThat(teameElf.choiseHeroToStep(teameElf), is(0));
    }

    @Test
    public void whenOneSworderThen0() {
        Teame teameElf = new TeameElf(0, 0, 1);
        assertThat(teameElf.choiseHeroToStep(teameElf), is(0));
    }

    @Test
    public void whenCompletTeamAndOneImpruveThen5() {
        Teame teameElf = new TeameElf(1, 3, 4);
        ((Hero) teameElf.getHeros().get(5)).setImpruv();
        assertThat(teameElf.choiseHeroToStep(teameElf), is(5));
    }

    /**
     * method public int choseHeroRandom(ArrayList heros)
     */
    @Test
    public void whenRandomFrom1Then0() {
        Teame teameElf = new TeameElf(0, 1, 0);
        assertThat(teameElf.choseHeroRandom(teameElf.getHeros()), is(0));
    }

    /**
     * public void act(Teame teameOwn, Teame teameEnem)
     */
    @Test
    public void whenOneHeroOneHitThenLessLife() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 1);
        teameElf1.act(teameElf1, teameElf2);
        assertThat(((Hero) teameElf2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 85 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroFifeHitThenLessLife() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 1);
        for (int i = 0; i < 5; i++) {
            teameElf1.act(teameElf1, teameElf2);
        }
        assertThat(((Hero) teameElf2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 25 hit 15 isAliave true isBad false isImpruve false"));
    }

    /**
     * method raportTeam()
     */
    @Test
    public void whenOneMagThenInfo() {
        Teame teameElf = new TeameElf(1, 0, 0);
        assertThat(teameElf.raportTeam(teameElf), is("Team name Team Elfs" + ln
                + " Raport's Hero:  name Mag Elf0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenCompletTeamThenInfo() {
        Teame teameElf = new TeameElf(1, 3, 4);
        assertThat(teameElf.raportTeam(teameElf), is("Team name Team Elfs" + ln
                + " Raport's Hero:  name Mag Elf0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false" + ln
                + " Raport's Hero:  name Hunter0 weapon Gun and Sword life 100 hitSword 3 hitGun 7 isAliave true isBad false isImpruve false" + ln
                + " Raport's Hero:  name Hunter1 weapon Gun and Sword life 100 hitSword 3 hitGun 7 isAliave true isBad false isImpruve false" + ln
                + " Raport's Hero:  name Hunter2 weapon Gun and Sword life 100 hitSword 3 hitGun 7 isAliave true isBad false isImpruve false" + ln
                + " Raport's Hero:  name Sworder0 weapon Sword life 100 hit 15 isAliave true isBad false isImpruve false" + ln
                + " Raport's Hero:  name Sworder1 weapon Sword life 100 hit 15 isAliave true isBad false isImpruve false" + ln
                + " Raport's Hero:  name Sworder2 weapon Sword life 100 hit 15 isAliave true isBad false isImpruve false" + ln
                + " Raport's Hero:  name Sworder3 weapon Sword life 100 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenZiroHeroThenInfo() {
        Teame teameElf = new TeameElf(0, 0, 0);
        assertThat(teameElf.raportTeam(teameElf), is("Team name Team Elfs" + ln + "   Nobody... "));
    }

}
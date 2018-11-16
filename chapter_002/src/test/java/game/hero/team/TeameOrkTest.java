package game.hero.team;

import game.hero.hero.Hero;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class TeamOrkTest
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class TeameOrkTest {
    private final String ln = System.lineSeparator();

    /**
     * method
     * public int choiseHeroToStep(Teame team)
     */
    @Test
    public void whenOneMagThen0() {
        Teame teameOrk = new TeameOrk(1, 0, 0);
        assertThat(teameOrk.choiseHeroToStep(teameOrk), is(0));
    }

    @Test
    public void whenOneSworderThen0() {
        Teame teameOrk = new TeameOrk(0, 0, 1);
        assertThat(teameOrk.choiseHeroToStep(teameOrk), is(0));
    }

    @Test
    public void whenCompletTeamAndOneImpruveThen5() {
        Teame teameOrk = new TeameOrk(1, 3, 4);
        ((Hero) teameOrk.getHeros().get(5)).setImpruv();
        assertThat(teameOrk.choiseHeroToStep(teameOrk), is(5));
    }

    /**
     * method public int choseHeroRandom(ArrayList heros)
     */
    @Test
    public void whenRandomFrom1Then0() {
        Teame teameOrk = new TeameOrk(0, 1, 0);
        assertThat(teameOrk.choseHeroRandom(teameOrk.getHeros()), is(0));
    }

    /**
     * public void act(Teame teameOwn, Teame teameEnem)
     */
    @Test
    public void whenOneHeroOneHitThenLessLife() {
        Teame teameOrk1 = new TeameOrk(0, 0, 1);
        Teame teameOrk2 = new TeameOrk(0, 0, 1);
        teameOrk1.act(teameOrk1, teameOrk2);
        assertThat(((Hero) teameOrk2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 85 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroFifeHitThenLessLife() {
        Teame teameOrk1 = new TeameOrk(0, 0, 1);
        Teame teameOrk2 = new TeameOrk(0, 0, 1);
        for (int i = 0; i < 5; i++) {
            teameOrk1.act(teameOrk1, teameOrk2);
        }
        assertThat(((Hero) teameOrk2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 25 hit 15 isAliave true isBad false isImpruve false"));
    }

    /**
     * method raportTeam()
     */
    @Test
    public void whenOneMagThenInfo() {
        Teame teameOrk = new TeameOrk(1, 0, 0);
        assertThat(teameOrk.raportTeam(teameOrk), is("Team name Team Orks" + ln
                + " Raport's Hero:  name Mag Ork0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenCompletTeamThenInfo() {
        Teame teameOrk = new TeameOrk(1, 3, 4);
        assertThat(teameOrk.raportTeam(teameOrk), is("Team name Team Orks" + ln
                + " Raport's Hero:  name Mag Ork0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false" + ln
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
        Teame teameOrk = new TeameOrk(0, 0, 0);
        assertThat(teameOrk.raportTeam(teameOrk), is("Team name Team Orks" + ln + "   Nobody... "));
    }

}
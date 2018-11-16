package game.hero.team;

import game.hero.hero.Hero;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class TeamNejidTest
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class TeameNejidTest {
    private final String ln = System.lineSeparator();

    /**
     * method
     * public int choiseHeroToStep(Teame team)
     */
    @Test
    public void whenOneMagThen0() {
        Teame teameNejid = new TeameNejid(1, 0, 0);
        assertThat(teameNejid.choiseHeroToStep(teameNejid), is(0));
    }

    @Test
    public void whenOneSworderThen0() {
        Teame teameNejid = new TeameNejid(0, 0, 1);
        assertThat(teameNejid.choiseHeroToStep(teameNejid), is(0));
    }

    @Test
    public void whenCompletTeamAndOneImpruveThen5() {
        Teame teameNejid = new TeameNejid(1, 3, 4);
        ((Hero) teameNejid.getHeros().get(5)).setImpruv();
        assertThat(teameNejid.choiseHeroToStep(teameNejid), is(5));
    }

    /**
     * method public int choseHeroRandom(ArrayList heros)
     */
    @Test
    public void whenRandomFrom1Then0() {
        Teame teameNejid = new TeameNejid(0, 1, 0);
        assertThat(teameNejid.choseHeroRandom(teameNejid.getHeros()), is(0));
    }

    /**
     * public void act(Teame teameOwn, Teame teameEnem)
     */
    @Test
    public void whenOneHeroOneHitThenLessLife() {
        Teame teameNejid1 = new TeameNejid(0, 0, 1);
        Teame teameNejid2 = new TeameNejid(0, 0, 1);
        teameNejid1.act(teameNejid1, teameNejid2);
        assertThat(((Hero) teameNejid2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 85 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroFifeHitThenLessLife() {
        Teame teameNejid1 = new TeameNejid(0, 0, 1);
        Teame teameNejid2 = new TeameNejid(0, 0, 1);
        for (int i = 0; i < 5; i++) {
            teameNejid1.act(teameNejid1, teameNejid2);
        }
        assertThat(((Hero) teameNejid2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 25 hit 15 isAliave true isBad false isImpruve false"));
    }

    /**
     * method raportTeam()
     */
    @Test
    public void whenOneMagThenInfo() {
        Teame teameNejid = new TeameNejid(1, 0, 0);
        assertThat(teameNejid.raportTeam(teameNejid), is("Team name Team Nejids" + ln
                + " Raport's Hero:  name Mag Nejid0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenCompletTeamThenInfo() {
        Teame teameNejid = new TeameNejid(1, 3, 4);
        assertThat(teameNejid.raportTeam(teameNejid), is("Team name Team Nejids" + ln
                + " Raport's Hero:  name Mag Nejid0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false" + ln
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
        Teame teameNejid = new TeameNejid(0, 0, 0);
        assertThat(teameNejid.raportTeam(teameNejid), is("Team name Team Nejids" + ln + "   Nobody... "));
    }

}
package game.hero.team;

import game.hero.hero.Hero;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class TeamHumanTest
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class TeameHumanTest {
    private final String ln = System.lineSeparator();

    /**
     * method
     * public int choiseHeroToStep(Teame team)
     */
    @Test
    public void whenOneMagThen0() {
        Teame teameHuman = new TeameHuman(1, 0, 0);
        assertThat(teameHuman.choiseHeroToStep(teameHuman), is(0));
    }

    @Test
    public void whenOneSworderThen0() {
        Teame teameHuman = new TeameHuman(0, 0, 1);
        assertThat(teameHuman.choiseHeroToStep(teameHuman), is(0));
    }

    @Test
    public void whenCompletTeamAndOneImpruveThen5() {
        Teame teameHuman = new TeameHuman(1, 3, 4);
        ((Hero) teameHuman.getHeros().get(5)).setImpruv();
        assertThat(teameHuman.choiseHeroToStep(teameHuman), is(5));
    }

    /**
     * method public int choseHeroRandom(ArrayList heros)
     */
    @Test
    public void whenRandomFrom1Then0() {
        Teame teameHuman = new TeameHuman(0, 1, 0);
        assertThat(teameHuman.choseHeroRandom(teameHuman.getHeros()), is(0));
    }

    /**
     * public void act(Teame teameOwn, Teame teameEnem)
     */
    @Test
    public void whenOneHeroOneHitThenLessLife() {
        Teame teameHuman1 = new TeameHuman(0, 0, 1);
        Teame teameHuman2 = new TeameHuman(0, 0, 1);
        teameHuman1.act(teameHuman1, teameHuman2);
        assertThat(((Hero) teameHuman2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 85 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroFifeHitThenLessLife() {
        Teame teameHuman1 = new TeameHuman(0, 0, 1);
        Teame teameHuman2 = new TeameHuman(0, 0, 1);
        for (int i = 0; i < 5; i++) {
            teameHuman1.act(teameHuman1, teameHuman2);
        }
        assertThat(((Hero) teameHuman2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 25 hit 15 isAliave true isBad false isImpruve false"));
    }

    /**
     * method raportTeam()
     */
    @Test
    public void whenOneMagThenInfo() {
        Teame teameHuman = new TeameHuman(1, 0, 0);
        assertThat(teameHuman.raportTeam(teameHuman), is("Team name Team Humans" + ln
                + " Raport's Hero:  name Mag Human0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenCompletTeamThenInfo() {
        Teame teameHuman = new TeameHuman(1, 3, 4);
        assertThat(teameHuman.raportTeam(teameHuman), is("Team name Team Humans" + ln
                + " Raport's Hero:  name Mag Human0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false" + ln
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
        Teame teameHuman = new TeameHuman(0, 0, 0);
        assertThat(teameHuman.raportTeam(teameHuman), is("Team name Team Humans" + ln + "   Nobody... "));
    }

}
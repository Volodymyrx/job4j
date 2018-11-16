package game.hero.hero;

import game.hero.team.Teame;
import game.hero.team.TeameElf;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class HeroSworderfTest
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class HeroSworderTest {

    /**
     * public void shoiseAction(Teame teameOwn, Teame teameEnem)
     */
    @Test
    public void whenOneHeroOneHitThenLessLife() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).shoiseAction(teameElf1, teameElf2);
        assertThat(((Hero) teameElf2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 85 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroImpruvedOneHitThenLessLife() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).setImpruv();
        ((Hero) teameElf1.getHeros().get(0)).shoiseAction(teameElf1, teameElf2);
        assertThat(((Hero) teameElf2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 78 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroImpruvedOneHitThenImpruveFalse() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).setImpruv();
        ((Hero) teameElf1.getHeros().get(0)).shoiseAction(teameElf1, teameElf2);
        assertThat(((Hero) teameElf1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 100 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroBadOneHitThenLessLife() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).setBad();
        ((Hero) teameElf1.getHeros().get(0)).shoiseAction(teameElf1, teameElf2);
        assertThat(((Hero) teameElf2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 93 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroBadOneHitThenBadFalse() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).setBad();
        ((Hero) teameElf1.getHeros().get(0)).shoiseAction(teameElf1, teameElf2);
        assertThat(((Hero) teameElf1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 100 hit 15 isAliave true isBad false isImpruve false"));
    }

    /**
     * public void impruveOwnHero(Teame teameOwn)
     * for this Hero no exist
     */
    @Test
    public void whenOneHeroThenImpruveFalse() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).impruveOwnHero(teameElf2);
        assertThat(((Hero) teameElf2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 100 hit 15 isAliave true isBad false isImpruve false"));
    }

    /**
     * public void badedEnemHero(Teame teameEnem)
     * for this Hero no exist
     */
    @Test
    public void whenOneHeroThenBadFalse() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).badedEnemHero(teameElf2);
        assertThat(((Hero) teameElf2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 100 hit 15 isAliave true isBad false isImpruve false"));
    }

    /**
     * public void hitEnemHero(Teame teameEnem, int hitHero)
     */
    @Test
    public void whenOneHeroThenLifeLess() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).hitEnemHero(teameElf2, 20);
        assertThat(((Hero) teameElf2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 80 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void when5HeroThenHeroExits5() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 5);
        ((Hero) teameElf1.getHeros().get(0)).hitEnemHero(teameElf2, 20);
        assertThat(teameElf2.getHeros().size(), is(5));
    }

    @Test
    public void when5HeroOverHitThenHeroNoExits4() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        Teame teameElf2 = new TeameElf(0, 0, 5);
        ((Hero) teameElf1.getHeros().get(0)).hitEnemHero(teameElf2, 120);
        assertThat(teameElf2.getHeros().size(), is(4));
    }

    /**
     * public void minusLife(int hitEnem)
     */
    @Test
    public void whenOneHeroThenLife70() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).minusLife(30);
        assertThat(((Hero) teameElf1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 70 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroThenIsAliveTrue() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).minusLife(30);
        assertThat(((Hero) teameElf1.getHeros().get(0)).getIsAlive(), is(true));
    }

    @Test
    public void whenOneHeroLifeMinusThenIsAliveFalse() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).minusLife(130);
        assertThat(((Hero) teameElf1.getHeros().get(0)).getIsAlive(), is(false));
    }

    /**
     * public void setImpruv()
     */
    @Test
    public void whenOneHeroOrdinarThenImpruveFalse() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        assertThat(((Hero) teameElf1.getHeros().get(0)).getIsImpruv(), is(false));
    }

    @Test
    public void whenOneHeroImpruveThenImpruveTrue() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).setImpruv();
        assertThat(((Hero) teameElf1.getHeros().get(0)).getIsImpruv(), is(true));
    }

    /**
     * public void setBad()
     */
    @Test
    public void whenOneHeroNoBadThenIsBadFalse() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        assertThat(((Hero) teameElf1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 100 hit 15 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroToBadThenIsBadTrue() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        ((Hero) teameElf1.getHeros().get(0)).setBad();
        assertThat(((Hero) teameElf1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 100 hit 15 isAliave true isBad true isImpruve false"));
    }

    /**
     * public void getName()()
     */
    @Test
    public void whenOneHeroTnenName() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        assertThat(((Hero) teameElf1.getHeros().get(0)).getName(), is("Sworder0"));
    }

    /**
     * public void raportHero()
     */
    @Test
    public void whenOneHeroTnenInfo() {
        Teame teameElf1 = new TeameElf(0, 0, 1);
        assertThat(((Hero) teameElf1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Sworder0 weapon Sword life 100 hit 15 isAliave true isBad false isImpruve false"));
    }
}
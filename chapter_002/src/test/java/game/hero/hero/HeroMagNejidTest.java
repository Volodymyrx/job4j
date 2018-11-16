package game.hero.hero;

import game.hero.team.Teame;
import game.hero.team.TeameNejid;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class HeroMagNejidTest
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class HeroMagNejidTest {

    /**
     * public void impruveOwnHero(Teame teameOwn)
     * no exist for this hero
     */
    @Test
    public void whenOneHeroThenImpruveFalse() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        Teame teameNejid2 = new TeameNejid(1, 0, 0);
        ((Hero) teameNejid1.getHeros().get(0)).impruveOwnHero(teameNejid2);
        assertThat(((Hero) teameNejid2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Nejid0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    /**
     * public void badedEnemHero(Teame teameEnem)
     */
    @Test
    public void whenOneHeroThenBadTrue() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        Teame teameNejid2 = new TeameNejid(1, 0, 0);
        ((Hero) teameNejid1.getHeros().get(0)).badedEnemHero(teameNejid2);
        assertThat(((Hero) teameNejid2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Nejid0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad true isImpruve false"));
    }

    /**
     * public void hitEnemHero(Teame teameEnem, int hitHero)
     */
    @Test
    public void whenOneHeroThenLifeLess() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        Teame teameNejid2 = new TeameNejid(1, 0, 0);
        ((Hero) teameNejid1.getHeros().get(0)).hitEnemHero(teameNejid2, 20);
        assertThat(((Hero) teameNejid2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Nejid0 weapon Magic and Sword life 80 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void when5HeroThenHeroExits5() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        Teame teameNejid2 = new TeameNejid(5, 0, 0);
        ((Hero) teameNejid1.getHeros().get(0)).hitEnemHero(teameNejid2, 20);
        assertThat(teameNejid2.getHeros().size(), is(5));
    }

    @Test
    public void when5HeroOverHitThenHeroNoExits4() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        Teame teameNejid2 = new TeameNejid(5, 0, 0);
        ((Hero) teameNejid1.getHeros().get(0)).hitEnemHero(teameNejid2, 120);
        assertThat(teameNejid2.getHeros().size(), is(4));
    }

    /**
     * public void minusLife(int hitEnem)
     */
    @Test
    public void whenOneHeroThenLife70() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        ((Hero) teameNejid1.getHeros().get(0)).minusLife(30);
        assertThat(((Hero) teameNejid1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Nejid0 weapon Magic and Sword life 70 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroThenIsAliveTrue() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        ((Hero) teameNejid1.getHeros().get(0)).minusLife(30);
        assertThat(((Hero) teameNejid1.getHeros().get(0)).getIsAlive(), is(true));
    }

    @Test
    public void whenOneHeroLifeMinusThenIsAliveFalse() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        ((Hero) teameNejid1.getHeros().get(0)).minusLife(130);
        assertThat(((Hero) teameNejid1.getHeros().get(0)).getIsAlive(), is(false));
    }

    /**
     * public void setImpruv()
     */
    @Test
    public void whenOneHeroOrdinarThenImpruveFalse() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        assertThat(((Hero) teameNejid1.getHeros().get(0)).getIsImpruv(), is(false));
    }

    @Test
    public void whenOneHeroImpruveThenImpruveTrue() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        ((Hero) teameNejid1.getHeros().get(0)).setImpruv();
        assertThat(((Hero) teameNejid1.getHeros().get(0)).getIsImpruv(), is(true));
    }

    /**
     * public void setBad()
     */
    @Test
    public void whenOneHeroNoBadThenIsBadFalse() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        assertThat(((Hero) teameNejid1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Nejid0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroToBadThenIsBadTrue() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        ((Hero) teameNejid1.getHeros().get(0)).setBad();
        assertThat(((Hero) teameNejid1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Nejid0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad true isImpruve false"));
    }

    /**
     * public void getName()()
     */
    @Test
    public void whenOneHeroTnenName() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        assertThat(((Hero) teameNejid1.getHeros().get(0)).getName(), is("Mag Nejid0"));
    }

    /**
     * public void raportHero()
     */
    @Test
    public void whenOneHeroTnenInfo() {
        Teame teameNejid1 = new TeameNejid(1, 0, 0);
        assertThat(((Hero) teameNejid1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Nejid0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }
}
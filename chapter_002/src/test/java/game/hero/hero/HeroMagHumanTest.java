package game.hero.hero;

import game.hero.team.Teame;
import game.hero.team.TeameHuman;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class HeroMagHumanTest
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class HeroMagHumanTest {

    /**
     * public void impruveOwnHero(Teame teameOwn)
     */
    @Test
    public void whenOneHeroThenImpruveTrue() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        Teame teameHuman2 = new TeameHuman(1, 0, 0);
        ((Hero) teameHuman1.getHeros().get(0)).impruveOwnHero(teameHuman2);
        assertThat(((Hero) teameHuman2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Human0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve true"));
    }

    /**
     * public void badedEnemHero(Teame teameEnem)
     * no exist for this hero
     */
    @Test
    public void whenOneHeroThenBadFalse() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        Teame teameHuman2 = new TeameHuman(1, 0, 0);
        ((Hero) teameHuman1.getHeros().get(0)).badedEnemHero(teameHuman2);
        assertThat(((Hero) teameHuman2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Human0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    /**
     * public void hitEnemHero(Teame teameEnem, int hitHero)
     */
    @Test
    public void whenOneHeroThenLifeLess() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        Teame teameHuman2 = new TeameHuman(1, 0, 0);
        ((Hero) teameHuman1.getHeros().get(0)).hitEnemHero(teameHuman2, 20);
        assertThat(((Hero) teameHuman2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Human0 weapon Magic and Sword life 80 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void when5HeroThenHeroExits5() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        Teame teameHuman2 = new TeameHuman(5, 0, 0);
        ((Hero) teameHuman1.getHeros().get(0)).hitEnemHero(teameHuman2, 20);
        assertThat(teameHuman2.getHeros().size(), is(5));
    }

    @Test
    public void when5HeroOverHitThenHeroNoExits4() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        Teame teameHuman2 = new TeameHuman(5, 0, 0);
        ((Hero) teameHuman1.getHeros().get(0)).hitEnemHero(teameHuman2, 120);
        assertThat(teameHuman2.getHeros().size(), is(4));
    }

    /**
     * public void minusLife(int hitEnem)
     */
    @Test
    public void whenOneHeroThenLife70() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        ((Hero) teameHuman1.getHeros().get(0)).minusLife(30);
        assertThat(((Hero) teameHuman1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Human0 weapon Magic and Sword life 70 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroThenIsAliveTrue() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        ((Hero) teameHuman1.getHeros().get(0)).minusLife(30);
        assertThat(((Hero) teameHuman1.getHeros().get(0)).getIsAlive(), is(true));
    }

    @Test
    public void whenOneHeroLifeMinusThenIsAliveFalse() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        ((Hero) teameHuman1.getHeros().get(0)).minusLife(130);
        assertThat(((Hero) teameHuman1.getHeros().get(0)).getIsAlive(), is(false));
    }

    /**
     * public void setImpruv()
     */
    @Test
    public void whenOneHeroOrdinarThenImpruveFalse() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        assertThat(((Hero) teameHuman1.getHeros().get(0)).getIsImpruv(), is(false));
    }

    @Test
    public void whenOneHeroImpruveThenImpruveTrue() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        ((Hero) teameHuman1.getHeros().get(0)).setImpruv();
        assertThat(((Hero) teameHuman1.getHeros().get(0)).getIsImpruv(), is(true));
    }

    /**
     * public void setBad()
     */
    @Test
    public void whenOneHeroNoBadThenIsBadFalse() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        assertThat(((Hero) teameHuman1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Human0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroToBadThenIsBadTrue() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        ((Hero) teameHuman1.getHeros().get(0)).setBad();
        assertThat(((Hero) teameHuman1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Human0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad true isImpruve false"));
    }

    /**
     * public void getName()()
     */
    @Test
    public void whenOneHeroTnenName() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        assertThat(((Hero) teameHuman1.getHeros().get(0)).getName(), is("Mag Human0"));
    }

    /**
     * public void raportHero()
     */
    @Test
    public void whenOneHeroTnenInfo() {
        Teame teameHuman1 = new TeameHuman(1, 0, 0);
        assertThat(((Hero) teameHuman1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Human0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }
}
package game.hero.hero;

import game.hero.team.Teame;
import game.hero.team.TeameElf;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class HeroMagElfTest
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class HeroMagElfTest {

    /**
     * public void impruveOwnHero(Teame teameOwn)
     */
    @Test
    public void whenOneHeroThenImpruveTrue() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        Teame teameElf2 = new TeameElf(1, 0, 0);
        ((Hero) teameElf1.getHeros().get(0)).impruveOwnHero(teameElf2);
        assertThat(((Hero) teameElf2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Elf0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve true"));
    }

    /**
     * public void badedEnemHero(Teame teameEnem)
     * no exist for this hero
     */
    @Test
    public void whenOneHeroThenBadFalse() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        Teame teameElf2 = new TeameElf(1, 0, 0);
        ((Hero) teameElf1.getHeros().get(0)).badedEnemHero(teameElf2);
        assertThat(((Hero) teameElf2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Elf0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    /**
     * public void hitEnemHero(Teame teameEnem, int hitHero)
     */
    @Test
    public void whenOneHeroThenLifeLess() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        Teame teameElf2 = new TeameElf(1, 0, 0);
        ((Hero) teameElf1.getHeros().get(0)).hitEnemHero(teameElf2, 20);
        assertThat(((Hero) teameElf2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Elf0 weapon Magic and Sword life 80 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void when5HeroThenHeroExits5() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        Teame teameElf2 = new TeameElf(5, 0, 0);
        ((Hero) teameElf1.getHeros().get(0)).hitEnemHero(teameElf2, 20);
        assertThat(teameElf2.getHeros().size(), is(5));
    }

    @Test
    public void when5HeroOverHitThenHeroNoExits4() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        Teame teameElf2 = new TeameElf(5, 0, 0);
        ((Hero) teameElf1.getHeros().get(0)).hitEnemHero(teameElf2, 120);
        assertThat(teameElf2.getHeros().size(), is(4));
    }

    /**
     * public void minusLife(int hitEnem)
     */
    @Test
    public void whenOneHeroThenLife70() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        ((Hero) teameElf1.getHeros().get(0)).minusLife(30);
        assertThat(((Hero) teameElf1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Elf0 weapon Magic and Sword life 70 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroThenIsAliveTrue() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        ((Hero) teameElf1.getHeros().get(0)).minusLife(30);
        assertThat(((Hero) teameElf1.getHeros().get(0)).getIsAlive(), is(true));
    }

    @Test
    public void whenOneHeroLifeMinusThenIsAliveFalse() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        ((Hero) teameElf1.getHeros().get(0)).minusLife(130);
        assertThat(((Hero) teameElf1.getHeros().get(0)).getIsAlive(), is(false));
    }

    /**
     * public void setImpruv()
     */
    @Test
    public void whenOneHeroOrdinarThenImpruveFalse() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        assertThat(((Hero) teameElf1.getHeros().get(0)).getIsImpruv(), is(false));
    }

    @Test
    public void whenOneHeroImpruveThenImpruveTrue() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        ((Hero) teameElf1.getHeros().get(0)).setImpruv();
        assertThat(((Hero) teameElf1.getHeros().get(0)).getIsImpruv(), is(true));
    }

    /**
     * public void setBad()
     */
    @Test
    public void whenOneHeroNoBadThenIsBadFalse() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        assertThat(((Hero) teameElf1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Elf0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroToBadThenIsBadTrue() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        ((Hero) teameElf1.getHeros().get(0)).setBad();
        assertThat(((Hero) teameElf1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Elf0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad true isImpruve false"));
    }

    /**
     * public void getName()()
     */
    @Test
    public void whenOneHeroTnenName() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        assertThat(((Hero) teameElf1.getHeros().get(0)).getName(), is("Mag Elf0"));
    }

    /**
     * public void raportHero()
     */
    @Test
    public void whenOneHeroTnenInfo() {
        Teame teameElf1 = new TeameElf(1, 0, 0);
        assertThat(((Hero) teameElf1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Mag Elf0 weapon Magic and Sword life 100 hitMagic 10 isAliave true isBad false isImpruve false"));
    }
}
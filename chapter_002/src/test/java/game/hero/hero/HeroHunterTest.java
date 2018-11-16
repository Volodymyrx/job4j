package game.hero.hero;

import game.hero.team.Teame;
import game.hero.team.TeameOrk;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class HeroHunterTest
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class HeroHunterTest {

    /**
     * public void impruveOwnHero(Teame teameOwn)
     * for this Hero no exist
     */
    @Test
    public void whenOneHeroThenImpruveFalse() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        Teame teameOrk2 = new TeameOrk(0, 1, 0);
        ((Hero) teameOrk1.getHeros().get(0)).impruveOwnHero(teameOrk2);
        assertThat(((Hero) teameOrk2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Hunter0 weapon Gun and Sword life 100 hitSword 3 hitGun 7 isAliave true isBad false isImpruve false"));
    }

    /**
     * public void badedEnemHero(Teame teameEnem)
     * for this Hero no exist
     */
    @Test
    public void whenOneHeroThenBadFalse() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        Teame teameOrk2 = new TeameOrk(0, 1, 0);
        ((Hero) teameOrk1.getHeros().get(0)).badedEnemHero(teameOrk2);
        assertThat(((Hero) teameOrk2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Hunter0 weapon Gun and Sword life 100 hitSword 3 hitGun 7 isAliave true isBad false isImpruve false"));
    }

    /**
     * public void hitEnemHero(Teame teameEnem, int hitHero)
     */
    @Test
    public void whenOneHeroThenLifeLess() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        Teame teameOrk2 = new TeameOrk(0, 1, 0);
        ((Hero) teameOrk1.getHeros().get(0)).hitEnemHero(teameOrk2, 20);
        assertThat(((Hero) teameOrk2.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Hunter0 weapon Gun and Sword life 80 hitSword 3 hitGun 7 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void when5HeroThenHeroExits5() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        Teame teameOrk2 = new TeameOrk(0, 0, 5);
        ((Hero) teameOrk1.getHeros().get(0)).hitEnemHero(teameOrk2, 20);
        assertThat(teameOrk2.getHeros().size(), is(5));
    }

    @Test
    public void when5HeroOverHitThenHeroNoExits4() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        Teame teameOrk2 = new TeameOrk(0, 0, 5);
        ((Hero) teameOrk1.getHeros().get(0)).hitEnemHero(teameOrk2, 120);
        assertThat(teameOrk2.getHeros().size(), is(4));
    }

    /**
     * public void minusLife(int hitEnem)
     */
    @Test
    public void whenOneHeroThenLife70() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        ((Hero) teameOrk1.getHeros().get(0)).minusLife(30);
        assertThat(((Hero) teameOrk1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Hunter0 weapon Gun and Sword life 70 hitSword 3 hitGun 7 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroThenIsAliveTrue() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        ((Hero) teameOrk1.getHeros().get(0)).minusLife(30);
        assertThat(((Hero) teameOrk1.getHeros().get(0)).getIsAlive(), is(true));
    }

    @Test
    public void whenOneHeroLifeMinusThenIsAliveFalse() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        ((Hero) teameOrk1.getHeros().get(0)).minusLife(130);
        assertThat(((Hero) teameOrk1.getHeros().get(0)).getIsAlive(), is(false));
    }

    /**
     * public void setImpruv()
     */
    @Test
    public void whenOneHeroOrdinarThenImpruveFalse() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        assertThat(((Hero) teameOrk1.getHeros().get(0)).getIsImpruv(), is(false));
    }

    @Test
    public void whenOneHeroImpruveThenImpruveTrue() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        ((Hero) teameOrk1.getHeros().get(0)).setImpruv();
        assertThat(((Hero) teameOrk1.getHeros().get(0)).getIsImpruv(), is(true));
    }

    /**
     * public void setBad()
     */
    @Test
    public void whenOneHeroNoBadThenIsBadFalse() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        assertThat(((Hero) teameOrk1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Hunter0 weapon Gun and Sword life 100 hitSword 3 hitGun 7 isAliave true isBad false isImpruve false"));
    }

    @Test
    public void whenOneHeroToBadThenIsBadTrue() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        ((Hero) teameOrk1.getHeros().get(0)).setBad();
        assertThat(((Hero) teameOrk1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Hunter0 weapon Gun and Sword life 100 hitSword 3 hitGun 7 isAliave true isBad true isImpruve false"));
    }

    /**
     * public void getName()()
     */
    @Test
    public void whenOneHeroTnenName() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        assertThat(((Hero) teameOrk1.getHeros().get(0)).getName(), is("Hunter0"));
    }

    /**
     * public void raportHero()
     */
    @Test
    public void whenOneHeroTnenInfo() {
        Teame teameOrk1 = new TeameOrk(0, 1, 0);
        assertThat(((Hero) teameOrk1.getHeros().get(0)).raportHero(), is(" Raport's Hero:  name Hunter0 weapon Gun and Sword life 100 hitSword 3 hitGun 7 isAliave true isBad false isImpruve false"));
    }
}
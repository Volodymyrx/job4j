package game.hero.hero;

import game.hero.team.Teame;

/**
 * class HeroBase
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class HeroBase implements Hero {

    /**
     * method choise Action Hero: hit, gun, magic
     *
     * @param teameOwn  own team
     * @param teameEnem own team
     */
    @Override
    public void shoiseAction(Teame teameOwn, Teame teameEnem) {
    }

    /**
     * impruve Own team Hero
     *
     * @param teameOwn own team
     */
    @Override
    public void impruveOwnHero(Teame teameOwn) {
        int indexHero = (teameOwn.choseHeroRandom(teameOwn.getHeros()));
        ((Hero) teameOwn.getHeros().get(indexHero)).setImpruv();
    }

    /**
     * do bad Enem team Hero
     *
     * @param teameEnem enem team
     */
    @Override
    public void badedEnemHero(Teame teameEnem) {
        int indexHero = (teameEnem.choseHeroRandom(teameEnem.getHeros()));
        ((Hero) teameEnem.getHeros().get(indexHero)).setBad();
    }

    /**
     * hit Hero to Emem
     *
     * @param teameEnem team Enem
     * @param hitHero   power hit
     */
    @Override
    public void hitEnemHero(Teame teameEnem, int hitHero) {
        int indexHero = (teameEnem.choseHeroRandom(teameEnem.getHeros()));
        ((Hero) teameEnem.getHeros().get(indexHero)).minusLife(hitHero);
        if (!((Hero) teameEnem.getHeros().get(indexHero)).getIsAlive()) {
            System.out.println("Team " + teameEnem.getName() + " Hero " + ((Hero) teameEnem.getHeros().get(indexHero)).getName() + " not exist...");
            teameEnem.getHeros().remove(indexHero);
        }
    }

    /**
     * method minus life after hit
     *
     * @param hitEnem power hit of Enem
     */
    @Override
    public void minusLife(int hitEnem) {
    }

    /**
     * change isImpruv to true - is best Hero
     */
    @Override
    public void setImpruv() {
    }

    /**
     * change isBad to true - is bad Hero
     */
    @Override
    public void setBad() {
    }

    /**
     * geter isImpruve
     *
     * @return boolean if impruve
     */
    @Override
    public boolean getIsImpruv() {
        return false;
    }

    /**
     * getter isAlive
     *
     * @return if alive true
     */
    @Override
    public boolean getIsAlive() {
        return false;
    }

    /**
     * getter name Hero
     *
     * @return name Hero
     */
    @Override
    public String getName() {
        return "Hero Base";
    }

    /**
     * info about Hero
     *
     * @return info about Hero
     */
    @Override
    public String raportHero() {
        return "Raports Hero:Base";
    }

}

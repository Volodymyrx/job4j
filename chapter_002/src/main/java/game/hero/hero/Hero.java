package game.hero.hero;

import game.hero.team.*;

/**
 * interface Hero
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public interface Hero {

    /**
     * method choise Action Hero: hit, gun, magic
     *
     * @param teameOwn  own team
     * @param teameEnem own team
     */
    void shoiseAction(Teame teameOwn, Teame teameEnem);

    /**
     * impruve Own team Hero
     *
     * @param teameOwn own team
     */
    void impruveOwnHero(Teame teameOwn);

    /**
     * do bad Enem team Hero
     *
     * @param teameEnem enem team
     */
    void badedEnemHero(Teame teameEnem);

    /**
     * hit Hero to Emem
     *
     * @param teameEnem team Enem
     * @param hitHero   power hit
     */
    void hitEnemHero(Teame teameEnem, int hitHero);

    /**
     * method minus life after hit
     *
     * @param hitEnem power hit of Enem
     */
    void minusLife(int hitEnem);

    /**
     * change isImpruv to true - is best Hero
     */
    void setImpruv();


    /**
     * change isBad to true - is bad Hero
     */
    void setBad();

    /**
     * geter isImpruve
     *
     * @return boolean if impruve
     */
    boolean getIsImpruv();

    /**
     * getter isAlive
     *
     * @return if alive true
     */
    boolean getIsAlive();

    /**
     * getter name Hero
     *
     * @return name Hero
     */
    String getName();

    /**
     * info about Hero
     *
     * @return info about Hero
     */
    String raportHero();
}

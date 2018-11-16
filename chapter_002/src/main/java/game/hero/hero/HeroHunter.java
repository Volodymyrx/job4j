package game.hero.hero;

import game.hero.Start;
import game.hero.team.Teame;

/**
 * class HeroHunter
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class HeroHunter implements Hero {
    Hero heroBase;
    private final String name;
    private final String weapon;
    private final int hitSword;
    private final int hitGun;
    private int life;
    private boolean isImpruv = false;
    private boolean isBad = false;
    private boolean isAlive = true;

    public HeroHunter(String name, String weapon, int hitSword, int hitGun, int life) {
        this.heroBase = new HeroBase();
        this.name = name;
        this.weapon = weapon;
        this.hitSword = hitSword;
        this.hitGun = hitGun;
        this.life = life;
    }

    /**
     * method choise Action Hero: hit, gun, magic
     *
     * @param teameOwn  own team
     * @param teameEnem own team
     */
    @Override
    public void shoiseAction(Teame teameOwn, Teame teameEnem) {
        double impruved = isImpruv ? 1.5 : 1;
        double baded = isBad ? 0.5 : 1;
        int typeAction = 2;
        if (Start.RANDOM.nextInt(typeAction) == 0) {
            this.hitEnemHero(teameEnem, ((int) (hitSword * impruved * baded)));
        } else {
            this.hitEnemHero(teameEnem, ((int) (hitGun * impruved * baded)));
        }
        this.isImpruv = false;
        this.isBad = false;
    }

    /**
     * no exist for this Hero
     *
     * @param teameOwn own team
     */
    @Override
    public void impruveOwnHero(Teame teameOwn) {
    }

    /**
     * do bad Enem team Hero
     *
     * @param teameEnem enem team
     */
    @Override
    public void badedEnemHero(Teame teameEnem) {
    }

    /**
     * hit Hero to Emem
     *
     * @param teameEnem team Enem
     * @param hitHero   power hit
     */
    @Override
    public void hitEnemHero(Teame teameEnem, int hitHero) {
        this.heroBase.hitEnemHero(teameEnem, hitHero);
    }

    /**
     * method minus life after hit
     *
     * @param hitEnem power hit of Enem
     */
    @Override
    public void minusLife(int hitEnem) {
        this.life -= hitEnem;
        System.out.println("result Hero " + this.name + " minus " + hitEnem + " Life and now Life is " + this.life);
        if (this.life <= 0) {
            this.isAlive = false;
        }
    }

    /**
     * change isImpruv to true - is best Hero
     */
    @Override
    public void setImpruv() {
        this.isImpruv = true;
    }

    /**
     * change isBad to true - is bad Hero
     */
    @Override
    public void setBad() {
        this.isBad = true;
    }

    /**
     * geter isImpruve
     *
     * @return boolean if impruve
     */
    @Override
    public boolean getIsImpruv() {
        return isImpruv;
    }

    /**
     * getter isAlive
     *
     * @return if alive true
     */
    @Override
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * getter name Hero
     *
     * @return name Hero
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * info about Hero
     *
     * @return info about Hero
     */
    @Override
    public String raportHero() {
        return " Raport's Hero: "
                + " name " + this.name
                + " weapon " + this.weapon
                + " life " + this.life
                + " hitSword " + this.hitSword
                + " hitGun " + this.hitGun
                + " isAliave " + this.isAlive
                + " isBad " + this.isBad
                + " isImpruve " + this.isImpruv;
    }


}

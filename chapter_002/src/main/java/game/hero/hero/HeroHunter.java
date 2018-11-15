package game.hero.hero;

import game.hero.Batele;
import game.hero.team.Teame;

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


    @Override
    public void shoiseAction(Teame teameOwn, Teame teameEnem) {
        double impruved = isImpruv ? 1.5 : 1;
        double baded = isBad ? 0.5 : 1;
        int typeAction = 2;
        if (Batele.random.nextInt(typeAction) == 0) {
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

    @Override
    public void badedEnemHero(Teame teameEnem) {

    }

    @Override
    public void setBad() {
        this.isBad = true;
    }

    @Override
    public void hitEnemHero(Teame teameEnem, int hitHero) {
        this.heroBase.hitEnemHero(teameEnem, hitHero);
    }

    @Override
    public void minusLife(int hitEnem) {
        this.life -= hitEnem;
        System.out.println("result Hero " + this.name + " minus " + hitEnem + " Life and now Life is " + this.life);
        if (this.life <= 0) {
            this.isAlive = false;
        }
    }

    @Override
    public boolean getIsAlive() {
        return isAlive;
    }

    @Override
    public boolean getIsImpruv() {
        return isImpruv;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setImpruv() {
        this.isImpruv = true;
    }

    @Override
    public String raportHero() {
        return " Raport's Hero: " +
                " name " + this.name +
                " weapon " + this.weapon +
                " life " + this.life +
                " hitSword " + this.hitSword +
                " hitGun " + this.hitGun +
                " isAliave " + this.isAlive +
                " isBad " + this.isBad +
                " isImpruve " + this.isImpruv;
    }


}

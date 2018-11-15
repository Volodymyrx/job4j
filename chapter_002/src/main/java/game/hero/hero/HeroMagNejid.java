package game.hero.hero;

import game.hero.Batele;
import game.hero.team.Teame;

public class HeroMagNejid implements Hero {
    final Hero heroBase;
    private final String name;
    private final String weapon;
    private final int hitMagic;
    private int life;
    private boolean isImpruv = false;
    private boolean isBad = false;
    private boolean isAlive = true;

    public HeroMagNejid(String name, String weapon, int hitMagic, int life) {
        this.heroBase = new HeroBase();
        this.name = name;
        this.weapon = weapon;
        this.hitMagic = hitMagic;
        this.life = life;
    }


    @Override
    public void shoiseAction(Teame teameOwn, Teame teameEnem) {
        double impruved = isImpruv ? 1.5 : 1;
        double baded = isBad ? 0.5 : 1;
        int typeAction = 2;
        if (Batele.random.nextInt(typeAction) == 0) {
            this.hitEnemHero(teameEnem, ((int) (hitMagic * impruved * baded)));
        } else {
            this.badedEnemHero(teameOwn);
        }
        this.isImpruv = false;
        this.isBad = false;
    }

    @Override
    public void setImpruv() {
        this.isImpruv = true;
    }

    @Override
    public void setBad() {
        this.isBad = true;
    }

    @Override
    public void impruveOwnHero(Teame teameOwn) {
        this.heroBase.impruveOwnHero(teameOwn);
    }


    public void badedEnemHero(Teame teameOwn) {
        this.heroBase.badedEnemHero(teameOwn);
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
    public String raportHero() {
        return " Raport's Hero: " +
                " name " + this.name +
                " weapon " + this.weapon +
                " life " + this.life +
                " hitMagic " + this.hitMagic +
                " isAliave " + this.isAlive +
                " isBad " + this.isBad +
                " isImpruve " + this.isImpruv;
    }


}

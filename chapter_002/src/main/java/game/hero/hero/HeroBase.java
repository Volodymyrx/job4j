package game.hero.hero;

import game.hero.team.Teame;

public class HeroBase implements Hero {

    @Override
    public String getName() {
        return "base";
    }

    @Override
    public void shoiseAction(Teame teameOwn, Teame teameEnem) {
    }

    @Override
    public void impruveOwnHero(Teame teameOwn) {
        int indexHero = (teameOwn.choseHeroRandom(teameOwn.getHeros()));
        ((Hero) teameOwn.getHeros().get(indexHero)).setImpruv();
    }

    @Override
    public void badedEnemHero(Teame teameEnem) {
        int indexHero = (teameEnem.choseHeroRandom(teameEnem.getHeros()));
        ((Hero) teameEnem.getHeros().get(indexHero)).setBad();
    }

    @Override
    public void hitEnemHero(Teame teameEnem, int hitHero) {
        int indexHero = (teameEnem.choseHeroRandom(teameEnem.getHeros()));
        ((Hero) teameEnem.getHeros().get(indexHero)).minusLife(hitHero);
        if (!((Hero) teameEnem.getHeros().get(indexHero)).getIsAlive()) {
            System.out.println("Team " + teameEnem.getName() +" Hero "+ ((Hero) teameEnem.getHeros().get(indexHero)).getName() + " not exist...");
            teameEnem.getHeros().remove(indexHero);
        }
    }

    @Override
    public void minusLife(int hitEnem) {

    }

    @Override
    public boolean getIsAlive() {
        return false;
    }

    @Override
    public boolean getIsImpruv() {
        return false;
    }

    @Override
    public void setImpruv() {
    }

    @Override
    public void setBad() {
    }

    @Override
    public String raportHero() {
        return "Raports Hero:Base";
    }

}

package game.hero.hero;

import game.hero.team.*;

public interface Hero {

    void shoiseAction(Teame teameOwn, Teame teameEnem);

    void impruveOwnHero(Teame teameOwn);

    void badedEnemHero(Teame teameEnem);

    void hitEnemHero(Teame teameEnem, int hitHero);

    void minusLife(int hitEnem);

    void setImpruv();

    void setBad();

    boolean getIsAlive();

    boolean getIsImpruv();

    String getName();

    String raportHero();
}

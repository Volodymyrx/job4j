package game.hero.team;

import java.util.ArrayList;

public interface Teame {


    int choiseHeroToStep(Teame teame);

    int choseHeroRandom(ArrayList heroArrayLists);

    void act(Teame teameOwn, Teame teameEnem);

    ArrayList getHeros();

    String raportTeam();

    String getName();
}

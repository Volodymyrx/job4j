package game.hero.team;

import game.hero.Batele;
import game.hero.hero.Hero;

import java.util.ArrayList;

public class TeameBase implements Teame {
    final ArrayList<Hero> heroArrayLists = new ArrayList<>();

    @Override
    public int choiseHeroToStep(Teame team) {
        int indexHero;
        ArrayList<Hero> impruvHero = new ArrayList<>();
        for (Object heroArrayList : team.getHeros()) {
            if (((Hero) heroArrayList).getIsImpruv()) {
                impruvHero.add((Hero) heroArrayList);
            }
        }
        if (impruvHero.size() > 0) {
            indexHero = choseHeroRandom(impruvHero);
        } else {
            indexHero = choseHeroRandom(team.getHeros());
        }
        return indexHero;
    }

    public int choseHeroRandom(ArrayList heroArrayLists) {
        int heros = heroArrayLists.size();
        return Batele.random.nextInt(heros);
    }


    @Override
    public void act(Teame teameOwn, Teame teameEnem) {
        if (teameOwn.getHeros().size() > 0) {
            int indexHero = choiseHeroToStep(teameOwn);
            System.out.println("Step Hero name " + ((Hero) teameOwn.getHeros().get(indexHero)).raportHero());
            ((Hero) teameOwn.getHeros().get(indexHero)).shoiseAction(teameOwn, teameEnem);
        }
    }

    @Override
    public ArrayList getHeros() {
        return heroArrayLists;
    }

    @Override
    public String raportTeam() {
        return "Team name Base teaam";
    }

    @Override
    public String getName() {
        return "Base Team";
    }
}

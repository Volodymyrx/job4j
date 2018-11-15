package game.hero.team;

import game.hero.hero.Hero;
import game.hero.hero.HeroHunter;
import game.hero.hero.HeroMagElf;
import game.hero.hero.HeroSworder;

import java.util.ArrayList;

public class TeameHuman implements Teame {
    private final String name = "Team Human";
    private final Teame teameBase;
    private ArrayList<Hero> teamHeros = new ArrayList<>();

    public TeameHuman() {
        this.teameBase = new TeameBase();
        teamHeros.add(new HeroMagElf("Mag Human", "Magic and Sword", 4, 100));
        teamHeros.add(new HeroHunter("Hunter 1", "Gun and Sword", 3, 5, 100));
        teamHeros.add(new HeroHunter("Hunter 2", "Gun and Sword", 3, 5, 100));
        teamHeros.add(new HeroHunter("Hunter 3", "Gun and Sword", 3, 5, 100));
        teamHeros.add(new HeroSworder("Sworder 1", "Sword", 18, 100));
        teamHeros.add(new HeroSworder("Sworder 2", "Sword", 18, 100));
        teamHeros.add(new HeroSworder("Sworder 3", "Sword", 18, 100));
        teamHeros.add(new HeroSworder("Sworder 4", "Sword", 18, 100));
    }

    @Override
    public ArrayList<Hero> getHeros() {
        return teamHeros;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int choiseHeroToStep(Teame teame) {
        return 0;
    }

    public int choseHeroRandom(ArrayList heroArrayLists) {
        return this.teameBase.choseHeroRandom(heroArrayLists);
    }


    @Override
    public void act(Teame teameOwn, Teame teameEnem) {
        this.teameBase.act(teameOwn, teameEnem);
    }


    /**
     * method about Team an all hero in team
     *
     * @return string about Team
     */
    @Override
    public String raportTeam() {
        StringBuilder text = new StringBuilder("Team name " + this.name);
        for (Hero teamHero : teamHeros) {
            text.append(teamHero.raportHero());
        }
        return text.toString();
    }
}

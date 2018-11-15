package game.hero.team;

import game.hero.hero.Hero;
import game.hero.hero.HeroHunter;
import game.hero.hero.HeroMagElf;
import game.hero.hero.HeroSworder;

import java.util.ArrayList;

public class TeameOrk implements Teame {
    private final String name = "Team Ork";
    private final Teame teameBase;
    private ArrayList<Hero> teamHeros = new ArrayList<>();

    public TeameOrk() {
        this.teameBase = new TeameBase();
        teamHeros.add(new HeroMagElf("Mag Ork", "Magic and Sword", 0, 100));
        teamHeros.add(new HeroHunter("Hunter 1", "Gun and Sword", 2, 3, 100));
        teamHeros.add(new HeroHunter("Hunter 2", "Gun and Sword", 2, 3, 100));
        teamHeros.add(new HeroHunter("Hunter 3", "Gun and Sword", 2, 3, 100));
        teamHeros.add(new HeroSworder("Sworder 1", "Sword", 20, 100));
        teamHeros.add(new HeroSworder("Sworder 2", "Sword", 20, 100));
        teamHeros.add(new HeroSworder("Sworder 3", "Sword", 20, 100));
        teamHeros.add(new HeroSworder("Sworder 4", "Sword", 20, 100));
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

package game.hero.team;

import game.hero.hero.Hero;
import game.hero.hero.HeroHunter;
import game.hero.hero.HeroMagElf;
import game.hero.hero.HeroSworder;

import java.util.ArrayList;

public class TeameElf implements Teame {
    private final String name = "Team Elfs";
    private final Teame teameBase;
    private ArrayList<Hero> teamHeros = new ArrayList<>();

    public TeameElf() {
        this.teameBase = new TeameBase();
        teamHeros.add(new HeroMagElf("Mag Elf", "Magic and Sword", 10, 100));
        teamHeros.add(new HeroHunter("Hunter 1", "Gun and Sword", 3, 7, 100));
        teamHeros.add(new HeroHunter("Hunter 2", "Gun and Sword", 3, 7, 100));
        teamHeros.add(new HeroHunter("Hunter 3", "Gun and Sword", 3, 7, 100));
        teamHeros.add(new HeroSworder("Sworder 1", "Sword", 15, 100));
        teamHeros.add(new HeroSworder("Sworder 2", "Sword", 15, 100));
        teamHeros.add(new HeroSworder("Sworder 3", "Sword", 15, 100));
        teamHeros.add(new HeroSworder("Sworder 4", "Sword", 15, 100));
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

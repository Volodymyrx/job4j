package game.hero.team;

import game.hero.Start;
import game.hero.hero.Hero;

import java.util.ArrayList;

/**
 * class TeamBase
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class TeameBase implements Teame {
    private final String ln = System.lineSeparator();
    final ArrayList<Hero> heroArrayLists = new ArrayList<>();

    /**
     * method about Team an all hero in team
     *
     * @return string about Team
     */
    @Override
    public String raportTeam(Teame teame) {
        StringBuilder text = new StringBuilder("Team name " + teame.getName());
        for (Object teamHero : teame.getHeros()) {
            text.append(ln);
            text.append(((Hero) teamHero).raportHero());
        }
        text.append(teame.getHeros().size() == 0 ? ln + "   Nobody... " : "");
        return text.toString();
    }

    /**
     * get name of Team
     *
     * @return String name
     */
    @Override
    public String getName() {
        return "Team Base";
    }

    /**
     * choise number Hero from list
     *
     * @param team complet team
     * @return int number of Hero in list
     */
    @Override
    public int choiseHeroToStep(Teame team) {
        int indexHero;
        ArrayList<Hero> impruvHeroList = new ArrayList<>();
        for (Object heroArrayList : team.getHeros()) {
            if (((Hero) heroArrayList).getIsImpruv()) {
                impruvHeroList.add((Hero) heroArrayList);
            }
        }
        if (impruvHeroList.size() > 0) {
            int indexHeroImpruve = choseHeroRandom(impruvHeroList);
            indexHero = team.getHeros().indexOf(impruvHeroList.get(indexHeroImpruve));
        } else {
            indexHero = choseHeroRandom(team.getHeros());
        }
        return indexHero;
    }

    /**
     * ramndom choise number in list
     *
     * @param heros list of Hero
     * @return int number of Hero in list
     */
    public int choseHeroRandom(ArrayList heros) {
        return Start.RANDOM.nextInt(heros.size());
    }

    /**
     * метод выбора действия команды
     *
     * @param teameOwn  своя команда
     * @param teameEnem враг команда
     */
    @Override
    public void act(Teame teameOwn, Teame teameEnem) {
        if (teameOwn.getHeros().size() > 0) {
            int indexHero = choiseHeroToStep(teameOwn);
            System.out.println("Step " + teameOwn.getName() + " Hero name " + ((Hero) teameOwn.getHeros().get(indexHero)).getName());
            ((Hero) teameOwn.getHeros().get(indexHero)).shoiseAction(teameOwn, teameEnem);
        }
    }

    /**
     * get list Heros of Team
     *
     * @return list
     */
    @Override
    public ArrayList getHeros() {
        return heroArrayLists;
    }
}

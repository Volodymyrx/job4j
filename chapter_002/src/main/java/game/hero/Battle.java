package game.hero;

import game.hero.team.*;

/**
 * class Battle
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class Battle {
    private final Teame teameA;
    private final Teame teameB;

    public Battle(Teame teameA, Teame teameB) {
        this.teameA = teameA;
        this.teameB = teameB;
    }

    /**
     * base engin of game
     *
     * @return how is winer
     */
    public String game() {

        infoTeams("Start content of teams: ", teameA, teameB);
        int counterSteps = 0;
        do {
            if ((Start.RANDOM.nextBoolean())) {
                teameA.act(teameA, teameB);
            } else {
                teameB.act(teameB, teameA);
            }
            counterSteps++;
        } while (teameA.getHeros().size() > 0 && teameB.getHeros().size() > 0);
        infoTeams("End content of teams: ", teameA, teameB);
        String winer = (teameA.getHeros().size() > 0) ? teameA.getName() : teameB.getName();
        System.out.println("Count of step: " + counterSteps);
        return ("Game over! Winer " + winer);
    }

    /**
     * String info to concole about state teams
     *
     * @param info   some text
     * @param teameA teamA
     * @param teameB teamB
     */
    private void infoTeams(String info, Teame teameA, Teame teameB) {
        System.out.println();
        System.out.println(info);
        System.out.println(teameA.raportTeam(teameA));
        System.out.println(teameB.raportTeam(teameB));
    }

}

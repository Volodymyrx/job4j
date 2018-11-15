package game.hero;

import game.hero.team.*;

import java.util.Random;

public class Batele {
    public static final Random random = new Random();

    /**
     *
     */
    public void game() {
        Teame teameA=random.nextBoolean()?new TeameElf():new TeameHuman();
        Teame teameB=random.nextBoolean()?new TeameOrk():new TeameNejid();
        infoTeams("Start content of teams: ", teameA, teameB);
        int counterSteps = 0;
        do {
            if (random.nextBoolean()) {
                System.out.println("Step camp A " + teameA.getName());
                teameA.act(teameA, teameB);

            } else {
                System.out.println("Step camp B " + teameB.getName());
                teameB.act(teameB, teameA);
            }
            counterSteps++;
        } while (teameA.getHeros().size() > 0 && teameB.getHeros().size() > 0);
        infoTeams("End content of teams: ", teameA, teameB);

        System.out.println("Count of step: " + counterSteps);
        System.out.println("Game end!");

    }

    private void infoTeams(String info, Teame teameA, Teame teameB) {
        System.out.println();
        System.out.println(info);
        System.out.println(teameA.raportTeam());
        System.out.println(teameB.raportTeam());
    }

}

package game.hero;

import game.hero.team.*;

import java.util.Random;

/**
 * class Start main class
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class Start {
    public final static Random RANDOM = new Random();

    public static void main(String[] args) {
        new Start().init();
    }

    public void init() {
        Teame teameA = RANDOM.nextBoolean() ? new TeameElf(1, 3, 4) : new TeameHuman(1, 3, 4);
        Teame teameB = RANDOM.nextBoolean() ? new TeameOrk(1, 3, 4) : new TeameNejid(1, 3, 4);
        Battle battle = new Battle(teameA, teameB);
        System.out.println(battle.game());
    }
}

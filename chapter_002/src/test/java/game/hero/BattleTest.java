package game.hero;

import game.hero.team.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class BattleTest
 * project Game Hero
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j plus
 * @version 1.0
 * @since 15.11.2018
 */
public class BattleTest {

    /**
     * public String game()
     */
    @Test
    public void whenElfBigestNejidThenWinElfs() {
        Teame teameBig = new TeameElf(5, 5, 5);
        Teame teameSmall = new TeameNejid(1, 1, 1);
        Battle battle = new Battle(teameBig, teameSmall);
        assertThat(battle.game(), is("Game over! Winer Team Elfs"));
    }

    @Test
    public void whenElfBigestOrkThenWinElfs() {
        Teame teameBig = new TeameElf(5, 5, 5);
        Teame teameSmall = new TeameOrk(1, 1, 1);
        Battle battle = new Battle(teameBig, teameSmall);
        assertThat(battle.game(), is("Game over! Winer Team Elfs"));
    }

    @Test
    public void whenHumanBigestNejidThenWinHumans() {
        Teame teameBig = new TeameHuman(5, 5, 5);
        Teame teameSmall = new TeameNejid(1, 1, 1);
        Battle battle = new Battle(teameBig, teameSmall);
        assertThat(battle.game(), is("Game over! Winer Team Humans"));
    }

    @Test
    public void whenHumanBigestOrkThenWinHumans() {
        Teame teameBig = new TeameHuman(5, 5, 5);
        Teame teameSmall = new TeameOrk(1, 1, 1);
        Battle battle = new Battle(teameBig, teameSmall);
        assertThat(battle.game(), is("Game over! Winer Team Humans"));
    }

    @Test
    public void whenNejidBigestElfThenWinNejids() {
        Teame teameBig = new TeameNejid(5, 5, 5);
        Teame teameSmall = new TeameElf(1, 1, 1);
        Battle battle = new Battle(teameBig, teameSmall);
        assertThat(battle.game(), is("Game over! Winer Team Nejids"));
    }

    @Test
    public void whenNejidBigestHumanThenWinNejids() {
        Teame teameBig = new TeameNejid(5, 5, 5);
        Teame teameSmall = new TeameHuman(1, 1, 1);
        Battle battle = new Battle(teameBig, teameSmall);
        assertThat(battle.game(), is("Game over! Winer Team Nejids"));
    }

    @Test
    public void whenOrkBigestElfThenWinOrks() {
        Teame teameBig = new TeameOrk(5, 5, 5);
        Teame teameSmall = new TeameElf(1, 1, 1);
        Battle battle = new Battle(teameBig, teameSmall);
        assertThat(battle.game(), is("Game over! Winer Team Orks"));
    }

    @Test
    public void whenOrkBigestHumanThenWinOrks() {
        Teame teameBig = new TeameOrk(5, 5, 5);
        Teame teameSmall = new TeameHuman(1, 1, 1);
        Battle battle = new Battle(teameBig, teameSmall);
        assertThat(battle.game(), is("Game over! Winer Team Orks"));
    }
}
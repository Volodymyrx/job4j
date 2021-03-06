package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

/**
 * Logic
 * logic of game
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson Пазлы. Тестовое задание.
 * @version 1.0
 * @since 12.10.2018
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * method for test if you win
     * you win if five in row or col
     *
     * @return thrue if win
     */
    public boolean isWin() {
        int[][] table = this.convert();
        boolean result = false;
        int tempCountVertical = 0;
        int tempCountHorizontal = 0;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == 1) {
                    tempCountHorizontal++;
                }
                if ((table[j][i] == 1)) {
                    tempCountVertical++;
                }
                if ((tempCountHorizontal == this.size) || (tempCountVertical == this.size)) {
                    result = true;
                    break;
                }
            }
            if (result) {
                break;
            }
            tempCountHorizontal = 0;
            tempCountVertical = 0;
        }
        return result;
    }

    /*change privet to public for test method isWin*/
    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}

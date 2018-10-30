package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Optional;

/**
 * Logic
 * part of project chess
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j lesson 002.8
 * @version 1.0
 * @since 30.10.2018
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        try {
            int index = this.findBy(source);
            if (index < 0) {
                throw new FigureNotFoundException("Figue not found.");
            }
            Cell[] steps = this.figures[index].way(source, dest);
            if (!(steps.length > 0 && steps[steps.length - 1].equals(dest))) {
                throw new ImpossibleMoveException("This way is impossible for this figure.");
            }
            if (!isEmptySteps(steps)) {
                throw new OccupiedWayException("This way of this figur is occupied.");
            }
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        } finally {
            return rst;
        }
    }

//    public boolean move(Cell source, Cell dest) {
//        boolean rst = false;
//        int index = this.findBy(source);
//        if (index != -1) {
//            Cell[] steps = this.figures[index].way(source, dest);
//            if (steps.length > 0 && isEmptySteps(steps) && steps[steps.length - 1].equals(dest)) {
//                rst = true;
//                this.figures[index] = this.figures[index].copy(dest);
//            }
//        }
//        return rst;
//    }


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
     * метод проверяет пустые ли ячейки на пути следования фигуры
     *
     * @param steps array cells - путь фигуры в ячейках
     * @return true если путь свободен
     */
    private boolean isEmptySteps(Cell[] steps) {
        boolean result = true;
        for (Figure figure : figures) {
            for (Cell step : steps) {
                if (figure.position() == step) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }


}

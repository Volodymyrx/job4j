package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }


    /**
     * метод возвращает путь в ячейках фигуры
     * у коня свои правила - может перепрыгивать через фигуры
     *
     * @param source начальная ячейка
     * @param dest   конечная ячейка
     * @return массив ячеек
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (isRightStep(source, dest)) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    /**
     * метод проверяет ходы коня буквой Г
     *
     * @param source начальная ячейка
     * @param dest   конечная ячейка
     * @return true правильный путь
     */
    public boolean isRightStep(Cell source, Cell dest) {
        boolean result = false;
        boolean type1 = (Math.abs(source.x - dest.x) == 1) && (Math.abs(source.y - dest.y) == 2);
        boolean type2 = (Math.abs(source.x - dest.x) == 2) && (Math.abs(source.y - dest.y) == 1);
        if (type1 || type2) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}

package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookWhite implements Figure {
    private final Cell position;

    public RookWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * метод проверяет по горизонтали или вертикали идет ладья
     *
     * @param source начальная ячейка
     * @param dest   конечная ячейка
     * @return true если горизонталь или вертикаль
     */
    @Override
    public boolean isRightStep(Cell source, Cell dest) {
        boolean result = false;
        if ((source.x == dest.x) || (source.y == dest.y)) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}

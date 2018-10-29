package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * метод проверяет по диогонали ли идет слон
     *
     * @param source начальная ячейка
     * @param dest   конечная ячейка
     * @return true если диогональ
     */
    @Override
    public boolean isRightStep(Cell source, Cell dest) {
        boolean result = false;
        if ((Math.abs(source.x - dest.x)) == (Math.abs(source.y - dest.y))) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

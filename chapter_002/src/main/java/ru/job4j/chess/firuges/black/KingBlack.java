package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingBlack implements Figure {
    private final Cell position;

    public KingBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * метод проверяет смещение на одну клетку короля
     *
     * @param source начальная ячейка
     * @param dest   конечная ячейка
     * @return true если горизонталь или вертикаль
     */
    @Override
    public boolean isRightStep(Cell source, Cell dest) {
        boolean result = false;
        if (((Math.abs(source.x - dest.x)) <= 1) && ((Math.abs(source.y - dest.y)) <= 1)) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }
}

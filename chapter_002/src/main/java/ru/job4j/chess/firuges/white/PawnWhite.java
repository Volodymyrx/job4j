package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite implements Figure {
    private final Cell position;

    public PawnWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * метод проверяет правильность хода белой пешки
     *
     * @param source начальная ячейка
     * @param dest   конечная ячейка
     * @return true если правильный ход
     */
    @Override
    public boolean isRightStep(Cell source, Cell dest) {
        boolean result = false;
        boolean type1 = (source.y == 1) && (source.y == dest.y - 2) && (source.x == dest.x);
        boolean type2 = (source.y == dest.y - 1) && (source.x == dest.x);
        if (type1 || type2) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}

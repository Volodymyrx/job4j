package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * метод проверяет правильность хода черной пешки
     *
     * @param source начальная ячейка
     * @param dest   конечная ячейка
     * @return true если правильный ход
     */
    @Override
    public boolean isRightStep(Cell source, Cell dest) {
        boolean result = false;
        boolean type1 = (source.y == 6) && (source.y == dest.y + 2) && (source.x == dest.x);
        boolean type2 = (source.y == dest.y + 1) && (source.x == dest.x);
        if (type1 || type2) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}

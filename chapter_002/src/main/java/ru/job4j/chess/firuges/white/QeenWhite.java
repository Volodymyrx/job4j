package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class QeenWhite implements Figure {
    private final Cell position;

    public QeenWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * метод проверяет по горизонтали или вертикали или диагонали идет ферзь
     *
     * @param source начальная ячейка
     * @param dest   конечная ячейка
     * @return true если горизонталь или вертикаль
     */
    @Override
    public boolean isRightStep(Cell source, Cell dest) {
        boolean result = false;
        boolean type1 = ((Math.abs(source.x - dest.x)) == (Math.abs(source.y - dest.y)));
        boolean type2 = ((source.x == dest.x) || (source.y == dest.y));
        if (type1 || type2) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }
}

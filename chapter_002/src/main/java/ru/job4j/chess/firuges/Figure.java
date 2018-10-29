package ru.job4j.chess.firuges;

public interface Figure {
    Cell position();


    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

    /**
     * метод возвращает путь в ячейках фигуры
     *
     * @param source начальная ячейка
     * @param dest   конечная ячейка
     * @return массив ячеек
     */
    default Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (isRightStep(source, dest)) {
            steps = new Cell[Math.max(Math.abs(source.x - dest.x), Math.abs(source.y - dest.y))];
            int i = 0;
            int x = source.x;
            int y = source.y;
            while (i < steps.length) {
                x += ((dest.x - source.x) / steps.length);
                y += ((dest.y - source.y) / steps.length);
                for (Cell cell : Cell.values()) {
                    if (cell.x == x && cell.y == y) {
                        steps[i++] = cell;
                        break;
                    }
                }
            }
        }
        return steps;
    }

    /**
     * метод проверяет правильность хода фигуры
     *
     * @param source начальная ячейка
     * @param dest   конечная ячейка
     * @return true если правильный ход
     */
    boolean isRightStep(Cell source, Cell dest);
}

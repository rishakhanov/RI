package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookBlack implements Figure {
    private final Cell position;

    public RookBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[Math.max(Math.abs(source.y - dest.y), Math.abs(source.x - dest.x))];
        if (((source.y - dest.y) != 0) && ((source.x - dest.x) != 0)) {
            throw new ImpossibleMoveException("Impossible Move");
        }
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Cell.values()[8 * source.x + source.y + (dest.x - source.x) / steps.length * (i + 1) * 8
                    + (dest.y - source.y) / steps.length * (i + 1)];
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }
}

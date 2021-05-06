package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static java.lang.Math.abs;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position(),dest)) {
        throw new ImpossibleMoveException(
                String.format("Could not way by diagonal from %s to %s", position, dest));
        }
            int size = abs(position().getX() - dest.getX());
            Cell[] steps = new Cell[size];
            int deltaX = position().getX() < dest.getX() ? 1 : -1;
            int deltaY = position().getY() < dest.getY() ? 1 : -1;
                for (int index = 0; index < size; index++) {
                    int x = index + deltaX + position().getX();
                    int y = (index * deltaY) + deltaY + position().getY();
                    steps[index] = Cell.findBy(x, y);
                }
            return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (abs(dest.getX() - source.getX()) == abs(dest.getY() - source.getY())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

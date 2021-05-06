package ru.job4j.chess.firuges.black;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C2);
        assertThat(bishopBlack.position(), is(Cell.C2));
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
       assertThat(bishopBlack.copy(Cell.A5).position(), is(Cell.A5));

    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C5);
       Cell[] steps = bishopBlack.way(Cell.G1);
       Cell[] expected = new Cell[] {Cell.D4, Cell.E3,Cell.F2, Cell.G1};
       assertArrayEquals(expected, steps);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        bishopBlack.way(Cell.G4);
    }
}
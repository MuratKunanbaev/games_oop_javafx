package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;


public class LogicTest {
    @Test(expected = FigureNotFoundException.class)
    public void whenTheFigureNotFound() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.move(Cell.D4, Cell.H8);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenFigureMoveNotDiagonally() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B1));
        logic.move(Cell.B1, Cell.G1);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenOccupiedCell() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new BishopBlack(Cell.G7));
        logic.move(Cell.F8, Cell.H6);
    }
}
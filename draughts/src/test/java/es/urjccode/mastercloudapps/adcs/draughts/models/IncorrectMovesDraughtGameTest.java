package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IncorrectMovesDraughtGameTest extends GameTest {

    private Color color;
    private String[] strings;

    protected void setGame(Color color, String... strings) {
        this.color = color;
        this.strings = strings;
        super.setGame(color, strings);
    }

    private void assertErrorMove(Error error, Coordinate... coordinates) {
        assertEquals(error, this.game.move(coordinates));
        assertEquals(new GameBuilder().color(color).rows(strings).build(), this.game);
    }

    @Test
    public void testGivenGameWhenMoveWHITESecondThenNOT_EMPTY_TARGET() {
        setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "    n   ",
            "   n    ",
            "        ",
            " n      ",
            "B       ");
        assertErrorMove(Error.NOT_EMPTY_TARGET,
            new Coordinate(7, 0),
            new Coordinate(5, 2),
            new Coordinate(3, 4));
    }

    @Test
    public void testGivenGameWhenMoveBLACKSecondThenNOT_EMPTY_TARGET() {
        setGame(Color.BLACK,
            "        ",
            "  N     ",
            "   b    ",
            "        ",
            "   b    ",
            "  b     ",
            "        ",
            "        ");
        assertErrorMove(Error.NOT_EMPTY_TARGET,
            new Coordinate(1, 2),
            new Coordinate(3, 4),
            new Coordinate(5, 2));
    }


    @Test
    public void testGivenGameWhenMoveWHITEEatingThenCOLLEAGUE_EATING() {
        setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "     b  ",
            "      B ",
            "        ",
            "        ");
        assertErrorMove(Error.COLLEAGUE_EATING,
            new Coordinate(5, 6),
            new Coordinate(0, 1));
    }

    @Test
    public void testGivenGameWhenMoveBLACKEatingThenCOLLEAGUE_EATING() {
        setGame(Color.BLACK,
            "        ",
            "        ",
            "   n    ",
            "        ",
            "        ",
            "      N ",
            "        ",
            "        ");
        assertErrorMove(Error.COLLEAGUE_EATING,
            new Coordinate(5, 6),
            new Coordinate(0, 1));
    }

    @Test
    public void testGivenGameWhenMoveWHITEEatingThenTOO_MUCH_EATINGS() {
        setGame(Color.WHITE,
            "        ",
            "        ",
            "   n    ",
            "        ",
            "     n  ",
            "      B ",
            "        ",
            "        ");
        assertErrorMove(Error.TOO_MUCH_EATINGS,
            new Coordinate(5, 6),
            new Coordinate(0, 1));
    }

    @Test
    public void testGivenGameWhenMoveBLACKEatingThenTOO_MUCH_EATINGS() {
        setGame(Color.BLACK,
            "        ",
            "        ",
            "   b    ",
            "        ",
            "     b  ",
            "      N ",
            "        ",
            "        ");
        assertErrorMove(Error.TOO_MUCH_EATINGS,
            new Coordinate(5, 6),
            new Coordinate(0, 1));
    }

    @Test
    public void testGivenGameWhenMoveWHITEThenTOO_MUCH_JUMPS() {
        setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            " B      ",
            "        ",
            "        ",
            "        ");
        assertErrorMove(Error.TOO_MUCH_JUMPS,
            new Coordinate(4, 1),
            new Coordinate(3, 2),
            new Coordinate(2, 3));
    }

    @Test
    public void testGivenGameWhenMoveBLACKThenTOO_MUCH_JUMPS() {
        setGame(Color.BLACK,
            "        ",
            "        ",
            "   N    ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        assertErrorMove(Error.TOO_MUCH_JUMPS,
            new Coordinate(2, 3),
            new Coordinate(3, 4),
            new Coordinate(4, 3));
    }

    @Test
    public void testGivenGameWhenMoveWHITEEatingThenTOO_MUCH_JUMPS() {
        setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "  n     ",
            " B      ",
            "        ",
            "        ",
            "        ");
        assertErrorMove(Error.TOO_MUCH_JUMPS,
            new Coordinate(4, 1),
            new Coordinate(2, 3),
            new Coordinate(1, 2));
    }
}

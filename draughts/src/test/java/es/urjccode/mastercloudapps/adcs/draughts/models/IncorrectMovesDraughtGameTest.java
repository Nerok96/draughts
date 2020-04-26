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

}

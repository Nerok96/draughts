package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CorrectMovesDraughtGameTest extends GameTest {

    private void assertMove(Coordinate... coordinates){
        assertNull(this.game.move(coordinates));
        assertEquals(this.game, this.expectedGame);
    }

    @Test
    public void testGivenGameWhenMoveWHITEThenWithoutWITHOUT_EATING() {
        setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "    B   ",
            "        ",
            "        ");
        setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "  B     ",
            "        ",
            "        ",
            "        ",
            "        ");
        assertMove(
            new Coordinate(5, 4),
            new Coordinate(3, 2));
    }

    @Test
    public void testGivenGameWhenMoveBLACKThenWithoutTOO_MUCH_ADVANCED() {
        setGame(Color.BLACK,
            "        ",
            "        ",
            " N      ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        setExpectedGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "        ",
            "    N   ",
            "        ",
            "        ");
        assertMove(
            new Coordinate(2, 1),
            new Coordinate(5, 4));
    }

}

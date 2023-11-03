import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    @Test
    public void testAllZeros() {
        BowlingGame game=new BowlingGame();
        for(int i=0; i<20; i++) {
            game.throwBall(0);
        }
        assertEquals(0, game.getScore());
    }

    @Test
    public void testAllOnes() {
        BowlingGame game=new BowlingGame();
        for(int i=0; i<20; i++) {
            game.throwBall(1);
        }
        assertEquals(20, game.getScore());
    }

    @Test
    public void testOneSpare() {
        BowlingGame game=new BowlingGame();
        game.throwBall(5);
        game.throwBall(5); //spare
        game.throwBall(3);
        for(int i=0; i<17; i++) {
            game.throwBall(0);
        }
        assertEquals(16, game.getScore());
    }

    @Test
    public void testOneStrike() {
        BowlingGame game=new BowlingGame();
        game.throwBall(10); //strike
        game.throwBall(3);
        game.throwBall(4);
        for(int i=0; i<16; i++) {
            game.throwBall(0);
        }
        assertEquals(24, game.getScore());
    }

    @Test
    public void testPerfectGame() {
        BowlingGame game=new BowlingGame();
        for(int i=0; i<12; i++) {
            game.throwBall(10);
        }
        assertEquals(300, game.getScore());
    }

}

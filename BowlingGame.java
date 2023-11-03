public class BowlingGame {
    private int[] rolls;
    private int currentRoll;

    public BowlingGame() {
        rolls=new int[21]; // maximum rolls in a game
        currentRoll=0;
    }

    public void throwBall(int pins) {
        rolls[currentRoll++]=pins;
    }

    public int getScore() {
        return calculateScore(0,0);
    }

    private int calculateScore(int frameIndex, int currentScore) {
        if(frameIndex==10)
            return currentScore;
        int score=currentScore;
        if(isStrike(frameIndex)) {
            score+=10+strikeBonus(frameIndex);
            return calculateScore(frameIndex+2, score);
        } else if(isSpare(frameIndex)) {
            score+=10+spareBonus(frameIndex);
            return calculateScore(frameIndex+2, score);
        } else {
            score+=sumOfBallsInFrame(frameIndex);
            return calculateScore(frameIndex+2, score);
        }
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex]==10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex]+rolls[frameIndex+1]==10;
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex]+rolls[frameIndex+1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex+2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex+1]+rolls[frameIndex+2];
    }

    public static void main(String[] args) {
        BowlingGame game=new BowlingGame();
        game.throwBall(1);
        game.throwBall(4);
        int finalScore=game.getScore();
        System.out.println("Final Score: "+finalScore);
    }
}

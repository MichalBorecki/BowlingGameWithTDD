public class Game {

    private int score = 0;
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int frameIndex = 0;
        ruleBowling(frameIndex);
        return score;
    }

    private void ruleBowling(int frameIndex) {
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rolls[frameIndex])) {
                score += 10 + nextTwoBallsForStrike(frameIndex);
                frameIndex += 1;
            } else if (isSpare(frameIndex)) {
                score += 10 + addNextBallForSpare(frameIndex);
                frameIndex += 2;
            } else {
                score += twoBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
    }

    private int twoBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int addNextBallForSpare(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int nextTwoBallsForStrike(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }
}

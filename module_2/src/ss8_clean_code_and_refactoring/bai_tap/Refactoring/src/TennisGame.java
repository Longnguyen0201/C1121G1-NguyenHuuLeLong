package ss8_clean_code_and_refactoring.bai_tap.Refactoring.src;

public class TennisGame {

    public static final char DASH = '-';
    public static final int SCORE15 = 1;
    public static final int SCORE30 = 2;
    public static final int SCORE40 = 3;
    public static final int SCORE0 = 0;
    public static String score="";

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {


        if (scorePlayer1 == scorePlayer2) {
            return getDeuce(scorePlayer1);
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            return getPlayerWin(scorePlayer1, scorePlayer2);
        } else {
            return getScoreInPlay(scorePlayer1, scorePlayer2, score);
        }
    }

    private static String getScoreInPlay(int scorePlayer1, int scorePlayer2, String score) {
        for (int i = 1; i < 3; i++) {
            int tempScore;
            if (i == 1) {
                tempScore = scorePlayer1;
            } else {
                score += DASH;
                tempScore = scorePlayer2;
            }
            score = getTempScore(score, tempScore);
        }
        return score;
    }

    private static String getTempScore(String score, int tempScore) {
        switch (tempScore) {
            case SCORE0:
                score += "Love";
                break;
            case SCORE15:
                score += "Fifteen";
                break;
            case SCORE30:
                score += "Thirty";
                break;
            case SCORE40:
                score += "Forty";
                break;
        }
        return score;
    }

    private static String getPlayerWin(int scorePlayer1, int scorePlayer2) {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private static String getDeuce(int scorePlayer) {

        switch (scorePlayer) {
            case SCORE0:
                return "Love-All";
            case SCORE15:
                return "Fifteen-All";
            case SCORE30:
                return "Thirty-All";
            case SCORE40:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
}

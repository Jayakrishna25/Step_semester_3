package main.java.week_5.class_problem;
import java.util.Arrays;

class HackathonScoreBooster {

    static void curveScores(int[] scores, int bonus) {
        if (scores == null) {
            return;
        }

        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        int bonus = 10;

        curveScores(scores, bonus);

        System.out.println(Arrays.toString(scores));
    }
}

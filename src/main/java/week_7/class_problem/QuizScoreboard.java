package main.java.week_7.class_problem;
class Scorecard {
    private final boolean[] answers;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        if (totalQuestions < 0) {
            this.answers = new boolean[0];
        } else {
            this.answers = new boolean[totalQuestions];
        }
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount >= answers.length) {
            System.out.println("Rejected: all questions have already been answered");
            return;
        }
        answers[recordedCount++] = isCorrect;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (answers[i]) {
                score++;
            }
        }
        return score;
    }
}

class QuizScorecardDemo {

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("sc.getScore() -> " + sc.getScore());
    }
}

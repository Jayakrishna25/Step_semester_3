package main.java.week_8.class_problem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class ExaminationQuestion {
    private final String questionType;
    private final String questionText;
    private final String correctAnswer;
    private final String studentAnswer;
    private final double points;

    public ExaminationQuestion(String questionType, String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionType = questionType;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public String getQuestionType() {
        return this.questionType;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public String getStudentAnswer() {
        return this.studentAnswer;
    }

    public double getPoints() {
        return this.points;
    }

    public abstract double evaluateScore();
}

class McqQuestion extends ExaminationQuestion {
    public McqQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("MCQ", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        if (getStudentAnswer().equalsIgnoreCase(getCorrectAnswer())) {
            return getPoints();
        }
        return 0.0;
    }
}

class TrueFalseQuestion extends ExaminationQuestion {
    public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("TF", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        if (getStudentAnswer().equalsIgnoreCase(getCorrectAnswer())) {
            return getPoints();
        }
        return 0.0;
    }
}

class EssayQuestion extends ExaminationQuestion {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super("ESSAY", questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double evaluateScore() {
        String[] keywords = getCorrectAnswer().split(",");
        String studentAnswerLower = getStudentAnswer().toLowerCase();
        int matchedKeywords = 0;

        for (String keyword : keywords) {
            String trimmedKeyword = keyword.trim().toLowerCase();
            if (!trimmedKeyword.isEmpty() && studentAnswerLower.contains(trimmedKeyword)) {
                matchedKeywords++;
            }
        }

        if (matchedKeywords >= 2) {
            return getPoints() * 0.75;
        } else if (matchedKeywords == 1) {
            return getPoints() * 0.50;
        } else {
            return 0.0;
        }
    }
}

class ExaminationQuestionGrader {

    public static List<String> parseLineTokens(String line) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        int n = line.length();

        while (i < n) {
            while (i < n && Character.isWhitespace(line.charAt(i))) {
                i++;
            }
            if (i >= n) {
                break;
            }

            if (line.charAt(i) == '"') {
                i++;
                StringBuilder sb = new StringBuilder();
                while (i < n && line.charAt(i) != '"') {
                    sb.append(line.charAt(i));
                    i++;
                }
                if (i < n && line.charAt(i) == '"') {
                    i++;
                }
                tokens.add(sb.toString());
            } else {
                StringBuilder sb = new StringBuilder();
                while (i < n && !Character.isWhitespace(line.charAt(i))) {
                    sb.append(line.charAt(i));
                    i++;
                }
                tokens.add(sb.toString());
            }
        }
        return tokens;
    }

    public static ExaminationQuestion createQuestion(List<String> tokens) {
        String type = tokens.get(0).toUpperCase();
        String questionText = tokens.get(1);
        String correctAnswer = tokens.get(2);
        String studentAnswer = tokens.get(3);
        double points = Double.parseDouble(tokens.get(4));

        switch (type) {
            case "MCQ":
                return new McqQuestion(questionText, correctAnswer, studentAnswer, points);
            case "TF":
                return new TrueFalseQuestion(questionText, correctAnswer, studentAnswer, points);
            case "ESSAY":
                return new EssayQuestion(questionText, correctAnswer, studentAnswer, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        scanner.nextLine();

        ExaminationQuestion[] questions = new ExaminationQuestion[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            List<String> tokens = parseLineTokens(line);
            questions[i] = createQuestion(tokens);
        }

        double totalScore = 0.0;

        for (ExaminationQuestion question : questions) {
            double score = question.evaluateScore();
            totalScore += score;
            System.out.printf("%s: %.2f\n", question.getQuestionType(), score);
        }

        System.out.printf("Total Score: %.2f\n", totalScore);

        scanner.close();
    }
}

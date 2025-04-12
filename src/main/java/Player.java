import java.util.Arrays;

public class Player {
    private int correctAnswers = 0;

    public void checkAnswer(String answer, Question question) {
        if (answer.equals(question.getCorrectAnswer()) ||
                (question.getType().equals("more") && this.checkAnagram(question.getCorrectAnswer(), answer))) {
            System.out.println("Correct!!!");
            this.setCorrectAnswers(this.getCorrectAnswers() + 1);
        } else {
            System.out.println("Wrong!!!");
        }
        System.out.println();
    }

    public void printStats(Quiz quiz) {
        System.out.println(quiz.getName() + " quiz is finished!!!");
        System.out.println("Your score is: " + this.correctAnswers);
        System.out.println();
    }

    private boolean checkAnagram(String a, String b) {
        char[] lettersA = a.toCharArray();
        char[] lettersB = b.toCharArray();

        Arrays.sort(lettersA);
        Arrays.sort(lettersB);

        return Arrays.equals(lettersA,lettersB);
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }
}

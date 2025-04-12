
public class Player {
    private int correctAnswers = 0;

    public void checkAnswer(String answer, Question question) {
        if (answer.equals(question.getCorrectAnswer())) {
            System.out.println("Correct!!!");
            this.setCorrectAnswers(this.getCorrectAnswers() + 1);
        } else {
            System.out.println("Wrong!!!");
        }
        System.out.println();
    }

    public void printStats(Quiz quiz) {
        System.out.println(quiz.getName() + " quiz is finished!!!");
        System.out.println("You score is: " + this.correctAnswers);
        System.out.println();
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }
}

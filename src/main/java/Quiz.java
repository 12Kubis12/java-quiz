import java.util.ArrayList;

public class Quiz {
    private final String name;
    private final ArrayList<Question> questions;

    public Quiz(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void removeQuestion(int index) {
        this.questions.remove(index);
    }

    public void printInfo() {
        System.out.println("You chose a quiz about " + this.getName() + ". Good luck!!!");
        System.out.println();
    }

    public void printStats(Player player) {
        System.out.println((this.name) + " quiz is finished!!!");
        System.out.println("Your score from " + this.questions.size() + " questions: " + player.getCorrectAnswers());
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}

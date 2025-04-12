import java.util.ArrayList;

public class Quiz {
    private final String name;
    private final ArrayList<Question> questions;

    public Quiz(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

}

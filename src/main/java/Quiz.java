import java.util.ArrayList;

public class Quiz {
    private final String NAME;
    private final ArrayList<Question> QUESTIONS;

    public Quiz(String name, ArrayList<Question> questions) {
        this.NAME = name;
        this.QUESTIONS = questions;
    }

    public String getName() {
        return NAME;
    }

    public ArrayList<Question> getQuestions() {
        return QUESTIONS;
    }
}

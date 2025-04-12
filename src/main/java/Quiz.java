import java.util.ArrayList;

public class Quiz {
    private String name;
    private ArrayList<Question> questions;

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

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String questionText;
    private ArrayList<Answer> answers;

    public Question(String questionText, ArrayList<Answer> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }
}

import java.util.ArrayList;

public class Question {

    private final String QUESTION_TEXT;
    private final ArrayList<Answer> ANSWERS;
    private final String TYPE;

    public Question(String questionText, String type, ArrayList<Answer> answers) {
        this.QUESTION_TEXT = questionText;
        this.TYPE = type;
        this.ANSWERS = answers;
    }

    public void showQuestion() {
        System.out.println(this.getQuestionText());
        if (!this.getType().equals("write")) {
            if (this.getType().equals("one")) {
                System.out.println("(Single correct answer -> write one option: \"a\", \"b\", \"c\" or \"d\").");
            } else {
                System.out.println("(Multiple correct answer -> write any combination of options: " +
                        "example fo all correct options is \"abcd\").");
            }
            for (Answer answer : this.getAnswers()) {
                System.out.println(answer.getAnswerText());
            }
        } else {
            System.out.println("(Write your answer. Check your grammar otherwise your answer may be wrong!!!).");
        }
    }

    public String getCorrectAnswer() {
        String target = "";
        if (this.TYPE.equals("one")) {
            for (Answer answer : this.ANSWERS) {
                if (answer.isCorrect()) {
                    target = answer.getAnswerText().substring(0, 1);
                    break;
                }
            }
        } else if (this.TYPE.equals("more")) {
            for (Answer answer : this.ANSWERS) {
                if (answer.isCorrect()) {
                    target = target.concat(answer.getAnswerText().substring(0, 1));
                }
            }
        } else {
            target = this.ANSWERS.get(0).getAnswerText();
        }
        return target;
    }

    public String getQuestionText() {
        return QUESTION_TEXT;
    }

    public String getType() {
        return TYPE;
    }

    public ArrayList<Answer> getAnswers() {
        return ANSWERS;
    }
}


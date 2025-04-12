import java.util.ArrayList;

public class Question {

    private final String questionText;
    private final ArrayList<Answer> answers;
    private final String type;

    public Question(String questionText, String type, ArrayList<Answer> answers) {
        this.questionText = questionText;
        this.type = type;
        this.answers = answers;
    }

    public void showQuestion() {
        System.out.println(this.getQuestionText());
        if (!this.getType().equals("write")) {
            if (this.getType().equals("one")) {
                System.out.println("(Single correct answer -> write one option: \"a\", \"b\", \"c\" or \"d\")");
            } else {
                System.out.println("(Multiple correct answer -> write any combination of options: " +
                        "example fo all correct options is \"abcd\")");
            }
            for (Answer answer : this.getAnswers()) {
                System.out.println(answer.getAnswerText());
            }
        } else {
            System.out.println("(Write you answer)");
        }
    }

    public String getCorrectAnswer() {
        String target = "";
        if (this.type.equals("one")) {
            for (Answer answer : this.answers) {
                if (answer.isCorrect()) {
                    target = answer.getAnswerText().substring(0, 1);
                    break;
                }
            }
        } else if (this.type.equals("more")) {
            for (Answer answer : this.answers) {
                if (answer.isCorrect()) {
                    target = target.concat(answer.getAnswerText().substring(0, 1));
                }
            }
        } else {
            target = this.answers.get(0).getAnswerText();
        }
        return target;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
}


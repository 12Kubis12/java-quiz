import java.util.ArrayList;
import java.util.Arrays;

public class Question {

    private final String questionText;
    private final ArrayList<Answer> answers;
    private final String type;

    public Question(String questionText, String type) {
        this.questionText = questionText;
        this.type = type;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public void removeAnswer(int index) {
        this.answers.remove(index);
    }

    public void printQuestion() {
        System.out.println(this.questionText);
        if (!this.type.equals("write")) {
            if (this.type.equals("one")) {
                System.out.println("(Single correct answer -> write one option: \"a\", \"b\", \"c\" or \"d\").");
            } else {
                System.out.println("(Multiple correct answer -> write any combination of options: " +
                        "example fo all correct options is \"abcd\").");
            }
            for (Answer answer : this.answers) {
                System.out.println(answer.getAnswerText());
            }
        } else {
            System.out.println("(Write your answer. Check your grammar otherwise your answer may be wrong!!!).");
        }
    }

    public void checkAnswer(String answer, Player player) {
        String correctAnswer = this.getCorrectAnswer();
        if (answer.equals(correctAnswer) ||
                (this.type.equals("more") && this.checkAnagram(correctAnswer, answer))) {
            System.out.println("Correct!!!");
            player.setCorrectAnswers(player.getCorrectAnswers() + 1);
        } else {
            System.out.println("Wrong!!!");
        }
        player.setAnsweredQuestions(player.getAnsweredQuestions() + 1);
        System.out.println();
    }

    private String getCorrectAnswer() {
        String target = "";
        if (this.type.equals("one")) {
            for (Answer answer : this.answers) {
                if (answer.getCorrect()) {
                    target = answer.getAnswerText().substring(0, 1);
                    break;
                }
            }
        } else if (this.type.equals("more")) {
            for (Answer answer : this.answers) {
                if (answer.getCorrect()) {
                    target = target.concat(answer.getAnswerText().substring(0, 1));
                }
            }
        } else {
            target = this.answers.get(0).getAnswerText();
        }
        return target;
    }

    private boolean checkAnagram(String a, String b) {
        char[] lettersA = a.toCharArray();
        char[] lettersB = b.toCharArray();

        Arrays.sort(lettersA);
        Arrays.sort(lettersB);

        return Arrays.equals(lettersA, lettersB);
    }

    public String getType() {
        return this.type;
    }

    public ArrayList<Answer> getAnswers() {
        return this.answers;
    }
}


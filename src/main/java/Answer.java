public class Answer {
    private final String answerText;
    private final boolean correct;

    Answer(String answerText, boolean correct) {
        this.answerText = answerText;
        this.correct = correct;
    }

    public String getAnswerText() {
        return this.answerText;
    }

    public boolean getCorrect() {
        return this.correct;
    }
}

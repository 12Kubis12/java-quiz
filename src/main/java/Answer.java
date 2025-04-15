public class Answer {
    private final String ANSWER_TEXT;
    private final boolean CORRECT;

    Answer(String answerText, boolean correct) {
        this.ANSWER_TEXT = answerText;
        this.CORRECT = correct;
    }

    public String getAnswerText() {
        return ANSWER_TEXT;
    }

    public boolean isCorrect() {
        return CORRECT;
    }
}

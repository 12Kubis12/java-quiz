import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Quiz> quizzes = createQuizzes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Player player = new Player();

            System.out.println("Choose quiz from these options: ");
            for (int i = 0; i < quizzes.size(); i++) {
                System.out.println("\"" + quizzes.get(i).getName() + "\"" + " -> " + (i + 1));
            }

            String index = scanner.nextLine();
            if (index.equals("q")){
                System.out.println("Application Quiz is closed. :(");
                break;
            }

            Quiz quiz = quizzes.get(Integer.parseInt(index) - 1);
            System.out.println("You chose a quiz about " + quiz.getName() + ". Good luck!!!");
            System.out.println();

            for (Question question: quiz.getQuestions()) {
                question.showQuestion();
                String playerAnswer = scanner.nextLine();
                player.checkAnswer(playerAnswer, question);
            }

            player.printStats(quiz);
        }
    }

    public static ArrayList<Quiz> createQuizzes() {
        return new ArrayList<>() {{
            add(new Quiz("Math", new ArrayList<>() {{
                add(new Question("01. What is the smallest prime number?", "one", new ArrayList<>() {{
                    add(new Answer("a) 0", false));
                    add(new Answer("b) 1", false));
                    add(new Answer("c) 2", true));
                    add(new Answer("d) 3", false));
                }}));
                add(new Question("02. Which are the solutions of a quadratic equation: x^2 + 2*x − 3 = 0?",
                        "more", new ArrayList<>() {{
                    add(new Answer("a) 1", true));
                    add(new Answer("b) 2", false));
                    add(new Answer("c) -3", true));
                    add(new Answer("d) 3", false));
                }}));
                add(new Question("03. For which geometric shape can we use the Pythagorean theorem?",
                        "write", new ArrayList<>() {{
                    add(new Answer("triangle", true));
                }}));
            }}));
            add(new Quiz("Geography of Europe", new ArrayList<>() {{
                add(new Question("01. Who owns the Canary Islands?", "one", new ArrayList<>() {{
                    add(new Answer("a) Western Sahara", false));
                    add(new Answer("b) Portugal", false));
                    add(new Answer("c) Morocco", false));
                    add(new Answer("d) Spain", true));
                }}));
                add(new Question("02. Which countries belong to Nordic countries?", "more",
                        new ArrayList<>() {{
                            add(new Answer("a) Norway", true));
                            add(new Answer("b) Estonia", false));
                            add(new Answer("c) Finland", true));
                            add(new Answer("d) Sweden", true));
                        }}));
                add(new Question("03. Which are the highest mountains in Europe?", "write",
                        new ArrayList<>() {{
                            add(new Answer("Alps", true));
                        }}));
            }}));
            add(new Quiz("Physics", new ArrayList<>() {{
                add(new Question("01. Which of the following is not a scalar quantity?", "one",
                        new ArrayList<>() {{
                            add(new Answer("a) Force", true));
                            add(new Answer("b) Mass", false));
                            add(new Answer("c) Energy", false));
                            add(new Answer("d) Volume", false));
                        }}));
                add(new Question("02. What formulas can we use to calculate acceleration(including angular)?",
                        "one",
                        new ArrayList<>() {{
                            add(new Answer("a) a = F 'total force acting on the object'" +
                                    " / m 'mass of the object'", true));
                            add(new Answer("b) a = Δv 'change in velocity' / Δt 'acceleration time'",
                                    true));
                            add(new Answer("c) α = (ω2 'final angular velocity' - " +
                                    "ω1 'initial angular velocity') / Δt 'acceleration time'", true));
                            add(new Answer("d) a = (vf 'final velocity' - vi 'initial velocity') " +
                                    "/ (tf 'final time' - ti 'initial time')", true));
                        }}));
                add(new Question("03. What is the base unit of length(according the SI)?", "one",
                        new ArrayList<>() {{
                            add(new Answer("meter", true));
                        }}));
            }}));
        }};
    }
}

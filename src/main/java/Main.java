import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Quiz> quizzes = createQuizzes();
        Scanner scanner = new Scanner(System.in);
//        Start the quiz.
        while (true) {
            Player player = new Player();
            Quiz quiz = null;
            String start;

            System.out.println("You can stop the application at any time by typing \"q\"." +
                    "\nChoose quiz from these options: ");
            for (int i = 0; i < quizzes.size(); i++) {
                System.out.println("\"" + quizzes.get(i).getName() + "\"" + " -> " + (i + 1));
            }
//            Check input for quiz selection.
            while (true) {
                try {
                    start = scanner.nextLine().replaceAll("\\s", "");
                    if (start.equals("q")) {
                        break;
                    }
                    quiz = quizzes.get(Integer.parseInt(start) - 1);
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Try again!!!");
                }
            }
//            Stop application if "q" is tipped.
            if (start.equals("q")) {
                System.out.println("Application Quiz is closed. :(");
                break;
            }

            System.out.println("You chose a quiz about " + quiz.getName() + ". Good luck!!!");
            System.out.println();
//            Printing questions.
            for (Question question : quiz.getQuestions()) {
                question.showQuestion();
                String questionType = question.getType();
                String testString = "abcd".substring(0, question.getAnswers().size());
                String playerAnswer;
//                Check input for answer selections.
                if (!questionType.equals("write")) {
                    while (true) {
                        try {
                            playerAnswer = scanner.nextLine().replaceAll("\\s", "").toLowerCase();
                            if (playerAnswer.equals("q")) {
                                break;
                            } else if (!checkInput(testString, playerAnswer) || playerAnswer.isEmpty() ||
                                    (questionType.equals("one") && playerAnswer.length() > 1)) {
                                throw new Exception("Invalid input. Try again!!!");
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } else {
                    playerAnswer = scanner.nextLine().replaceAll("\\s", "").toLowerCase();
                }
//                Stop application if "q" is tipped.
                if (playerAnswer.equals("q")) {
                    start = "q";
                    break;
                }

                player.checkAnswer(playerAnswer, question);
            }
//            Stop application if "q" is tipped.
            if (start.equals("q")) {
                System.out.println("Application Quiz is closed. :(");
                break;
            }

            player.printStats(quiz);
        }
    }

    public static boolean checkInput(String a, String b) {
        ArrayList<String> lettersA = new ArrayList<>(Arrays.asList(a.split("")));
        ArrayList<String> lettersB = new ArrayList<>(Arrays.asList(b.split("")));

        for (String s : lettersB) {
            if (!lettersA.contains(s)) {
                return false;
            }
            lettersA.remove(s);
        }
        return true;
    }
//    Create quizzes.
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
                            add(new Answer("alps", true));
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
                        "more",
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
                add(new Question("03. What is the base unit of length(according the SI)?", "write",
                        new ArrayList<>() {{
                            add(new Answer("meter", true));
                        }}));
            }}));
        }};
    }
}

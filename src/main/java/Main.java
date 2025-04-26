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
            printStartInfo(quizzes);
//            Check input for the quiz selection.
            String chosenQuiz = scanInputChooseQuiz(scanner, quizzes);
//            Quit the application if "q" is tipped. (-1 is returned from the function before)
            if (chosenQuiz.equals("q")) {
                printQuitInfo();
                break;
            }
            Quiz quiz = quizzes.get(Integer.parseInt(chosenQuiz) - 1);
            quiz.printInfo();
//            Printing questions.
            for (Question question : quiz.getQuestions()) {
                question.printQuestion();
//                Check input for answer selections.
                String playerAnswer = scanInputChooseAnswer(scanner, question);
//                Quit the quiz if "q" is tipped.
                if (playerAnswer.equals("q")) {
                    break;
                }
                question.checkAnswer(playerAnswer, player);
            }
            if (player.getAnsweredQuestion() == quiz.getQuestions().size()) {
                quiz.printStats(player);
            }
//            Choose to continue o to quit.
            String continuation = scanInputChooseContinuation(scanner);
//            Quit the application if "q" is tipped.
            if (continuation.equals("q")) {
                printQuitInfo();
                break;
            }
        }
    }

    public static void printStartInfo(ArrayList<Quiz> quizzes) {
        System.out.println("-".repeat(100));
        System.out.println("You can quit the application or the quiz at any time by typing \"q\"." +
                "\nChoose quiz from these options: ");
        for (int i = 0; i < quizzes.size(); i++) {
            System.out.println("\"" + quizzes.get(i).getName() + "\"" + " -> " + (i + 1));
        }
    }

    public static String scanInputChooseQuiz(Scanner scanner, ArrayList<Quiz> quizzes) {
        String chosenQuiz;
        while (true) {
            try {
                chosenQuiz = scanner.nextLine().replaceAll("\\s", "").toLowerCase();
                if (chosenQuiz.equals("q")) {
                    break;
                }
                int index = Integer.parseInt(chosenQuiz) - 1;
                if (index > (quizzes.size() - 1) || index < 0) {
                    throw new IndexOutOfBoundsException("Invalid input!!! Write the number corresponding to the quiz " +
                            "or \"q\" to quit the application.");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return chosenQuiz;
    }

    public static String scanInputChooseAnswer(Scanner scanner, Question question) {
        String questionType = question.getType();
        String playerAnswer;
        if (!questionType.equals("write")) {
            String testString = "abcdefghijklmnopqrstuvwxyz".substring(0, question.getAnswers().size());
            while (true) {
                try {
                    playerAnswer = scanner.nextLine().replaceAll("\\s", "").toLowerCase();
                    if (playerAnswer.equals("q")) {
                        break;
                    } else if (!checkInput(testString, playerAnswer) || playerAnswer.isEmpty() ||
                            (questionType.equals("one") && playerAnswer.length() > 1)) {
                        throw new IllegalArgumentException("Invalid input!!! Write the letter/letters corresponding " +
                                "to the option/options or \"q\" to quit the quiz (check the question type).");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            playerAnswer = scanner.nextLine().replaceAll("\\s", "").toLowerCase();
        }
        return playerAnswer;
    }

    public static String scanInputChooseContinuation(Scanner scanner) {
        String continuation;
        System.out.println("You can choose a quiz again (\"c\") or quit the application (\"q\").");
        while (true) {
            try {
                continuation = scanner.nextLine().replaceAll("\\s", "").toLowerCase();
                if (continuation.equals("q") || continuation.equals("c")) {
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid input!!! Write \"c\" (continue) or \"q\" (quit).");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return continuation;
    }

    public static boolean checkInput(String testString, String playerAnswer) {
        ArrayList<String> lettersA = new ArrayList<>(Arrays.asList(testString.split("")));
        ArrayList<String> lettersB = new ArrayList<>(Arrays.asList(playerAnswer.split("")));

        for (String s : lettersB) {
            if (!lettersA.contains(s)) {
                return false;
            }
            lettersA.remove(s);
        }
        return true;
    }

    public static void printQuitInfo() {
        System.out.println("The application Quiz is closed. :(");
    }

    public static ArrayList<Quiz> createQuizzes() {
//        Create quizzes
        Quiz mathQuiz = new Quiz("Math");
        Quiz geographyOfEuropeQuiz = new Quiz("Geography of Europe");
        Quiz physicsQuiz = new Quiz("Physics");

//        Create questions and answers
        Question firstMathQuestion = new Question("01. What is the smallest prime number?", "one");

        firstMathQuestion.addAnswer(new Answer("a) 0", false));
        firstMathQuestion.addAnswer(new Answer("b) 1", false));
        firstMathQuestion.addAnswer(new Answer("c) 2", true));
        firstMathQuestion.addAnswer(new Answer("d) 3", false));

        Question secondMathQuestion = new Question("02. Which are the solutions of a quadratic equation: " +
                "x^2 + 2*x − 3 = 0?", "more");

        secondMathQuestion.addAnswer(new Answer("a) 1", true));
        secondMathQuestion.addAnswer(new Answer("b) 2", false));
        secondMathQuestion.addAnswer(new Answer("c) -3", true));
        secondMathQuestion.addAnswer(new Answer("d) 3", false));

        Question thirdMathQuestion = new Question("03. For which geometric shape can we use the Pythagorean" +
                " theorem?", "write");

        thirdMathQuestion.addAnswer(new Answer("triangle", true));

        mathQuiz.addQuestion(firstMathQuestion);
        mathQuiz.addQuestion(secondMathQuestion);
        mathQuiz.addQuestion(thirdMathQuestion);

        Question firstGeographyOfEuropeQuestion = new Question("01. Who owns the Canary Islands?", "one");

        firstGeographyOfEuropeQuestion.addAnswer(new Answer("a) Western Sahara", false));
        firstGeographyOfEuropeQuestion.addAnswer(new Answer("b) Portugal", false));
        firstGeographyOfEuropeQuestion.addAnswer(new Answer("c) Morocco", false));
        firstGeographyOfEuropeQuestion.addAnswer(new Answer("d) Spain", true));

        Question secondGeographyOfEuropeQuestion = new Question("02. Which countries belong to Nordic" +
                " countries?", "more");

        secondGeographyOfEuropeQuestion.addAnswer(new Answer("a) Norway", true));
        secondGeographyOfEuropeQuestion.addAnswer(new Answer("b) Estonia", false));
        secondGeographyOfEuropeQuestion.addAnswer(new Answer("c) Finland", true));
        secondGeographyOfEuropeQuestion.addAnswer(new Answer("d) Sweden", true));

        Question thirdGeographyOfEuropeQuestion = new Question("03. Which are the highest mountains in Europe?",
                "write");

        thirdGeographyOfEuropeQuestion.addAnswer(new Answer("alps", true));

        geographyOfEuropeQuiz.addQuestion(firstGeographyOfEuropeQuestion);
        geographyOfEuropeQuiz.addQuestion(secondGeographyOfEuropeQuestion);
        geographyOfEuropeQuiz.addQuestion(thirdGeographyOfEuropeQuestion);

        Question firstPhysicsQuestion = new Question("01. Which of the following is not a scalar quantity?",
                "one");

        firstPhysicsQuestion.addAnswer(new Answer("a) Force", true));
        firstPhysicsQuestion.addAnswer(new Answer("b) Mass", false));
        firstPhysicsQuestion.addAnswer(new Answer("c) Energy", false));
        firstPhysicsQuestion.addAnswer(new Answer("d) Volume", false));

        Question secondPhysicsQuestion = new Question("02. What formulas can we use to calculate " +
                "acceleration(including angular)?", "more");

        secondPhysicsQuestion.addAnswer(new Answer("a) a = F 'total force acting on the object' " +
                "/ m 'mass of the object'", true));
        secondPhysicsQuestion.addAnswer(new Answer("b) a = Δv 'change in velocity' / Δt 'acceleration time'",
                true));
        secondPhysicsQuestion.addAnswer(new Answer("c) α = (ω2 'final angular velocity' - " +
                "ω1 'initial angular velocity') / Δt 'acceleration time'", true));
        secondPhysicsQuestion.addAnswer(new Answer("d) a = (vf 'final velocity' - vi 'initial velocity') " +
                "/ (tf 'final time' - ti 'initial time')", true));

        Question thirdPhysicsQuestion = new Question("03. What is the base unit of length(according the SI)?",
                "write");

        thirdPhysicsQuestion.addAnswer(new Answer("meter", true));

        physicsQuiz.addQuestion(firstPhysicsQuestion);
        physicsQuiz.addQuestion(secondPhysicsQuestion);
        physicsQuiz.addQuestion(thirdPhysicsQuestion);

        return new ArrayList<>(Arrays.asList(mathQuiz, geographyOfEuropeQuiz, physicsQuiz));
    }
}


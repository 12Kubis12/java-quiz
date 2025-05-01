import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Quiz> quizzes = createQuizzes();
        Scanner scanner = new Scanner(System.in);
// Start the quiz.
        while (true) {
            Player player = new Player();
            printStartInfo(quizzes);
// Check input for the quiz selection.
            String chosenQuiz = scanInput(scanner, quizzes, null);
// Quit the application if "q" is tipped.
            if (chosenQuiz.equals("q")) {
                printQuitInfo();
                break;
            }
            Quiz quiz = quizzes.get(Integer.parseInt(chosenQuiz) - 1);
            quiz.printInfo();
// Printing questions.
            for (Question question : quiz.getQuestions()) {
                question.printQuestion();
// Check input for answer selections.
                String playerAnswer = scanInput(scanner, null, question);
// Quit the quiz if "q" is tipped.
                if (playerAnswer.equals("q")) {
                    break;
                }
                question.checkAnswer(playerAnswer, player);
            }
            if (player.getAnsweredQuestions() == quiz.getQuestions().size()) {
                quiz.printStats(player);
            }
// Choose to continue o to quit.
            System.out.println("You can choose a quiz again (\"c\") or quit the application (\"q\").");
            String continuation = scanInput(scanner, null, null);
// Quit the application if "q" is tipped.
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

    public static String scanInput(Scanner scanner, ArrayList<Quiz> quizzes, Question question) {
        String scannedInput;
        String message = "";

        while (true) {
            try {
                scannedInput = scanner.nextLine().replaceAll("\\s", "").toLowerCase();
// Scan continuation
                if (quizzes == null && question == null) {
                    if (scannedInput.equals("q") || scannedInput.equals("c")) {
                        break;
                    } else {
                        message = "Invalid input!!! Write \"c\" (continue) or \"q\" (quit).";
                        throw new IllegalArgumentException();
                    }
                } else {
                    if (scannedInput.equals("q")) {
                        break;
// Scan quiz
                    } else if (question == null) {
                        message = "Invalid input!!! Write the number corresponding to the quiz or \"q\" to quit " +
                                "the application.";
                        int index = Integer.parseInt(scannedInput) - 1;
                        if (index > (quizzes.size() - 1) || index < 0) {
                            throw new IndexOutOfBoundsException();
                        }
                        break;
// Scan answer
                    } else if (quizzes == null) {
                        if (!question.getType().equals("write")) {
                            String testString = "abcdefghijklmnopqrstuvwxyz".substring(0, question.getAnswers().size());
                            if (checkMultipleAnswer(testString, scannedInput) || scannedInput.isEmpty() ||
                                    (question.getType().equals("one") && scannedInput.length() > 1)) {
                                message = "Invalid input!!! Write the letter/letters corresponding to the" +
                                        " option/options or \"q\" to quit the quiz (check the question type).";
                                throw new IllegalArgumentException();
                            }
                        }
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(message);
            }
        }
        return scannedInput;
    }

    public static boolean checkMultipleAnswer(String testString, String playerAnswer) {
        ArrayList<String> lettersA = new ArrayList<>(Arrays.asList(testString.split("")));
        ArrayList<String> lettersB = new ArrayList<>(Arrays.asList(playerAnswer.split("")));

        for (String s : lettersB) {
            if (!lettersA.contains(s)) {
                return true;
            }
            lettersA.remove(s);
        }
        return false;
    }

    public static void printQuitInfo() {
        System.out.println("The application Quiz is closed. :(");
    }

    public static ArrayList<Quiz> createQuizzes() {
// Create quizzes
        Quiz mathQuiz = new Quiz("Math");
        Quiz geographyOfEuropeQuiz = new Quiz("Geography of Europe");
        Quiz physicsQuiz = new Quiz("Physics");

// Create questions and answers
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


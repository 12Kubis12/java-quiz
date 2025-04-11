import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, ArrayList<String>>> quizTypes = new HashMap<>() {{
            put("Math", new HashMap<>() {{
                put("What is the smallest prime number?", new ArrayList<>() {{
                    add("0");
                    add("1");
                    add("2");
                    add("3");
                }});
                put("", new ArrayList<>() {{
                    add("");
                    add("");
                    add("");
                    add("");
                }});
                put("", new ArrayList<>() {{
                    add("");
                    add("");
                    add("");
                    add("");
                }});
            }});
            put("", new HashMap<>() {{
                put("", new ArrayList<>() {{
                    add("");
                    add("");
                    add("");
                    add("");
                }});
                put("", new ArrayList<>() {{
                    add("");
                    add("");
                    add("");
                    add("");
                }});
                put("", new ArrayList<>() {{
                    add("");
                    add("");
                    add("");
                    add("");
                }});
            }});
            put("", new HashMap<>() {{
                put("", new ArrayList<>() {{
                    add("");
                    add("");
                    add("");
                    add("");
                }});
                put("", new ArrayList<>() {{
                    add("");
                    add("");
                    add("");
                    add("");
                }});
                put("", new ArrayList<>() {{
                    add("");
                    add("");
                    add("");
                    add("");
                }});
            }});
        }};

        System.out.println(quizTypes);

//        Question question01 = new Question("What is the smallest prime number?", )
//        Answer answer1 = new Answer("What is the smallest prime number?", )
    }
}

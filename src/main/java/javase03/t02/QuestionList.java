package javase03.t02;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class QuestionList {
    private Locale locale;
    private ResourceBundle questions;
    private boolean localeSet = false;

    private void detectLocale(String currentLocale) {
        if (currentLocale != null) {
            if (currentLocale.equals("ru")) {
                locale = new Locale("ru", "RU");
            } else if (currentLocale.equals("en")) {
                locale = new Locale("en", "US");
            } else {
                locale = Locale.getDefault();
            }
        } else {
            locale = Locale.getDefault();
        }
        localeSet = true;
    }

    private void loadQuestions() {
        questions = ResourceBundle.getBundle("javase03.t02.questions", locale);
    }


    private String getQuestion(int number) {
        String key = "question" + number;
        return questions.getString(key);
    }

    private String getAnswer(int number) {
        String key = "answer" + number;
            return questions.getString(key);
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        String command;
        do {
            System.out.println("Enter command: set locale, get question or exit");
            command = in.nextLine();

            switch (command) {
                case "set locale":
                    System.out.println("Enter locale, ru or en");
                    String locale = in.nextLine();
                    detectLocale(locale);
                    loadQuestions();
                    System.out.println("ok!");
                    break;
                case "get question":
                    if (!localeSet) {
                        detectLocale("");
                        loadQuestions();
                    }
                    System.out.println("Enter the number of the question");
                    String buffer = in.nextLine();
                    try {
                        int number = Integer.parseInt(buffer.trim());
                        System.out.println(getQuestion(number));
                        System.out.println(getAnswer(number));
                    } catch (java.util.MissingResourceException t) {
                        System.out.println("Question not found");
                    } catch (NumberFormatException t) {
                        System.out.println("Invalid number");
                    }
                    break;
                case "exit":
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("command error, try more");
                    break;
            }
        } while (!command.equals("exit"));
    }
}

package com.jsoftware.api;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionFactory;
import com.jsoftware.api.interfaces.IQuestionSet;
import com.jsoftware.api.model.QuestionFactory;
import com.jsoftware.api.model.QuestionSet;
import java.util.Scanner;
import static com.jsoftware.api.model.Logger.log;

public class TestMaker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        log("Welcome to the TestMaker program!");
        log("What would you like to call this test?");
        String name = input.next();

        IQuestionSet test = new QuestionSet();
        IQuestionFactory questionFactory = new QuestionFactory();

        boolean isRunning = true;

        while (isRunning) {
            int mode;

            displayMenu();

            mode = input.nextInt();
            switch (mode) {
                case 1:
                    test.add(buildMultipleChoiceQuestion(input, questionFactory));
                    break;
                case 2:
                    test.add(buildTrueFalseQuestion(input, questionFactory));
                    break;
                case 3:
                    test.add(buildFillInTheBlankQuestion(input, questionFactory));
                    break;
                case 4:
                    test.add(buildShortAnswerQuestion(input, questionFactory));
                    break;
                case 5:
                    removeQuestion(input, test);
                    break;
                case 6:
                    exit(questionFactory, test, name);
                    isRunning = false;
                    break;
                default:
                    log("\nInvalid input\n" +
                            "Please enter one of the following\n");
                    break;
            }
        }
    }

    private static void exit(IQuestionFactory questionFactory, IQuestionSet test, String filename) {
        questionFactory.save(test, filename);
        log("Goodbye!");
    }

    private static void displayMenu() {
        log("What would you like to do?");
        log("\t1) add a multiple-choice question");
        log("\t2) add a true/false question");
        log("\t3) add a fill-in-the-blank question");
        log("\t4) add short answer question");
        log("\t5) remove a question");
        log("\t6) exit program");
        log("Your choice: ", true);
    }

    public static IQuestion buildMultipleChoiceQuestion(Scanner input, IQuestionFactory questionFactory) {
        log("What is your multiple-choice question?");
        String questionText = input.next() + input.nextLine();
        log("");

        String[] ordinals = { "first", "second", "third", "fourth and last" };
        String[] possibleAnswers = new String[4];

        for (int i = 0; i < 4; i++) {
            log("Please enter your " + ordinals[i] + " choice: ", true);
            possibleAnswers[i] = input.next();
        }
        log("What choice was the answer? (Enter #1-4): ");

        int i = input.nextInt();
        int correctAnswer = i - 1;

        return questionFactory.makeMultipleChoice(questionText, possibleAnswers, correctAnswer);
    }

    public static IQuestion buildTrueFalseQuestion(Scanner input, IQuestionFactory questionFactory) {
        log("What is your True/False question?");
        String questionText = input.next() + input.nextLine();

        log("What is the answer? (Please enter exactly true or false)");
        boolean answer = input.nextBoolean();

        return questionFactory.makeTrueFalse(questionText, answer);
    }

    public static IQuestion buildFillInTheBlankQuestion(Scanner input, IQuestionFactory questionFactory) {
        log("What is your fill in the blank question?");
        String questionText = input.next() + input.nextLine();

        log("What is the answer? Please separate answers with a comma.");
        String answerList = input.next();

        String[] keywords = answerList.split(",");

        return questionFactory.makeFillInBlank(questionText, keywords);
    }

    public static IQuestion buildShortAnswerQuestion(Scanner input, IQuestionFactory questionFactory) {
        log("What is your short answer question?");
        String questionText = input.next() + input.nextLine();

        log("How many keywords does your short answer question have? ");

        int key = Integer.parseInt(input.nextLine());

        String keywords[] = new String[key];

        for (int i = 0; i < keywords.length; i++) {
            log("What is a keyword in your short answer question?", true);
            keywords[i] = input.nextLine();
        }

        return questionFactory.makeShortAnswer(questionText, keywords);
    }

    public static void removeQuestion(Scanner input, IQuestionSet test) {
        log("Select the index of the question you would like to remove.");
        test.print();
        int i = input.nextInt();
        test.remove(i);
    }
}

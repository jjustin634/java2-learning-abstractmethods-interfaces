package com.jsoftware.api;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionFactory;
import com.jsoftware.api.interfaces.IQuestionSet;
import com.jsoftware.api.model.QuestionFactory;
import com.jsoftware.api.model.QuestionSet;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMaker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        log("Welcome to the TestMaker program!");
        log("What would you like to call this test?");
        String testName = input.next();

        boolean isRunning = true;
        while(isRunning) {
            int mode;

            displayMenu();

            IQuestionFactory questionFactory = new QuestionFactory(testName);
            IQuestionSet test = new QuestionSet();

            mode = input.nextInt();
            switch (mode) {
                case 1:
                    IQuestion newQuestion = buildMultipleChoiceQuestion(input, questionFactory);
                    test.add(newQuestion);
                    break;
                case 2:
                    IQuestion trueOfFalse = buildTrueFalseQuestion(input, questionFactory);
                    test.add(trueOfFalse);
                    break;
                case 3:
                    IQuestion fillInTheBlanks= buildFillInTheBlankQuestion(input, questionFactory);
                    test.add(fillInTheBlanks);
                    break;
                case 4:
                    IQuestion shortAnswer = buildShortAnswerQuestion(input, questionFactory);
                    test.add(shortAnswer);
                    break;
                case 5:
                    // Remove a question from the test
                    break;
                case 6:
                    displayExit();
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }

    private static void displayExit() {
        log("\nTest saved.\n" +
                "Goodbye!");
    }

    private static void displayMenu() {
        log("What would you like to do?");
        log("\t 1) add a multiple-choice question");
        log("\t 2) add a true/false question");
        log("\t 3) add a fill-in-the-blank question");
        log("\t 4) add short answer question");
        log("\t 5) remove a question");
        log("\t 6) exit program");
        logger("Your choice: ");
    }

    public static IQuestion buildMultipleChoiceQuestion(Scanner input, IQuestionFactory questionFactory) {
        ArrayList<String> questions = new ArrayList<>();
        log("What is your multiple-choice question?");
        String question = input.next() + input.nextLine();
        log("");

        String[] ordinals = { "first", "second", "third", "fourth and last" };
        String[] answers = new String[4];
        for (int i = 0; i < 4; i++) {
            logger("Please enter your " + ordinals[i] + " choice: ");
            answers[i] = input.next();
        }
        log("What choice was the answer? (Enter #1-4): ");
        int i = input.nextInt();
        int theAnswer = i - 1;

        String[] arr = new String[questions.size()];
        arr = questions.toArray(arr);

        return questionFactory.makeMultipleChoice(question, arr, theAnswer);
    }

    public static IQuestion buildTrueFalseQuestion(Scanner input, IQuestionFactory questionFactory) {

        log("What is your True/False question?");
        String question = input.next() + input.nextLine();

        log("What is the answer? (Please enter exactly true or false)");
        boolean theAnswer = input.nextBoolean();

        return questionFactory.makeTrueFalse(question, theAnswer);
    }

    public static IQuestion buildFillInTheBlankQuestion(Scanner input, IQuestionFactory questionFactory) {

        log("What is your fill in the blank question?");
        String question = input.next() + input.nextLine();

        log("What is the answer? Please separate answers with a comma.");
        String fillInBlankAnswers = input.next();
        String[] answers = fillInBlankAnswers.split(",");

        return questionFactory.makeFillInBlank(question, answers);
    }

   public static IQuestion buildShortAnswerQuestion(Scanner input, IQuestionFactory questionFactory) {

        log("What is your short answer question?");
        String question = input.next() + input.nextLine();

        log("How many keywords does your short answer question have?");
        int keywords = Integer.parseInt(input.nextLine());

        String arrayOfKeywords[] = new String[keywords];
        for (int i = 0; i < arrayOfKeywords.length; i++) {
            logger("What is a keyword in your short answer question?" + " : ");
            arrayOfKeywords[i] = input.nextLine();
        }
        return questionFactory.makeShortAnswer(question, arrayOfKeywords);
    }

    public static void log(String m) {
        System.out.println(m);
    }

    public static void logger(String m) {
        System.out.print(m);
    }
}

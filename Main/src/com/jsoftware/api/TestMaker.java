package com.jsoftware.api;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionFactory;
import com.jsoftware.api.interfaces.IQuestionSet;
import com.jsoftware.api.model.QuestionFactory;
import com.jsoftware.api.model.QuestionSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMaker {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        log("Welcome to the TestMaker program!");
        log("What would you like to call this test?");
        String testName = input.next();

        boolean isRunning = true;
        while (isRunning) {
            int mode;

            displayMenu();

            IQuestionFactory questionFactory = new QuestionFactory();
            IQuestionSet test = new QuestionSet();

            mode = input.nextInt();
            switch (mode) {
                case 1:
                    IQuestion newQuestion = buildMultipleChoiceQuestion(questionFactory);
                    test.add(newQuestion);
                    break;
                case 2:
                    IQuestion trueOfFalse = buildTrueFalseQuestion(input, questionFactory);
                    test.add(trueOfFalse);
                    break;
                case 3:
                    IQuestion fillInTheBlanks = buildFillInTheBlankQuestion(input, questionFactory);
                    test.add(fillInTheBlanks);
                    break;
                case 4:
                    IQuestion shortAnswer = buildShortAnswerQuestion(input, questionFactory);
                    test.add(shortAnswer);
                    break;
                case 5:
                    removeQuestion(input, questionFactory, testName);
                    break;
                case 6:
                    displayExit(questionFactory, test, testName);
                    isRunning = false;
                    break;
                default:
                    log("\nInvalid input\n" +
                            "Please enter one of the following\n");
                    break;
            }
        }
    }

    private static void displayExit(IQuestionFactory questionFactory, IQuestionSet test, String filename) {
        log("\nTest saved.\n" +
                "Goodbye!");
        questionFactory.save(test, filename);
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

    public static IQuestion buildMultipleChoiceQuestion(IQuestionFactory questionFactory) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> questions = new ArrayList<>();
        log("What is your multiple-choice question?");
        String questionFromUser = input.next() + input.nextLine();
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
        return questionFactory.makeMultipleChoice(questionFromUser, arr, theAnswer);
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
        int key = Integer.parseInt(input.nextLine());

        String arrayOfKeywords[] = new String[key];
        for (int i = 0; i < arrayOfKeywords.length; i++) {
            logger("What is a keyword in your short answer question?" + " : ");
            arrayOfKeywords[i] = input.nextLine();
        }
        return questionFactory.makeShortAnswer(question, arrayOfKeywords);
    }

    public static IQuestion removeQuestion(Scanner input, IQuestionFactory questionFactory, String filename) throws IOException {

        printQuestions(filename, questionFactory);

        log("Select the index of the question you would like to remove.");
        int removedIndex = input.nextInt();

        IQuestionSet questionSet = questionFactory.load(filename);
        questionSet.getQuestion(removedIndex);

        return null;
    }

    public static IQuestionSet printQuestions(String filename, IQuestionFactory questionFactory) throws IOException {
        questionFactory.load(filename);

        // add the questions
    }

    public static void log(String m) {
        System.out.println(m);
    }

    public static void logger(String m) {
        System.out.print(m);
    }

}

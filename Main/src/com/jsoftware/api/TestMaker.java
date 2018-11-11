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

        System.out.println("Welcome to the TestMaker program!");
        System.out.println("What would you like to call this test?");
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
                    // remove a question
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
        System.out.println("\nTest saved.\n" +
                "Goodbye!");
    }

    private static void displayMenu() {
        System.out.println("What would you like to do?");
        System.out.println("\t 1) add a multiple-choice question");
        System.out.println("\t 2) add a true/false question");
        System.out.println("\t 3) add a fill-in-the-blank question");
        System.out.println("\t 4) add short answer question");
        System.out.println("\t 5) remove a question");
        System.out.println("\t 6) exit program");
        System.out.print("Your choice: ");
    }

    public static IQuestion buildMultipleChoiceQuestion(Scanner input, IQuestionFactory questionFactory) {
        ArrayList<String> questions = new ArrayList<>();
        System.out.println("What is your multiple-choice question?");
        String question = input.next() + input.nextLine();
        System.out.println();

        String[] ordinals = { "first", "second", "third", "fourth and last" };
        String[] answers = new String[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Please enter your " + ordinals[i] + " choice: ");
            answers[i] = input.next();
        }
        System.out.println("What choice was the answer? (Enter #1-4): ");
        int i = input.nextInt();
        int theAnswer = i - 1;

        String[] arr = new String[questions.size()];
        arr = questions.toArray(arr);

        return questionFactory.makeMultipleChoice(question, arr, theAnswer);
    }

    public static IQuestion buildTrueFalseQuestion(Scanner input, IQuestionFactory questionFactory) {

        System.out.println("What is your True/False question?");
        String question = input.next() + input.nextLine();

        System.out.println("What is the answer? (Please enter exactly true or false)");
        boolean theAnswer = input.nextBoolean();

        return questionFactory.makeTrueFalse(question, theAnswer);
    }

    public static IQuestion buildFillInTheBlankQuestion(Scanner input, IQuestionFactory questionFactory) {

        System.out.println("What is your fill in the blank question?");
        String question = input.next() + input.nextLine();

        System.out.println("What is the answer? Please separate answers with a comma.");
        String fillInBlankAnswers = input.next();
        String[] answers = fillInBlankAnswers.split(",");

        return questionFactory.makeFillInBlank(question, answers);
    }

   public static IQuestion buildShortAnswerQuestion(Scanner input, IQuestionFactory questionFactory) {

        System.out.println("What is your short answer question?");
        String question = input.next() + input.nextLine();

        System.out.println("How many keywords does your short answer question have?");
        String[] keywords = new String[10];

        return questionFactory.makeShortAnswer(question, keywords);
    }
}

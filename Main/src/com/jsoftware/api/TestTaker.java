package com.jsoftware.api;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionFactory;
import com.jsoftware.api.interfaces.IQuestionSet;
import com.jsoftware.api.model.*;
import java.io.IOException;
import java.util.Scanner;
import static com.jsoftware.api.model.Logger.log;

public class TestTaker {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        log("Welcome to the TestTaker program!");
        log("What test would you like to take? ");
        String name = input.next();

        IQuestionFactory questionFactory = new QuestionFactory();
        IQuestionSet test = questionFactory.load(name);

        log("Enter 1 to take a whole test or 2 to take a sample test.");
        log("Your choice: ", true);
        int testType = input.nextInt();

        if (testType == 1) {
            wholeTest(test);
        } else if (testType == 2) {
            sampleTest(test);
        } else {
            log("invalid response - please enter either 1 for whole Test or 2 for sample test");
        }
    }

    public static void wholeTest(IQuestionSet test) {
        Scanner input = new Scanner(System.in);

        int total = test.size();
        int score = 0;
        log("----------------------------\n" +
                "The test starts now!\n" +
                "----------------------------");

        IQuestion currentQuestion;
        int n;
        boolean isCorrect = false;
        QuestionType questionType;

        for (int i = 0; i < total; i++) {
            n = i + 1;
            currentQuestion = test.getQuestion(i);
            log("Question " + n + " of " + total);
            log("----------------------------");
            currentQuestion.print();
            log("Your answer: ", true);

            questionType = getQuestionType(currentQuestion);

            if (questionType == QuestionType.MULTIPLE_CHOICE) {
                int answer = input.nextInt();
                int index = answer - 1;
                isCorrect = ((MultipleChoiceQuestion)currentQuestion).checkAnswer(index);
            } else if (questionType == QuestionType.TRUE_FALSE) {
                boolean answer = input.nextBoolean();
                isCorrect = ((TrueFalseQuestion)currentQuestion).checkAnswer(answer);
            } else if (questionType == QuestionType.FILL_IN_BLANKS) {
                String in = input.nextLine();
                String[] answers = in.split(",");
                isCorrect = ((FillInBlanksQuestion)currentQuestion).checkAnswer(answers);
            } else if (questionType == QuestionType.SHORT_ANSWER) {
                String in = input.nextLine();
                String[] answers = in.split(" ");
                isCorrect = true;
                for (String answer : answers) {
                    if(!((ShortAnswerQuestion)currentQuestion).checkAnswer(answer)) {
                        isCorrect = false;
                        break;
                    }
                }
            }

            if (isCorrect) {
                log("You got it!");
                log("");
                score++;
            } else {
                log("Wrong!");
                log("");
            }
        }

        log("");
        log("You got " + score + " questions right out of " + total + " questions total.");
    }

    public static void sampleTest(IQuestionSet test) {

        final int NUMBER_OF_SAMPLE_QUESTIONS = 2;
        IQuestionSet sample = test.randomSample(NUMBER_OF_SAMPLE_QUESTIONS);
        wholeTest(sample);
    }

    public static QuestionType getQuestionType(IQuestion question) {

        if (question instanceof MultipleChoiceQuestion) {
            return QuestionType.MULTIPLE_CHOICE;
        } else if (question instanceof FillInBlanksQuestion) {
            return QuestionType.FILL_IN_BLANKS;
        } else if (question instanceof ShortAnswerQuestion) {
            return QuestionType.SHORT_ANSWER;
        } else if (question instanceof TrueFalseQuestion) {
            return QuestionType.TRUE_FALSE;
        } else {
            return null;
        }
    }
}

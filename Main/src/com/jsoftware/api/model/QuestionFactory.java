package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionSet;
import com.jsoftware.api.interfaces.IQuestionFactory;
import java.io.IOException;
import java.util.Scanner;

public class QuestionFactory implements IQuestionFactory {
    private String testName;
    private IQuestion question;
    private int size;

    public QuestionFactory(String testName, IQuestion question, int size) {
        this.testName = testName;
        this.question = question;
        this.size = size;
    }

    public IQuestion makeMultipleChoice(String question, String[] choices, int answer) {
        return null;
    }

    public IQuestion makeTrueFalse(String question, boolean answer) {
        return null;
    }

    public IQuestion makeFillInBlank(String question, String [] answers) {
        return null;
    }

    public IQuestion makeShortAnswer(String question, String[] keywords) {
        Scanner input = new Scanner(System.in);
        log("What is your short answer question?");
        question = input.next() + input.nextLine();

        log("How many keywords does your short answer question have?");
        int key = Integer.parseInt(input.nextLine());

        String arrayOfKeywords[] = new String[key];
        for (int i = 0; i < arrayOfKeywords.length; i++) {
            logger("What is a keyword in your short answer question?" + " : ");
            arrayOfKeywords[i] = input.nextLine();
        }
        return IQuestion(question);
    }

    public IQuestionSet load(String filename) throws IOException {
        return new QuestionSet(question, size);
    }

    public boolean save(IQuestionSet testSet, String filename) {
        if (this.testName == filename) {
            return true;
        } else {
            return false;
        }
    }

    public IQuestionSet makeEmptyQuestionSet() {
        IQuestionSet emptySet = new QuestionSet(question, size);
        return emptySet;
    }

    public static void log(String m) {
        System.out.println(m);
    }

    public static void logger(String m) {
        System.out.print(m);
    }
}

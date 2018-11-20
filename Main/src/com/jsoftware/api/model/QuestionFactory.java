package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionSet;
import com.jsoftware.api.interfaces.IQuestionFactory;
import java.io.*;

public class QuestionFactory implements IQuestionFactory {
    public QuestionFactory() {  }

    public IQuestion makeMultipleChoice(String question, String[] choices, int answer) {
        return new MultipleChoiceQuestion(question, choices, answer);
    }

    public IQuestion makeTrueFalse(String question, boolean answer) {
        return new TrueFalseQuestion(question, answer);
    }

    public IQuestion makeFillInBlank(String question, String [] answers) {
        return new FillInBlanksQuestion(question, answers);
    }

    public IQuestion makeShortAnswer(String question, String[] keywords) {
        return new ShortAnswerQuestion(question, keywords);
    }

    public IQuestionSet load(String filename) throws IOException {
        IQuestionSet test = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            test = (QuestionSet) in.readObject();

            in.close();
            file.close();
            System.out.println("Test loaded successful!");
        } catch (Exception e) {
            System.out.println("Test could not be loaded.");
        }

        return test;
    }

    public boolean save(IQuestionSet test, String filename) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(test);

            out.close();
            file.close();

            System.out.println("Test saved.");
            return true;
        } catch (IOException e) {
            System.out.println("Test could not be saved.");
            return false;
        }
    }
}

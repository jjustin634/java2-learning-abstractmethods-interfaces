package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionSet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import static com.jsoftware.api.model.Logger.log;

public class QuestionSet implements IQuestionSet, Serializable {
    private ArrayList<IQuestion> questions;

    public QuestionSet() {
        this.questions = new ArrayList<>();
    }

    public IQuestionSet randomSample(int size) {
        if (size > questions.size()) {
            size = questions.size();
        }

        ArrayList<Integer> questionNumbers = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            questionNumbers.add(i);
        }

        Collections.shuffle(questionNumbers);

        IQuestionSet sample = new QuestionSet();
        for (int i = 0; i < size; i++) {
            sample.add(this.getQuestion(questionNumbers.get(i)));
        }
        return sample;
    }

    public boolean add(IQuestion question) {
        return this.questions.add(question);
    }

    public boolean remove(int index) {
       return this.questions.remove(index) != null;
    }

    public IQuestion getQuestion(int index) {
        return this.questions.get(index);
    }

    public int size() {
        return this.questions.size();
    }

    public void print() {
        IQuestion question;
        for (int i = 0; i < this.questions.size(); i++) {
            question = this.questions.get(i);
            log("Question " + i + ") ", true);
            question.print();
        }
    }
}

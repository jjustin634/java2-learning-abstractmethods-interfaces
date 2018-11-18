package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionSet;

import java.util.ArrayList;

public class QuestionSet implements IQuestionSet {
    private ArrayList<IQuestion> questions;

    public QuestionSet() {
        this.questions = new ArrayList<>();
    }

    public IQuestionSet emptyTestSet() {
        return new QuestionSet();
    }

    public IQuestionSet randomSample(int size) {
        return null;
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
}

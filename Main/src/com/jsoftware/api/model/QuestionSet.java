package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionSet;

public class QuestionSet implements IQuestionSet {

    private IQuestion question;

    public QuestionSet() { }

    public IQuestionSet emptyTestSet() {
        return null;
    }

    public IQuestionSet randomSample(int size) {
        return null;
    }

    public boolean add(IQuestion question) {
        // serializable
        return true;
    }

    public boolean remove(int index) {
        // serializable
        return true;
    }

    public IQuestion getQuestion(int index) {
        return getQuestion(index);
    }

    public int size() {
        return 1;
    }
}

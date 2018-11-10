package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionSet;

public class QuestionSet implements IQuestionSet{


    public QuestionSet() {

    }

    public IQuestionSet emptyTestSet() {
        return null;
    }

    public IQuestionSet randomSample(int size) {
        return null;
    }

    public boolean add(IQuestion question) {
        return true;
    }

    public boolean remove(int index) {
        return true;
    }

    public IQuestion getQuestion(int index) {
        return null;
    }

    public int size() {
        return 1;
    }
}

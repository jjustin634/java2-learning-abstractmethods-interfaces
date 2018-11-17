package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionSet;

public class QuestionSet implements IQuestionSet {
    private IQuestion question;
    private int size;

    public QuestionSet(IQuestion question, int size) {
        this.question = question;
        this.size = size;
    }

    public IQuestionSet emptyTestSet() {
        IQuestionSet newTest = new QuestionSet(question,size);
        return newTest;
    }

    public IQuestionSet randomSample(int size) {
        IQuestionSet randomTest = new QuestionSet(question, size);
        randomTest.getQuestion(size);
        return randomTest;
    }

    public boolean add(IQuestion question) {
        question.getQuestion();
        if (question == this.question) {
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int index) {
        question.getQuestion();
        if (question == this.question) {
            return true;
        } else {
            return false;
        }
    }

    public IQuestion getQuestion(int index) {
        if (question.equals(index)) {
            return question;
        } else {
            return null;
        }
    }

    public int size() {
        return this.size;
    }
}

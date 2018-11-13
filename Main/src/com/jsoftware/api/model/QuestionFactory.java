package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionSet;
import com.jsoftware.api.interfaces.IQuestionFactory;

import java.io.IOException;

public class QuestionFactory implements IQuestionFactory {
    private String questionPrefix;

    public QuestionFactory(String questionPrefix) {
        this.questionPrefix = questionPrefix;
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
        return null;
    }

    public IQuestionSet load(String filename) throws IOException {
        return null;
    }

    public boolean save(IQuestionSet testSet, String filename) {
        return true;
    }

    public IQuestionSet makeEmptyQuestionSet() {
        return null;
    }

}

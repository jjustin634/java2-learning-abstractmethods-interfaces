package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IFillInBlanksQuestion;

public abstract class FillInBlanksQuestion implements IFillInBlanksQuestion {
    private String question;
    private String[] answers;

    public FillInBlanksQuestion (String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }

    public boolean checkAnswer(String[] keywords) {
        if (answers == keywords) {
            return true;
        } else {
            return false;
        }
    }
}

package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IFillInBlanksQuestion;
import java.io.Serializable;
import java.util.Arrays;
import static com.jsoftware.api.model.Logger.log;

public class FillInBlanksQuestion implements IFillInBlanksQuestion, Serializable {
    private String question;
    private String[] answers;

    public FillInBlanksQuestion (String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }

    public boolean checkAnswer(String[] keywords) {
        return Arrays.equals(this.answers, keywords);
    }

    public String getQuestion() {
        return this.question;
    }

    public void print() {
        log(this.question);
    }
}

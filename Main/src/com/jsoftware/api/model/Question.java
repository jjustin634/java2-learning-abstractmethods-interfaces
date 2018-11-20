package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IQuestion;
import java.io.Serializable;
import static com.jsoftware.api.model.Logger.log;

public class Question implements IQuestion, Serializable {
    private String question;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }

    public void print() {
        log(this.question);
    }
}

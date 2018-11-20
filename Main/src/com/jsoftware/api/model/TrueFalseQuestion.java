package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.ITrueFalseQuestion;
import java.io.Serializable;
import static com.jsoftware.api.model.Logger.log;

public class TrueFalseQuestion implements ITrueFalseQuestion, Serializable {
    private String question;
    private boolean correctAnswer;

    public TrueFalseQuestion(String question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(boolean answer) {
        if (this.correctAnswer == answer) {
            return true;
        } else {
            return false;
        }
    }
    public String getQuestion() {
        return this.question;
    }

    public void print() {
        log(this.question + " True/False?");
    }
}

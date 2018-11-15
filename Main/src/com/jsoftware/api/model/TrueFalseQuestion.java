package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.ITrueFalseQuestion;

public abstract class TrueFalseQuestion implements ITrueFalseQuestion {
    private String question;
    private boolean correctAnswer;

    public TrueFalseQuestion(String question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(boolean answer) {
        return this.correctAnswer == answer;
    }

}

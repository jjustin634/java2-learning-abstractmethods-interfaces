package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IShortAnswerQuestion;

public abstract class ShortAnswerQuestion implements IShortAnswerQuestion {
    private String question;
    private String[] correctAnswers;
    private String checkAnswer;

    public ShortAnswerQuestion(String question, String[] correctAnswers, String checkAnswer) {
        this.question = question;
        this.correctAnswers = correctAnswers;
        this.checkAnswer = checkAnswer;
    }

    public boolean checkAnswer(String answer) {
        if (this.checkAnswer == answer) {
            return true;
        } else {
            return false;
        }
    }
}

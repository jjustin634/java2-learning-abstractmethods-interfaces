package com.jsoftware.api.model;

public class TrueFalseQuestion {
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

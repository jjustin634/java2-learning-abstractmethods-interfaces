package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IMultipleChoiceQuestion;

public abstract class MultipleChoiceQuestion implements IMultipleChoiceQuestion {
    private String question;
    private String[] answers;
    private int correctAnswer;


    public MultipleChoiceQuestion(String question, String[] answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(int index) {
        return this.correctAnswer == index;
     }
}


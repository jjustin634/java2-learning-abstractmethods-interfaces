package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IMultipleChoiceQuestion;
import java.io.Serializable;
import static com.jsoftware.api.model.Logger.log;

public class MultipleChoiceQuestion implements IMultipleChoiceQuestion, Serializable {
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

    public String getQuestion() {
        return this.question;
    }

    public void print() {
        log(this.question);

        int n;
        for (int i = 0; i < this.answers.length; i++) {
            n = i + 1;
            log("\t" + n  + ") ", true);
            log(this.answers[i]);
        }
    }
}


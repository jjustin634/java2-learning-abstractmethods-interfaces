package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IShortAnswerQuestion;
import java.io.Serializable;
import java.util.ArrayList;
import static com.jsoftware.api.model.Logger.log;

public class ShortAnswerQuestion implements IShortAnswerQuestion, Serializable {
    private String question;
    private ArrayList<String> keywords;

    public ShortAnswerQuestion(String question, String[] keywords) {
        this.question = question;

        this.keywords = new ArrayList<>();
        for (String word : keywords) {
            this.keywords.add(word);
        }
    }

    public boolean checkAnswer(String answer) {
        return this.keywords.contains(answer);
    }

    public String getQuestion() {
        return this.question;
    }

    public void print() {
        log(this.question);
    }
}



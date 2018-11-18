package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IShortAnswerQuestion;
import java.util.ArrayList;

public class ShortAnswerQuestion implements IShortAnswerQuestion {
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
}

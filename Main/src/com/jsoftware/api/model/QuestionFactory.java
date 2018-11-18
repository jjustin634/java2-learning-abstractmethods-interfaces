package com.jsoftware.api.model;

import com.jsoftware.api.interfaces.IQuestion;
import com.jsoftware.api.interfaces.IQuestionSet;
import com.jsoftware.api.interfaces.IQuestionFactory;
import java.io.IOException;

public class QuestionFactory implements IQuestionFactory {
    private String testName;

    public QuestionFactory() {  }

    public IQuestion makeMultipleChoice(String question, String[] choices, int answer) {
        return new MultipleChoiceQuestion(question, choices, answer);
    }

    public IQuestion makeTrueFalse(String question, boolean answer) {
        return new TrueFalseQuestion(question, answer);
    }

    public IQuestion makeFillInBlank(String question, String [] answers) {
        return new FillInBlanksQuestion(question, answers);
    }

    public IQuestion makeShortAnswer(String question, String[] keywords) {
        return new ShortAnswerQuestion(question, keywords);
    }

    public IQuestionSet load(String filename) throws IOException {
        return new QuestionSet();
    }

    public boolean save(IQuestionSet testSet, String filename) {
        if (this.testName == filename) {
            return true;
        } else {
            return false;
        }
    }

    public IQuestionSet makeEmptyQuestionSet() {
        IQuestionSet emptySet = new QuestionSet();
        return emptySet;
    }
}

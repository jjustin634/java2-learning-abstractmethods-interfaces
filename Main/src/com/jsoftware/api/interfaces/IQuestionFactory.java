package com.jsoftware.api.interfaces;

import java.io.IOException;

public interface IQuestionFactory {
	IQuestion makeMultipleChoice(String question, String[] choices, int answer);
	IQuestion makeTrueFalse(String question, boolean answer);
	IQuestion makeFillInBlank(String question, String [] answers);
	IQuestion makeShortAnswer(String question, String[] keywords);
	IQuestionSet load(String filename) throws IOException;
	boolean save(IQuestionSet testSet, String filename);
}

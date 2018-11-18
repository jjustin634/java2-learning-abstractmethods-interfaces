package com.jsoftware.api.interfaces;

import java.io.IOException;

public interface IQuestionFactory {

	public IQuestion makeMultipleChoice(String question, String[] choices, int answer);

	public IQuestion makeTrueFalse(String question, boolean answer);

	public IQuestion makeFillInBlank(String question, String [] answers);

	public IQuestion makeShortAnswer(String question, String[] keywords);

	public IQuestionSet load(String filename) throws IOException;

	public boolean save(IQuestionSet testSet, String filename);

	public IQuestionSet makeEmptyQuestionSet();
}

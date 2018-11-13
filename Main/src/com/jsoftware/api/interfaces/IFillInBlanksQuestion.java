package com.jsoftware.api.interfaces;

public interface IFillInBlanksQuestion extends IQuestion {
	public boolean checkAnswer(String[] keywords);
}

/**
 * A fill in the blank question may contain multiple blanks.
 * Each blank must match each answer.
 * @param keywords An array of answer the user provides.
 * @return
 */

package com.jsoftware.api.interfaces;

import com.jsoftware.api.interfaces.IQuestion;

public interface ITrueFalseQuestion extends IQuestion {
	public boolean checkAnswer(boolean answer);
}



/**
 * Check if the answer is correct.
 * @param answer The user's answer as as a boolean
 * @return true if correct.
 */
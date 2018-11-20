package com.jsoftware.api.interfaces;

public interface IFillInBlanksQuestion extends IQuestion {
	boolean checkAnswer(String[] keywords);
}

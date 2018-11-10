package com.jsoftware.api.interfaces;

import java.io.IOException;

public interface IQuestionFactory {
	/**
	 * creates a multiple choice question.
	 * @param question The question
	 * @param choices The choices as an array
	 * @param answer The index to the answer in the choices array
	 * @return An instance of a multiple choice question.
	 */
	public IQuestion makeMultipleChoice(String question, String[] choices, int answer);
	

	/**
	 * creates a true-false question.
	 * @param question The question.
	 * @param answer The answer
	 * @return an instance of a true-false question
	 */
	public IQuestion makeTrueFalse(String question, boolean answer);
	
	/**
	 * Creates a fill-in-the-blank question.  
	 * @param question The question, including the blanks
	 * @param answers Array of answers to the blanks
	 * @return an instance of a fill-in-the-blank question
	 */
	public IQuestion makeFillInBlank(String question, String [] answers);
	
	/**
	 * Create a short-answer question.
	 * @param question The question.
	 * @param keywords The answers as a list of key words.  
	 * @return an instance of a short answer question.
	 */
	public IQuestion makeShortAnswer(String question, String[] keywords);
	
	/**
	 * load a question set using the given filename.
	 * @param filename The file containing the test set.
	 * @return A Test set
	 * @throws IOException if can't load the file.
	 */
	public IQuestionSet load(String filename) throws IOException;
	

	/**
	 * Save the test set using the given filename.
	 * @param testSet The test set to be stored.
	 * @param filename  The filename to be used.
	 * @return true if save is successful
	 */
	public boolean save(IQuestionSet testSet, String filename);
	
	
	/**
	 * Create an empty test set.
	 * 
	 * @return an empty test set.
	 */
	public IQuestionSet makeEmptyQuestionSet();
	
	
}

package com.jsoftware.api.interfaces;

public interface IQuestionSet {
	/**
	 * Create an empty test set.
	 * @return  return an instance of a test set.
	 */
	public IQuestionSet emptyTestSet();
	
	/**
	 * return a test set consisting of a random questions.
	 * @param size The number of random questions.
	 * @return The test set instance containing the random questions.
	 */
	public IQuestionSet randomSample(int size);
	
	/**
	 * add a question to the test set.  
	 * @param question The question
	 * @return True if successful.
	 */
	public boolean add(IQuestion question);
	
	/**
	 * 
	 * @param index Remove question using index
	 * @return  true if index is valid
	 */
	public boolean remove(int index);
	
	/**
	 * Retrieving a question using an index
	 * @param index
	 * @return the question if index is valid, null otherwise.
	 */
	public IQuestion getQuestion(int index);
	
	/**
	 * Return the number of questions in this test set.
	 * @return number of questions.
	 */
	public int size();
        

}

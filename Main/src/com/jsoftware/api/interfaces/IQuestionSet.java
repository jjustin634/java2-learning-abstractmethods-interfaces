package com.jsoftware.api.interfaces;

public interface IQuestionSet {
	public IQuestionSet emptyTestSet();
	public IQuestionSet randomSample(int size);
	public boolean add(IQuestion question);
	public boolean remove(int index);
	public IQuestion getQuestion(int index);
	public int size();
}

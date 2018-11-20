package com.jsoftware.api.interfaces;

public interface IQuestionSet {
	IQuestionSet randomSample(int size);
	boolean add(IQuestion question);
	boolean remove(int index);
	IQuestion getQuestion(int index);
	int size();
	void print();
}

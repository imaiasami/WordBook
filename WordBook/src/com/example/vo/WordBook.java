package com.example.vo;

public class WordBook {
	private String word;	// 단어
	private String mean;	// 의미
	
	public WordBook(String word, String mean) {
		this.word = word;
		this.mean = mean;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	@Override
	public String toString() {
		return "WordBook [word=" + word + ", mean=" + mean + "]";
	}
	  
}

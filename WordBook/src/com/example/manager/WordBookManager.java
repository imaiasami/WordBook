package com.example.manager;

import java.util.Iterator;

import com.example.vo.WordBook;

public class WordBookManager {
	
	private WordBook[] wordBooks;	// 단어장의 배열
	private int cnt;				// 배열에 저장된 단어장의 갯수
	
	public WordBookManager() {
		wordBooks = new WordBook[100];
	}
	
	/**
	 * @description: 단어장 객체를 배열에 저장한다.
	 * 				 만약 같은 단어가 이미 존재하면 등록하지 않는다.
	 * @param: WordBook wordBook
	 * @return: 등록 성공이면 true, 실패면 false
	 */
	public boolean addWordBook(WordBook wordBook) {
		if (searchWordBook(wordBook.getWord()) != null) {
			return false;
		}
		wordBooks[cnt++] = wordBook;
		return true;
	}
	
	/**
	 * @description: 매개변수로 단어를 전달받아 배열에 같은 단어가 존재하면
	 * 				 단어장 객체를 리턴한다.
	 * @param: String word
	 * @return: 같은 단어가 있으면 단어장 객체, 없으면 null
	 */
	public WordBook searchWordBook(String word) {
		for (int i = 0; i < cnt; i++) {
			if (wordBooks[i].getWord().equals(word)) {
				return wordBooks[i];
			}
		}
		
		return null;
	}
	
	/**
	 * @description: 매개변수로 단어를 전달받아 배열에 같은 단어가 존재하면
	 * 				 단어장 객체를 배열에서 삭제한다.
	 * @param: String word
	 * @return: 삭제에 성공하면 true, 실패하면 false
	 */
	public boolean removeWordBook(String word) {
		if (searchWordBook(word) != null) {
			for (int i = 0; i < cnt; i++) {
				if (wordBooks[i].getWord().equals(word)) {
					for (int j = 0; j < cnt; j++) {
						if (j == cnt -1) {
							wordBooks[j] = null;
						} else {
							wordBooks[j] = wordBooks[j + 1];
						}
					}
					cnt--;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @description: 현재까지 등록된 단어장 배열을 새로 만들어서 리턴한다.
	 * @param: 
	 * @return: 단어장 배열
	 */
	public WordBook[] getAllWordBooks() {
		WordBook[] result = new WordBook[cnt];
		for (int i = 0; i < cnt; i++) {
			result[i] = wordBooks[i];
		}
		
		return result;
	}
}

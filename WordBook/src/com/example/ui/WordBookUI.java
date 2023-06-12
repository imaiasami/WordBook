package com.example.ui;

import java.util.Scanner;

import com.example.manager.WordBookManager;
import com.example.vo.WordBook;

public class WordBookUI {
	private Scanner scanner = new Scanner(System.in);
	private WordBookManager manager = new WordBookManager();
	
	public WordBookUI() {
		while (true) {
			printMainMenu();
			int input = scanner.nextInt();
			switch (input) {
				case 1: addWordBook(); break;
				case 2: searchWordBook(); break;
				case 3: updateWordBook(); break;
				case 4: removeWordBook(); break;
				case 5: printAllWordBooks(); break;
				case 6: System.exit(0);;
				default:System.out.println("잘못 입력 했습니다.");
			}
		}
	}
	
	/**
	 * @description: 매인매뉴를 출력한다.
	 * @param
	 * @return
	 */
	public void printMainMenu() {
		System.out.println("[단어장 프로그램]");
		System.out.println("1. 단어장 추가");
		System.out.println("2. 단어장 검색");
		System.out.println("3. 단어장 수정");
		System.out.println("4. 단어장 삭제");
		System.out.println("5. 전체출력");
		System.out.println("6. 프로그램 종료");
		System.out.print("선택> ");		
	}
	
	/**
	 * @description: 사용자로부터 단어와 의미를 입력받아 단어장에 등록한다.
	 *               등록에 성공하면 성공, 실패하면 실패 메시지를 출력한다.
	 * @param
	 * @return
	 */
	public void addWordBook() {
		System.out.println("등록할 단어와 의미를 입력하세요: ");
		System.out.print("단어: ");
		String word = scanner.next();
		System.out.print("의미: ");
		String mean = scanner.next();
		
		if (manager.addWordBook(new WordBook(word, mean))) {
			System.out.println("단어장이 등록 되었습니다.");
		} else {
			System.out.println("동일한 단어가 이미 등록되어 있습니다.");
		}
	}
	
	/**
	 * @description: 사용자로부터 단어를 입력받아 단어에 해당하는 WordBook의 정보를 출력한다.
	 * @param
	 * @return
	 */
	public void searchWordBook() {
		System.out.print("검색할 단어: ");
		String word = scanner.next();
		WordBook searchWordBook = manager.searchWordBook(word);
		if (searchWordBook != null) {
			System.out.println(searchWordBook);		
		} else {
			System.out.println("검색한 단어가 없습니다.");
		}
	}
	
	/**
	 * @description: 사용자로부터 단어를 입력받아 단어장에서 찾고 의미를 수정하여 저장한다.
	 * 				 찾는 단어가 없으면 수정 실패, 있으면 수정 성공 출력
	 * @param
	 * @return
	 */
	public void updateWordBook() {
		System.out.print("수정할 단어: ");
		String word = scanner.next();
		
		WordBook searchWordBook = manager.searchWordBook(word);
		if (searchWordBook != null) {
			System.out.println("검색결과: " + searchWordBook);
			System.out.print("수정할 의미: ");
			String mean = scanner.next();
			searchWordBook.setMean(mean);
			System.out.println("단어장이 수정 되었습니다.");
		} else {
			System.out.println("검색한 단어가 없습니다.");
		}
	}
	
	/**
	 * @description: 사용자로부터 단어를 입력받아 단어장에서 찾아 삭제한다.
	 * 				 찾는 단어가 없으면 삭제 실패, 있으면 삭제 성공 출력
	 * @param
	 * @return
	 */
	public void removeWordBook() {
		System.out.print("삭제할 단어: ");
		String word = scanner.next();
		
		if (manager.removeWordBook(word)) {
			System.out.println("단어장이 삭제 되었습니다.");
		} else {
			System.out.println("삭제할 단어장이 없습니다.");
		}
	}
	
	/**
	 * @description: 등록된 모든 단어장 정보를 출력한다.
	 * @param
	 * @return
	 */
	public void printAllWordBooks() {
		WordBook[] wordBooks = manager.getAllWordBooks();
		for (int i = 0; i < wordBooks.length; i++) {
			System.out.println(wordBooks[i]);
		}
	}
	
}

package level2;

import java.util.Collections;
import java.util.LinkedList;
//효율 테스트 통과 못함
public class phonBook {

	public static void main(String[] args) {
		String[] phone_book = {"123", "456", "789"};

		LinkedList<String> list = new LinkedList<>();
		for(String str : phone_book) list.add(str);

		Collections.sort(list, (str1, str2) -> {return str1.length() - str2.length(); });
		//길이 짧은 것부터 오름차순
		boolean answer = true;
		int least = list.get(0).length();
		for(int i=0; i<list.size(); i++) {
			String prefix = list.get(i);
			if( least < prefix.length() ) {//더 길어지면 이전 것들을 삭제
				least = prefix.length();
				while(i-->=1) {
					list.removeFirst();
				}
			}

			if( !notExist(prefix, list) ) {
				answer = false;
			}

		}

		System.out.print(answer==true? "true" : "false");
	}

	static boolean notExist(String prefix, LinkedList<String> book) {
		for(int i=0; i<book.size(); i++) {
			if(book.get(i).equals(prefix)) continue;
			if( book.get(i).startsWith(prefix) ) {
				return false;
			}
		}

		return true;
	}

}

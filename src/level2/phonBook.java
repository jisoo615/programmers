package level2;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/42577
public class phonBook {

	public static void main(String[] args) {
		String[] phone_book = {"819232312", "976", "119552", "2"};

		/*LinkedList<String> list = new LinkedList<>();
		for(String str : phone_book) list.add(str);

		Collections.sort(list);*/
		//알파벳 순서대로 정렬
		Arrays.sort(phone_book);
		boolean answer = true;

		for(int i=1; i<phone_book.length; i++) {

			String prefix = phone_book[i-1];
			if( phone_book[i].startsWith(prefix) ) {
			    answer = false;
				break;
			}
		}

		System.out.print(answer==true? "true" : "false");
	}

}

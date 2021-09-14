package level1;

import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/72410
public class kakao_new_id {

	public static void main(String[] args) {
		String new_id = "=.=";
		String answer = "";
		char[] arr = new_id.toCharArray();

		HashSet<Character> set = new HashSet<>();
		set.add('.');set.add('-');set.add('_');

		for(char c : arr) {
			if(c-49 >=0 && c-49 <=10) {//숫자
				answer += c;
			}else if(c-65 >=0 && c-65 <=26) {//대문자
				answer += Character.toLowerCase(c);
			}
			else if(c-97 >=0 && c-97 <=26) {//소문자
				answer += c;
			}
			else{
				if(set.contains(c)) {
					answer += c;
				}
			}
		}

		if(answer.startsWith(".")) answer.subSequence(1, answer.length()-1);
		if(answer.endsWith(".")) answer.substring(0, answer.length()-2);

		if(answer.isEmpty()) answer += "a";
		else if(answer.length() > 15) answer.subSequence(0, 14);

		if(answer.endsWith(".")) answer.subSequence(0, answer.length()-2);

		while(answer.length() < 3) {
			answer.concat(answer);
		}

		System.out.print(answer);

	}

}

package level1;

import java.util.HashMap;

public class kakao_digitAndEngString {

	static public void main(String[] args) {
		String s = "one1twotwo34";
		String answer = "";
		String temp ="";
		boolean isWord = false;
		HashMap<String, String> set = new HashMap<>();
		set.put("one", "1");set.put("two", "2"); set.put("three", "3");set.put("four", "4"); set.put("five", "5");
		set.put("six", "6");set.put("seven", "7"); set.put("eight","8");set.put("nine","9"); set.put("zero","0");
		for(char c : s.toCharArray()) {
			if( isWord==false &&  c-48 >= 0 && c-48 <=10 ) {//이미 문자열이 아닐때 &&숫자면
				answer += c;
			}else {//문자면
				isWord = true;
				temp += c;
				if(set.containsKey(temp)) {//영단어 숫자 있으면
					answer += set.get(temp);
					temp = "";//초기화
					isWord = false;//초기화
				}
			}
		}

		System.out.print(Integer.parseInt(answer));
	}

}

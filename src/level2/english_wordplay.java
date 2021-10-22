package level2;

import java.util.HashSet;

public class english_wordplay {

	public static void main(String[] args) {
		int n=2;
		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		for(int x: solution(n, words)) System.out.print(x+" ");

	}

	static public int[] solution(int n, String[] words) {
		int[] answer = {0, 0};
		HashSet<String> set = new HashSet<>();
		set.add(words[0]);
		for(int i=1; i<words.length; i++) {
			String pre = words[i-1];
			if(set.contains(words[i]) || pre.charAt(pre.length()-1)!=(words[i].charAt(0))) {
				answer[0] = i%n+1;
				answer[1] = i/n+1;
				return answer;
			}
			set.add(words[i]);
		}
		return answer;
	}

}

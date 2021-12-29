package level2;
//https://programmers.co.kr/learn/courses/30/lessons/84512
//모음사전
import java.util.ArrayList;
import java.util.TreeSet;

public class vowel_dictionary {
//깊이탐색으로 풀기
//다른 방법: 경우의 수로 구하기
	public static void main(String[] args) {
		Solution s = new Solution();
		String word = "EIO";
		System.out.print(s.solution(word));
		//
	}

	static class Solution {
		char[] vowel = {'A','E','I','O','U'};
		TreeSet<String> set = new TreeSet<>();

		public void ordering(int index, int depth, String result) {
			if(index==depth) {
				set.add(result);
				return;
			}
			for(int i=0; i<5; i++) {
				ordering(index+1, depth, result+vowel[i]);
			}

		}


	    public int solution(String word) {
	        int answer = 0;
	        for(int i=1; i<=5; i++) {
	        	ordering(0, i, "");
	        }
	        ArrayList<String> list = new ArrayList<>(set);
	        answer = list.indexOf(word)+1;
	        return answer;
	    }
	}

}

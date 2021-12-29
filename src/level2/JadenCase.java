package level2;
//https://programmers.co.kr/learn/courses/30/lessons/12951
//jadencase 문자 만들기
public class JadenCase {

	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "3people  unFollowed  me";
		System.out.print(s.solution(str));

	}

	static class Solution {
	    public String solution(String s) {
	        StringBuilder sb = new StringBuilder();
	        s = s.toLowerCase();
	        boolean jaden = true;
	        for(int i=0; i<s.length(); i++) {

	        	if(s.charAt(i)==' ') {
	        		sb.append(" ");
	        		jaden = true;
	        		continue;
	        	}

	        	if(jaden) {//단어시작일때
		        	char first = s.charAt(i);
		        	if(first>='a' && first<='z') {
		        		first = (char) (first - 32);
	        		}
		        	sb.append(first);
		        	jaden = false;
	        	}
	        	else {//jaden = false
	        		sb.append(s.charAt(i));
	        	}

	        }
	        return sb.toString();
	    }
	}

}

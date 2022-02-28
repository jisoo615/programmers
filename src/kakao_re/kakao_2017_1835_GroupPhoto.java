package kakao_re;
//https://programmers.co.kr/learn/courses/30/lessons/1835
//단체사진 찍기
public class kakao_2017_1835_GroupPhoto {

	public static void main(String[] args) {
		System.out.println(Solution.solution(2, new String[] {"N~F=0", "R~T>2"}));

	}

	static class Solution {
	    static public int answer;
		static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

		public static int solution(int n, String[] data) {
			boolean[] visited = new boolean[friends.length];
			answer=0;
			dfs("", data, visited);

			return answer;
		}

		public static void dfs(String str, String[] data, boolean[] visited) {
			if(str.length()==8) {
				if(check(data, str)) {
					System.out.println("===: "+str);
					answer++;
				}
			}

			for(int i=0; i<8; i++) {
				if(visited[i]==false) {
					visited[i] = true;
					dfs(str+friends[i], data, visited);
					visited[i] = false;
				}
			}
		}

		public static boolean check(String[] data, String str) {
			boolean isRight=false;
			for(String condition : data) {
				char f1 = condition.charAt(0);
				char f2 = condition.charAt(2);
				char c = condition.charAt(3);
				int space = condition.charAt(4)-'0';

				int differ =Math.abs( str.indexOf(f1) - str.indexOf(f2))-1;

				switch(c) {
				case '<':
					if(differ < space) isRight=true;
					else isRight=false;
					break;
				case '>':
					if(differ > space) isRight=true;
					else isRight=false;
					break;
				case '=':
					if(differ==space) isRight=true;
					else isRight=false;
					break;
				}

				if(!isRight) return false;
			}
			return true;
		}

}
}

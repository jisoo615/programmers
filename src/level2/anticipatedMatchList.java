package level2;
//https://programmers.co.kr/learn/courses/30/lessons/12985
//예상대진표 레벨2
public class anticipatedMatchList {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.print(s.solution(8, 4, 7));
	}

	static class Solution{
		public int solution(int n, int a, int b) {
		//n명중 a번째와 b번쩨 선수가 승부를 가리는 동안 하는 경기 횟수는?
		//(a+1/2)와 (b+1)/2가 같아지면 그둘은 둘중 승부를 내게됨
			int answer = 0;
			while(a!=b) {//같아지면 둘이 겨룬 후니까
				a = (a+1)/2;
				b = (b+1)/2;
				answer++;
			}
			return answer;
		}
	}

}

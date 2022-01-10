package level2;

//https://programmers.co.kr/learn/courses/30/lessons/42883
//큰 수 만들기
//stack으로도 가능함. 참고-테스트케이스10번은 엄청 긴(중간에 같은수가 연속된) 숫자임
public class makeBigNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.print(s.solution("1924", 2));
	}

	static class Solution{
		//탐욕법 k개를 제거했을때 가장 큰 수를 구하여라.
		public String solution(String number, int k) {
			String answer = "";
			int delNum = k;
			String suffix = number;//맨 끝에 남은 부분으로, 나중에 answer에 추가하게될 문자열

			while(delNum>0) {
				char max = '0';
				int maxPos = 0;

				if(suffix.length()==delNum) {//지워야할 개수와 남은 개수가 같으면 suffix를 더하지 않고 answer을 리턴
					return answer;
				}

				for(int i=0; i<delNum+1; i++) {
					if(max < suffix.charAt(i)) {
						max = suffix.charAt(i);
						maxPos = i;
						if(max=='9') break;
					}
				}

				answer += Character.toString(suffix.charAt(maxPos));
				suffix = suffix.substring(maxPos+1);
				delNum -= maxPos;
			}

			answer += suffix;

			return answer;
		}

	}
}

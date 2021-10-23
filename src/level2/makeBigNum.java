package level2;
//https://programmers.co.kr/learn/courses/30/lessons/42883
//큰 수 만들기
//테스트 10번만 시간초과로 미완성.. 하지만 답을 찾을 수 없음
public class makeBigNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solution("1924", 2));
	}

	static public String solution(String number, int k) {
		String answer = "";
		int current = 0;

		for (int i = 0; i < number.length() - k; i++) {

			for (int j = current; j <= i + k; j++) {
				if (number.charAt(current)< number.charAt(j)) {
					current = j;
				}
			}

			answer += number.charAt(current);
			current += 1;
		}

		return answer;
	}
}

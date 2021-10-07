package level2;
//https://programmers.co.kr/learn/courses/30/lessons/12899
//124 나라의 숫자
public class country_124 {

	public static void main(String[] args) {
		int n = 15;

		String sol1 = solution1(n);
		String sol2 = solution2(n);
		String sol1_revision = solution1_revision(n);

		System.out.println(sol1);
		System.out.println(sol2);
		System.out.println(sol1_revision);

	}

	/*통과 실패*/
	public static String solution1(int n) {
		String answer = "";
		char[] c = {'4', '1', '2'};
		while(n > 0) {
			if(n/3 >= 0) {
				int remain = n%3;
				answer = c[ remain ] + answer;
				n /= 3;
				if(remain==0) n--;
			}
		}
		return answer;
	}

	/*통과 성공*/
	public static String solution1_revision(int n) {//시간초과 보완
		String answer = "";
		String[] c = {"4", "1", "2"};//solution1이 초과 났던 이유: String에 char을 붙이려니까 형변환 때문에 초과나 났나봄
		//그래서 char[]에서 String[]으로 바꿔줌
		while(n > 0) {
				answer = c[ n%3 ] + answer;
				n = (n-1)/3;//0으로 나눠 떨어지면 계속 1이 더 남는 것을 방지
			}
		return answer;
	}

	/*통과 성공*/
	public static String solution2(int n) {
		String answer="";
		while(n > 0) {
			int remain = n%3;
			n = n/3;

			if(remain==0) {
				answer ="4"+answer;
				n--;
			}else if(remain==1) {
				answer ="1"+answer;
			}else if(remain==2){
				answer ="2"+answer;
			}
		}
		return answer;
	}

}

package kako;
//https://programmers.co.kr/learn/courses/30/lessons/60057
public class kakao_string_zip {

	public static void main(String[] args) {
		String s="ababcdcdababcdcd";
		String answer;

		String before, next = null;
		int cnt;
		int min = s.length();//전체를 한 단위로 압축할 때

		for(int unit=1; unit<=s.length()/2; unit++) {//단위는 1~길이의 1/2과 같거나 작아야 한다.
		//int unit = 3;

			answer = "";
			cnt = 1;
			before = s.substring(0, unit);
			for(int i=unit; i<s.length(); i += unit) {

				int start = i;
				int end = i+unit > s.length() ? s.length() : i+unit;
				next = s.substring(start, end);

				if(before.equals(next)){
					cnt ++;

				}else {//다르면 기준을 바꿔주고 cnt 초기화
					if(cnt>=2) {answer += (cnt + before);}
					else {answer += before;}

					before = next;
					cnt =1;
				}

			}

			//위 for 문에서는 마지막 비교한 next가 answer에 더해지지 않은 채 끝났다. 같았을 경우엔 cnt만 하나 증가 한 채로 끝난것.
				if(cnt>=2) {answer += (cnt + before);}
				else {answer += before;}



			min = min > answer.length() ? answer.length() : min;

			}

		System.out.println(min);
	}
}

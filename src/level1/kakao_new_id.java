package level1;

//https://programmers.co.kr/learn/courses/30/lessons/72410
public class kakao_new_id {

	public static void main(String[] args) {
		String new_id = 	"123_.def";
		String answer = "";

		answer = new_id.toLowerCase();
		System.out.println("1 -> "+answer);
		answer = answer.replaceAll("[^a-z0-9._-]", "");//정규식 표현
		System.out.println("1 -> "+answer);
		answer = answer.replaceAll("[.]{2,}", ".");//.이 2개 이상 인것을 한개로 바꾸기
		System.out.println("1 -> "+answer);
		answer = answer.replaceAll("^[.]|[.]$", "");//마침표 처음이나 끝에 있으면 삭제
		System.out.println("4 -> "+answer);
		answer = answer.length()==0 ? "a" : answer;//빈문자열이면 a넣어줌
		System.out.println("1 -> "+answer);
		answer = answer.length()>=16 ? answer.substring(0, 15) : answer;//subString(start, end)면 start 부터 end-1까지 자름
		System.out.println("1 -> "+answer);
		answer = answer.replaceAll("[.]$", "");//.으로 끝나면 제거
		System.out.println("1 -> "+answer);

		if(answer.length() <= 2) {
			String add="";
			add = answer.substring(answer.length()-1).repeat(3-answer.length());
			System.out.println(add);
			answer += add;
		}

		System.out.println(answer);

	}

}

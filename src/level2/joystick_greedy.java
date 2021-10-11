package level2;
//http://localhost:8088/student/edit?id=6
//조이스틱
public class joystick_greedy {

	public static void main(String[] args) {
		String name = "JAZ";
		System.out.print(solution(name));

	}

	public static int solution(String name) {
		int answer = 0;
		int min = name.length()-1;

		for(int i=0; i<name.length(); i++) {
			int differ = name.charAt(i)-'A';

			if(differ==0) {//A일때
				int j;
				for(j=i; j<name.length(); j++) {
					if(name.charAt(j)!='A') {break;}
				}
				int before = i-1 < 0 ? 0 : i-1;
				min = Math.min(min, before*2 + name.length()-j);
			}

			else {
				answer += Math.min(differ, 26-differ);
			}
		}

		answer += min;
		return answer;
	}

}

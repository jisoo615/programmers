package kako;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/1835
//단체사진 찍기
public class kakaofriends_picinic_photo {
	static public int answer;
	static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

	public static void main(String[] args) {
		int n=2;
		String[] data = {"N~F=0", "R~T>2"};

		boolean visited[] = new boolean[8];

		//단체사진 찍는 카카오프렌즈는 총 8명임
		answer = 0;
		Arrays.fill(visited, false);
		dfs("", data, visited);
		System.out.println(answer);
	}

	static public void dfs(String temp, String[] data, boolean[] visited) {

		if(temp.length()==8) {
			System.out.println(temp);
			if(check(temp, data)) {

				answer+=1;
			}
			return;
		}

		for(int i=0; i<8; i++) {
			if(!visited[i]) {
				visited[i] = true;
				//혹은 String result = temp + friends[i] 로 넘겨줘야 됨.
				//왜냐 재귀함수를 수행하고 돌아왔을 때 바로 이전으로 돌아가야 하기 때문.
				dfs(temp+friends[i], data, visited);
				visited[i] = false;
			}
		}

	}

	static boolean check(String result, String data[]) {
		for(String s : data) {
			char cal = s.charAt(3);
			int gap = s.charAt(4)-'0'+1;

			int indexF1 = result.indexOf(s.charAt(0));
			int indexF2 = result.indexOf(s.charAt(2));

			switch(cal) {
			case '=': if(!(Math.abs(indexF1-indexF2)==gap)) { return false;}
				 break;

			case '<':
				if( !(Math.abs(indexF1-indexF2) < gap)) {return false;}
				 break;

			case '>': if(!(Math.abs(indexF1-indexF2) > gap)) {return false;}
				 break;
			}

		}

		return true;
	}

}

package kako;
//https://programmers.co.kr/learn/courses/30/lessons/42888
//오픈채팅방 카카오 2019 블라인드
import java.util.HashMap;

public class kakao_2019_blind {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi"
				, "Enter uid4567 Prodo"
				,"Leave uid1234"
				,"Enter uid1234 Prodo"
				,"Change uid4567 Ryan"};

		HashMap<String, String> map = new HashMap<>();
		int cnt = 0;
		for(int i=0; i<record.length; i++) {
			String[] line = record[i].split(" ");

			switch(line[0]) {
			case "Enter":
				map.put(line[1], line[2]);
				break;
			case "Change":
				map.replace(line[1], line[2]);
				cnt+=1;
				break;
			}
		}

		String[] answer = new String[record.length-cnt];
		int ansIndex = 0;
		for(int i=0; i<record.length; i++) {
			String[] line = record[i].split(" ");

			switch(line[0]) {
			case "Enter":
				answer[ansIndex] = map.get(line[1])+"님이 들어왔습니다.";
				ansIndex++;
				break;
			case "Leave":
				answer[ansIndex] = map.get(line[1])+"님이 나갔습니다.";
				ansIndex++;
				break;

			}
		}

		for(String ans : answer) {
			System.out.println(ans);
		}

	}

}

package kako;
//https://programmers.co.kr/learn/courses/30/lessons/17683
//방금 그곡
import java.util.HashMap;

public class kakao_2018_3rd_thatMusic {

	public static void main(String[] args) {
		Solution s = new Solution();
		String m = "ABC";
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.print(s.solution(m, musicinfos));

	}

	static class Solution{
		public String solution(String m, String[] musicinfos) {
	        String answer = "(None)";
	        HashMap<Integer, String> map = new HashMap<>();

	        String melody = better(m);
	        int max = 0;
	        for(String musicinfo : musicinfos) {
	        	String[] info = musicinfo.split(",");
	        	int playtime = minutes(info[0], info[1]);

	        	String music = better(info[3]);

	        	if(isRight(playtime, music, melody)) {//해당 노래가 맞는지 확인

	        		if(playtime<=max) continue;
	        		map.put(playtime, info[2]);
	        		max = playtime;
	        	}
	        }
	        if(map.size()>0) answer = map.get(max);

	        return answer;
	    }

		public int minutes(String start, String end){
			int time1 = Integer.parseInt(start.substring(0, 2))*60+Integer.parseInt(start.substring(3, 5));
			int time2 = Integer.parseInt(end.substring(0, 2))*60+Integer.parseInt(end.substring(3, 5));
			return time2-time1;
		}
		public boolean isRight(int playtime, String music, String melody) {
			if(playtime > music.length()) {//악보보다 재생시간이 더 길때만 조정해준다.
				int count = playtime/music.length();
				music = music.repeat(count+1);
			}
			music = music.substring(0, playtime+1);

			return music.contains(melody);
		}
		public String better(String m) {
			m = m.replace("C#", "c");
			m = m.replace("D#", "d");
			m = m.replace("F#", "f");
			m = m.replace("G#", "g");
			return m;
		}

	}//class Solution end

}

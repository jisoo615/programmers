 package level3;

//https://programmers.co.kr/learn/courses/30/lessons/17676
//추석 트래픽
public class kakao_2018_1stBlind_thanksgivingTraffic {

	public static void main(String[] args) {//9/15일만 있음 추석날만 구하는것이기 때문에
		String lines[] = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		System.out.print(solution(lines));

	}

	static public int solution(String[] lines) {
		int[] end = new int[lines.length];
		int[] start = new int[lines.length];
		for(int i=0; i<lines.length; i++) {
			int hour = Integer.parseInt(lines[i].substring(11, 13))*3600000;
			int minute = Integer.parseInt(lines[i].substring(14, 16))*60000;
			int second = (int) (Double.parseDouble(lines[i].substring(17, 23))*1000);
			int time = (int) (Double.parseDouble(lines[i].split(" ")[2].replace("s", ""))*1000);
			end[i] = hour+minute+second;//millisecond
			start[i] = end[i] - time + 1;
		}
		int answer = 0;
		for(int i=0; i<end.length; i++) {
			int cnt=1;
			for(int j=i+1; j<start.length; j++) {
				if(start[j]-end[i] < 1000) cnt++;
			}
			answer = answer < cnt ? cnt : answer;
		}

        return answer;
    }

}

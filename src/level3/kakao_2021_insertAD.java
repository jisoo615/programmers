package level3;
//https://programmers.co.kr/learn/courses/30/lessons/72414
//광고 삽입
public class kakao_2021_insertAD {

	public static void main(String[] args) {
		String play_time="02:03:55";
		String adv_time="00:14:15";
		String[] logs= {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29"
				, "01:30:59-01:53:29", "01:37:44-02:02:30"};
		System.out.print(solution(play_time, adv_time, logs));
	}

	public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        String[] play = play_time.split(":");
        int play_sec = Integer.parseInt(play[0])*360 + Integer.parseInt(play[1])*60 + Integer.parseInt(play[2]);
        String[] adv = adv_time.split("[:]");
        int adv_sec = Integer.parseInt(adv[0])*360 + Integer.parseInt(adv[1])*60 + Integer.parseInt(adv[2]);

        int[] viewer = new int[100*360+60*60+60];
        for(String log :logs) {
        	String[] arr = log.split("[:-]");//:나 -문자가 있다면 잘라라
        	int sh = Integer.parseInt(arr[0]);
        	int sm = Integer.parseInt(arr[1]);
        	int ss = Integer.parseInt(arr[2]);
        	int start = sh*360+sm*60+ss;
        	int eh = Integer.parseInt(arr[3]);
        	int em = Integer.parseInt(arr[4]);
        	int es = Integer.parseInt(arr[5]);
        	int end = eh*360+em*60+es;

        	for(int i=start; i<end; i++) {
        		viewer[i] += 1;
        	}
        }//시간대별 각 동시 시청자 표시만 해둠

        int viewers = 0;
        //광고시간누적시청자수 = 00~광고끝나는시간 - 00~광고시작시간
        for(int i=adv_sec; i<play_sec; i++) {
        	//누적 시청자가 많은 구간을 구해라
        }

        return answer;
    }

}

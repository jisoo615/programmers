package level3;
//https://programmers.co.kr/learn/courses/30/lessons/72414
//광고 삽입
public class kakao_2021_insertAD {

	public static void main(String[] args) {
		/*String play_time="02:03:55";
		String adv_time="00:14:15";
		String[] logs= {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29"
				, "01:30:59-01:53:29", "01:37:44-02:02:30"};
				*/
		String play_time="50:00:00";
		String adv_time="50:00:00";
		String[] logs= {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};
		System.out.print(solution(play_time, adv_time, logs));
	}

	public static String solution(String play_time, String adv_time, String[] logs) {
        String[] play = play_time.split(":");
        int play_sec = Integer.parseInt(play[0])*3600 + Integer.parseInt(play[1])*60 + Integer.parseInt(play[2]);
        String[] adv = adv_time.split("[:]");
        int adv_sec = Integer.parseInt(adv[0])*3600 + Integer.parseInt(adv[1])*60 + Integer.parseInt(adv[2]);

        long[] viewer = new long[play_sec];
        int h, m, s;
        for(String log :logs) {
        	String[] arr = log.split("[:-]");//:나 -문자가 있다면 잘라라
        	h = Integer.parseInt(arr[0]);
        	m = Integer.parseInt(arr[1]);
        	s = Integer.parseInt(arr[2]);
        	int start = h*3600+m*60+s;
        	h = Integer.parseInt(arr[3]);
        	m = Integer.parseInt(arr[4]);
        	s = Integer.parseInt(arr[5]);
        	int end = h*3600+m*60+s;

        	for(int i=start; i<end; i++) {
        		viewer[i] += 1;
        	}
        }//시간대별 각 동시 시청자 표시만 해둠

        for(int i=1; i<play_sec; i++) {
        	viewer[i] += viewer[i-1];
        }

        //광고시간누적시청자수 = 00~광고끝나는시간 - 00~광고시작시간
        long viewers = viewer[adv_sec-1];//첫 기준은 00에 시작하는 광고
        int adv_insert=0;
        for(int i=1; i<play_sec-adv_sec+1; i++) {
        	if(viewers < viewer[i+adv_sec-1] - viewer[i-1]) {
        		adv_insert = i;
        		viewers = viewer[i+adv_sec-1] - viewer[i-1];
        	}
        }

        StringBuilder sb = new StringBuilder();
        int hh = adv_insert/3600;
        adv_insert %= 3600;
        int mm = adv_insert/60;
        adv_insert %= 60;
        int ss = adv_insert;
        sb.append(hh<10 ? "0"+hh : hh); sb.append(":");
        sb.append(mm<10 ? "0"+mm : mm); sb.append(":");
        sb.append(ss<10 ? "0"+ss : ss);
        return sb.toString();
    }

}

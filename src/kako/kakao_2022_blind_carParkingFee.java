package kako;
//https://programmers.co.kr/learn/courses/30/lessons/92341
//주차요금 계산
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class kakao_2022_blind_carParkingFee {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {
				"05:34 5961 IN",
				"06:00 0000 IN",
				"06:34 0000 OUT",
				"07:59 5961 OUT",
				"07:59 0148 IN",
				"18:59 0000 IN",
				"19:09 0148 OUT",
				"22:59 5961 IN",
				"23:00 5961 OUT"};
		Solution s = new Solution();
		for(int x : s.solution(fees, records)) {
			System.out.println(x);
		}

	}

	static class Solution {// 차량번호 작은순대로, 하루동안 주차시간 합친 누적 요금 반환
	    public int[] solution(int[] fees, String[] records) {
	    	//fees : 기본시간, 기본요금, 기준시간단위, 단위시간당요금
	    	//records : 사각 차번호 날/출입
	        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
	        for(String record : records) {
	        	String[] str = record.split(" ");
	        	int carNum = Integer.parseInt(str[1]);
	        	if(!map.containsKey(carNum)) {//차가 들어왔었으면
	        		map.put(carNum, new ArrayList<>());
	        	}map.get(carNum).add(str[0]);
	        }
	        int[] answer = new int[map.size()];
	        List<Integer> cars = map.keySet().stream().collect(Collectors.toList());
	        Collections.sort(cars);
	        int index = 0;

	        for(int carNum : cars) {
	        	int totalTime = 0;
	        	var list = map.get(carNum);

	        	if(list.size()%2==1) list.add("23:59");

	        	while(list.size()>1) {
	        		int in = toMinute(list.get(0));
	        		int out = toMinute(list.get(1));
	        		list.remove(0);list.remove(0);
	        		totalTime += (out-in);
	        	}

	        	int result = calculate(totalTime, fees);

	        	answer[index] = result;
	        	index++;

	        }


	        return answer;
	    }

	    private int calculate(int totalTime, int[] fees) {
	    	//fees : 기본시간, 기본요금, 기준시간단위, 단위시간당요금
	    	int result = 0;
	    	totalTime -= fees[0];
	    	result += fees[1];
	    	if(totalTime>0) {
	    		result += Math.ceil(totalTime/(double)fees[2])*fees[3];
	    	}
			return result;

		}

		private int toMinute(String time) {
	    	String[] temp = time.split(":");
	    	return Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
	    }
	}

}

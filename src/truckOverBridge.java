import java.util.*;

public class truckOverBridge {
//1초에 1만큼 지나갈수 있음. 다리길이가 100이면 100초가 걸림.
	public static void main(String[] args) {//모든 트럭이 지나고 나서의 걸린 시간을 구하라. (한 트럭이 자나갈때)
		int bridge_length=100;//최대 차량
		int weight=100;//최대 무게
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};//트럭들의 무게
		
		Queue<Integer> readyTrucks = new LinkedList<>();
		Queue<Integer> onBridge = new LinkedList<>();
		for(int x : truck_weights) readyTrucks.add(x);
		for(int i=0; i<bridge_length; i++) onBridge.add(0);//미리 다리 길이만큼 0을 넣어줌
		
		int time=0;
		int weight_sum =0;
		while(!readyTrucks.isEmpty()) {
			
			weight_sum -= readyTrucks.peek();//왜 처음에 빼느냐 : 오르고 있는 중은 무게에 치지 않음. 즉 최대100무게 버틴다면 99 다음 2키로가 올라가서 101이 되어도 됨.
			onBridge.poll();//
			
			//대기 트럭이 없으면(맨 마지막에
			if(readyTrucks.isEmpty()) {
				time += bridge_length;
				break;//그리고 while나가기
			}
			
			if(weight_sum + readyTrucks.peek() <= weight) {//다른 차 더 와도 되면 
				onBridge.offer(readyTrucks.peek());
				weight_sum += readyTrucks.poll();
				}
			else {//더이상 못들어가면 0 넣어줌.
				onBridge.offer(0);
			}
			
			time++;
		}
		
		System.out.print(time);
	}
}

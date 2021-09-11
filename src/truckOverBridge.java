import java.util.*;

public class truckOverBridge {
//1�ʿ� 1��ŭ �������� ����. �ٸ����̰� 100�̸� 100�ʰ� �ɸ�.
	public static void main(String[] args) {//��� Ʈ���� ������ ������ �ɸ� �ð��� ���϶�. (�� Ʈ���� �ڳ�����)
		int bridge_length=100;//�ִ� ����
		int weight=100;//�ִ� ����
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};//Ʈ������ ����
		
		Queue<Integer> readyTrucks = new LinkedList<>();
		Queue<Integer> onBridge = new LinkedList<>();
		for(int x : truck_weights) readyTrucks.add(x);
		for(int i=0; i<bridge_length; i++) onBridge.add(0);//�̸� �ٸ� ���̸�ŭ 0�� �־���
		
		int time=0;
		int weight_sum =0;
		while(!readyTrucks.isEmpty()) {
			
			weight_sum -= readyTrucks.peek();//�� ó���� ������ : ������ �ִ� ���� ���Կ� ġ�� ����. �� �ִ�100���� ��ƾ�ٸ� 99 ���� 2Ű�ΰ� �ö󰡼� 101�� �Ǿ ��.
			onBridge.poll();//
			
			//��� Ʈ���� ������(�� ��������
			if(readyTrucks.isEmpty()) {
				time += bridge_length;
				break;//�׸��� while������
			}
			
			if(weight_sum + readyTrucks.peek() <= weight) {//�ٸ� �� �� �͵� �Ǹ� 
				onBridge.offer(readyTrucks.peek());
				weight_sum += readyTrucks.poll();
				}
			else {//���̻� ������ 0 �־���.
				onBridge.offer(0);
			}
			
			time++;
		}
		
		System.out.print(time);
	}
}

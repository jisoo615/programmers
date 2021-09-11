

import java.util.LinkedList;
import java.util.Queue;
//��� ����
public class createFunction {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		Queue<Integer> q = new LinkedList<>();
		
		int size = progresses.length;
		for(int i=0; i<size; i++) {
			int day = (int) Math.ceil((100.0-progresses[i])/(double)speeds[i]);
			q.add(day);
		}
		
		LinkedList<Integer> list = new LinkedList<>();
		while(!q.isEmpty()) {
			int result = 0;
			int first = q.poll();
			result++;
			
			if(q.isEmpty()) {
				list.add(result);
				break;
			}
			
			while(true) {
				if(first >= q.element()) {//���� ������ �� �ִٸ�
					q.poll();
					result++;
				}else{//�ȵǸ� �������� ������
					list.add(result);
					break;
				}
				
			}
			
		}
		
		int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.poll();
        }
        System.out.print(list.toString());
		
		}

}

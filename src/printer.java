import java.util.LinkedList;

//������ �켱������ ������ �����Ͱ� �����ϸ� ������ �ڷ�.
public class printer {

	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};//������ ���� �켱����
		int location = 0;//���� ����Ʈ�Ǵ��� �˰���� ���� ��ġ 0 ~ priorities.length-1
		
		int answer = 0;
		LinkedList<Integer> q = new LinkedList<>();
		for(int i=0; i<priorities.length; i++) {
			q.add(priorities[i]);
		}
		
		while(location>=0) {
			boolean isHighest = true;
			int first = q.get(0);
			for(int i=1; i<q.size(); i++) {
				if(first < q.get(i)) {//�� �տ����� �� ū��?
					isHighest = false;
					break;
				}
			}
			if(isHighest==true) {
				q.removeFirst();
				answer++;//��������
				if(location==-0) break;//�� ������ ��ġ�� �� ���̸� while����
				location--;//��ġ ������ �����
				
			}else{//isHightest==false;
				int temp = q.removeFirst();
				q.add(temp);
				
				if(location==0) {//�� ū���� �ƴѵ� �� ���̾����� �� �ڷ� ������
					location = q.size()-1;
				}else {//ū ���� �ƴϰ� �� �յ� �ƴϸ�, ��ġ ������ �����
					location--;
				}
				
			}
			
		}
		
		System.out.print(answer);
		
	}
}

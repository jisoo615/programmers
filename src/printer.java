import java.util.LinkedList;

//프린터 우선순위가 먼저인 프린터가 존재하면 무조건 뒤로.
public class printer {

	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};//문서에 따른 우선순위
		int location = 0;//언제 프린트되는지 알고싶은 문서 위치 0 ~ priorities.length-1
		
		int answer = 0;
		LinkedList<Integer> q = new LinkedList<>();
		for(int i=0; i<priorities.length; i++) {
			q.add(priorities[i]);
		}
		
		while(location>=0) {
			boolean isHighest = true;
			int first = q.get(0);
			for(int i=1; i<q.size(); i++) {
				if(first < q.get(i)) {//맨 앞에꺼가 젤 큰가?
					isHighest = false;
					break;
				}
			}
			if(isHighest==true) {
				q.removeFirst();
				answer++;//순서증가
				if(location==-0) break;//젤 높은데 위치가 맨 앞이면 while종료
				location--;//위치 앞으로 당겨짐
				
			}else{//isHightest==false;
				int temp = q.removeFirst();
				q.add(temp);
				
				if(location==0) {//젤 큰수가 아닌데 맨 앞이었으면 맨 뒤로 보내기
					location = q.size()-1;
				}else {//큰 수도 아니고 맨 앞도 아니면, 위치 앞으로 당겨짐
					location--;
				}
				
			}
			
		}
		
		System.out.print(answer);
		
	}
}

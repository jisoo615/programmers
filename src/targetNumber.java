

import java.util.LinkedList;
import java.util.Queue;

public class targetNumber {

	public static void main(String[] args) {
		int answer = 0;
		int[] numbers = {1,1,1,1,1}; int target = 3;
        answer = bfs(numbers, 0, 0, target);
        System.out.print(answer);
        //Math.pow(a, b));//a^b

	}
	
	static public int bfs(int[] numbers, int indx, int sum, int target){
        Queue<Integer> q = new LinkedList<>();
        int result=0;
        q.offer(numbers[indx]);
        q.offer(-1*numbers[indx]);
        indx++;
        while(!q.isEmpty()){
            
            int now = q.poll();
            q.offer(now + numbers[indx]);
            q.offer(now - numbers[indx]);
            
            if(q.size()!=0 && q.size()==Math.pow(2, indx+1)) indx++;
            
            if(indx == numbers.length){
                for(int n : q){ 
                    if(n==target){
                        result+=1;
                     }
                }
                break;
            }
        }
        return result;
	} 

}

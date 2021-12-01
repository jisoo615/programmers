package level2;

public class stockPrice {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		Solution s = new Solution();
		for(int x : s.solution(prices)) System.out.print(x+" ");
		System.out.println();
		for(int x : s.simpleAnswer(prices)) System.out.print(x+" ");
	}

	static class Solution {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        for(int i=0; i<prices.length; i++){
	            for(int j=i+1; j<prices.length; j++){
	                if(prices[i] > prices[j]){//가격이 떨어지는 순간
	                    answer[i] = j -i;
	                    break;
	                }else{//값이 유지, 오르는 경우
	                    answer[i] = prices.length - i -1;
	                }
	            }
	        }
	        return answer;
	    }

	    public int[] simpleAnswer(int[] prices) {
	    	int[] answer = new int[prices.length];
	    	for(int i=0; i<prices.length; i++) {
	    		for(int j=i+1; j<prices.length; j++) {
	    			answer[i]++;
	    			if(prices[i] > prices[j]) break;
	    		}
	    	}
	    	return answer;
	    }
	}

}

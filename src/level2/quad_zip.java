package level2;
//https://programmers.co.kr/learn/courses/30/lessons/68936
//쿼드 압축 후 개수 세기
public class quad_zip {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};

		for(int x : s.solution(arr)) {
			System.out.println(x);
		}
	}

	static class Solution {
		static int one=0, zero=0;

	    public int[] solution(int[][] arr) {
	        int[] answer = new int[2];

	        recur(arr);
	        answer[0] = zero;
	        answer[1] = one;
	        return answer;
	    }

	    public void recur(int[][] arr) {
	    	int len = arr.length;

	    	if(len==1) {
	    		if(arr[0][0]==0) {
	    			zero+=1;
	    			return;
	    		}
	    		else {
	    			one+=1;return;
	    		}
	    	}


	    	boolean allSame = true;
	    	int first = arr[0][0];
	    	for(int i=0; i<len; i++) {
	    		for(int j=0; j<len; j++) {
	    			if(arr[i][j]!=first) {
	    				allSame = false;
	    				break;//다른게 섞여있으면 나감
	    			}
	    		}
	    		if(!allSame) break;
	    	}

	    	if(allSame) {//다 같으면
	    		if(first==0) zero+=1;
	    		else one+=1;
	    		return;
	    	}

	    	//allSame=false
	    	int[][] arr1 = new int[arr.length/2][arr.length/2];
	    	int[][] arr2 = new int[arr.length/2][arr.length/2];
	    	int[][] arr3 = new int[arr.length/2][arr.length/2];
	    	int[][] arr4 = new int[arr.length/2][arr.length/2];
	    	for(int i=0; i<arr.length/2; i++) {
	    		for(int j=0; j<arr.length/2; j++) {
	    			arr1[i][j] = arr[i][j];
	    			arr2[i][j] = arr[i][j+arr.length/2];
	    			arr3[i][j] = arr[i+arr.length/2][j];
	    			arr4[i][j] = arr[i+arr.length/2][j+arr.length/2];
	    			}
	    		}

	    	recur(arr1);
	    	recur(arr2);
	    	recur(arr3);
	    	recur(arr4);

	    }
	}

}

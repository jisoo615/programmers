package level2;
//https://programmers.co.kr/learn/courses/30/lessons/12905
//가장 큰 정사각형 찾기
public class findBiggestRect {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));

	}

	static class Solution{
	    public int solution(int [][]board){
	    	int width = board.length;
	    	int height = board[0].length;
	    	if(height==1 || width==1) {
	    		if(isThereOne(board)) {
	    			return 1;
	    		}
	    	}
	    	int max = 0;
	    	for(int i=1; i<width; i++) {
	    		for(int j=1; j<height; j++) {
	    			if(board[i][j]==1) {
	    				int min = Math.min(board[i-1][j], board[i-1][j-1]);
	    				board[i][j] = Math.min(min, board[i][j-1]) + 1;
	    				max = Math.max(max, board[i][j]);
	    			}
	    		}
	    	}

	        return max*max;
	    }

	    boolean isThereOne(int[][] board) {
	    	for(int i=0; i<board.length; i++) {
	    		for(int j=0; j<board[0].length; j++) {
	    			if(board[i][j]==1) return true;
	    		}
	    	}

	    	return false;
	    }
	}

}

package level2;
//https://programmers.co.kr/learn/courses/30/lessons/86052
//빛의 경로 사이클
import java.util.ArrayList;
import java.util.Collections;

public class light_cycle {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] grid = {"SL","LR"};
		for(int x : s.solution(grid))
		System.out.print(x+" ");

	}

	static class Solution {
		public static boolean[][] arr;
		public static char[][] c;

	    public int[] solution(String[] grid) {
	        //각 칸마다 4방향의 개의 길이 있음 -> 3차원 배열 사용하자
	        //[세로길이][가로길이][4방향]
	        int x = grid.length;
	        int y = grid[0].length();
	        int d = 4;
	        ArrayList<Integer> list = new ArrayList<>();
	        boolean[][][] arr = new boolean[x][y][d];
	        char [][] c = new char[x][y];
	        for(int i=0; i<x; i++) {
	        	for(int j=0; j<y; j++) {
	        		c[i][j] = grid[i].charAt(j);//S L R 을 구분하기 위해(방향)
	        	}
	        }

	        for(int i=0; i<x; i++) {
	        	for(int j=0; j<y; j++) {
	        		for(int k=0; k<d; k++) {
	        			if(!arr[i][j][k]) {
	        				int count = cycle(i, j, k, arr);
	        				if(count>0) list.add(count);
	        			}
	        		}
	        	}
	        }

	        Collections.sort(list);
	        int[] answer = new int[list.size()];
	        for(int i=0; i<list.size(); i++) {
	        	answer[i] = list.get(i);
	        }

	        return answer;
	    }//solution()

	    public int cycle(int x, int y, int d, boolean[][][] arr) {
	    	int count = 0;
	    	int[] x_arr = {0, 0, -1, 1 };
	        int[] y_arr = {1, -1, 0, 0};

	    	while(true) {
	    		if(arr[x][y][d]) {
	    			return count;
	    		}
	    		count++;
	    		arr[x][y][d] = true;

	    		char command = c[x][y];
	    		d = next_d(command, d);

	    	}


		}//cycle()

	    public int next_d(char command, int d) {
	    	if(command=='L') {


	    	}else if(command=='R') {

	    	}
	    	return d;
	    }

	}//class Solution

}

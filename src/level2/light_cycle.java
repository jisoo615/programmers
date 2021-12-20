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
		public static boolean[][][] arr;
		public static char[][] c;

	    public int[] solution(String[] grid) {
	        //각 칸마다 4방향의 개의 길이 있음 -> 3차원 배열 사용하자
	        //[세로길이][가로길이][4방향]
	        int x = grid.length;
	        int y = grid[0].length();
	        int d = 4;
	        ArrayList<Integer> list = new ArrayList<>();
	        arr = new boolean[x][y][d];
	        c = new char[x][y];
	        for(int i=0; i<x; i++) {
	        	for(int j=0; j<y; j++) {
	        		c[i][j] = grid[i].charAt(j);//S L R 을 구분하기 위해(방향)
	        	}
	        }

	        for(int i=0; i<x; i++) {
	        	for(int j=0; j<y; j++) {
	        		for(int k=0; k<d; k++) {
	        			if(!arr[i][j][k]) {
	        				int count = cycle(i, j, k);
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

	    public int cycle(int x, int y, int d) {
	    	int count = 0;
	    	int[] x_arr = {0, 0, -1, 1 };//상 하 좌 우 순서대로임
	        int[] y_arr = {1, -1, 0, 0};

	    	while(true) {
	    		if(arr[x][y][d]) {
	    			return count;
	    		}
	    		count++;
	    		arr[x][y][d] = true;

	    		char command = c[x][y];
	    		d = next_d(command, d);
	    		x += x_arr[d];
	    		y += y_arr[d];

	    		if(x==-1) x = arr.length-1;
	    		else if(x==arr.length) x = 0;
	    		if(y==-1) y = arr[0].length -1;
	    		else if(y==arr[0].length) y = 0;

	    	}


		}//cycle()

	    public int next_d(char command, int d) {
	    	if(command=='L') {
	    		if(d==0) {//상에서 들어오면 오른쪽
	    			d = 3;
	    		}else if(d==1) {//하에서 들어오면 왼쪽
	    			d = 2;
	    		}else if(d==2) {//좌에서 들어오면 상으로
	    			d = 0;
	    		}else if(d==3) {//우에서 들어오면 하로
	    			d = 1;
	    		}

	    	}else if(command=='R') {
	    		if(d==0) {//상에서 들어오면 왼쪽
	    			d = 2;
	    		}else if(d==1) {//하에서 들어오면 오른쪽
	    			d = 3;
	    		}else if(d==2) {//좌에서 들어오면 하로
	    			d = 1;
	    		}else if(d==3) {//우에서 들어오면 상으로
	    			d = 0;
	    		}
	    	}
	    	return d;
	    }//next_d()

	}//class Solution

}

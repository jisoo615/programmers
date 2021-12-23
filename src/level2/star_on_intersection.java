package level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

//https://programmers.co.kr/learn/courses/30/lessons/87377
//교점에 별만들기
public class star_on_intersection {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		for(String str : s.solution(line)) System.out.println(str);
	}

	static class Solution {
		static HashSet<int[]> set;
		static int x_max, x_min, y_max, y_min;

	    public String[] solution(int[][] line) {
	        String[] answer;
	        x_max=y_max=Integer.MIN_VALUE;
	        x_min=y_min=Integer.MAX_VALUE;

	        set = new HashSet<>();
	        for(int i=0; i<line.length; i++) {
	        	for(int j=i+1; j<line.length; j++) {
	        		isParallel(line[i], line[j]);
	        	}
	        }
	        int height = y_max-y_min+1;
	        int width = x_max-x_min+1;

	        answer = new String[height];
	        String str = ".".repeat(width);
	        Arrays.fill(answer, str);

	        Iterator<int[]> iter = set.iterator();
	        while(iter.hasNext()) {
	        	int[] p = iter.next();
	        	int py = y_max - p[1];
	        	int px = p[0] - x_min;
	        	answer[py] = answer[py].substring(0, px) +"*" +answer[py].substring(px+1);
	        }

	        return answer;
	    }

	    public void isParallel(int[] abe, int[] cdf) {
	    	long a = abe[0], b = abe[1], e = abe[2];
	    	long c = cdf[0], d = cdf[1], f = cdf[2];

	    	long ad_bc = a*d - b*c;
	    	if(ad_bc == 0) { //ad-bc=0 이면 두 직선은 평행 또는 일치
	    		return;
	    	}else {
	    		long bf_ed = b*f - e*d;
	    		long ec_af = e*c - a*f;
	    		if(bf_ed % ad_bc==0 && ec_af % ad_bc==0){//bf-ed / ad-bc  //ec-af / ad-bc
	    			int x = (int) (bf_ed / ad_bc);
	    			int y = (int) (ec_af / ad_bc);

	    			if(x_max<x) x_max = x;
		    		if(x_min>x) x_min = x;
		    		if(y_max<y) y_max = y;
		    		if(y_min>y) y_min = y;

		    		int[] intersection = {x, y};
		    		set.add(intersection);//정수로만 표현되는 좌표만 넣어야함
	    		}
	    	}
	    }
	}
}

package kako;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class kakao_2022_blind_archeryCompetition {
public static LinkedList<int[]> list;
	public static void main(String[] args){
		Solution s = new Solution();
		int n=1;
		int[] info = {1,0,0,0,0,0,0,0,0,0,0};
		System.out.println(Arrays.toString(s.solution(n, info)));

		/*---연습-------
		list = new LinkedList<>();
		prac(new int[3], 0);
		for(int[] li :list)System.out.println(Arrays.toString(li));
		*/
	}

	static class Solution {//어피치가(내차례) 최대한 많은 "점수 차"(경기마다 라이언점수가달라짐)로 이기도록해라, 비기거나 지면 -1
		public static LinkedList<int[]> list;
		public static int max = 0;
	    public int[] solution(int n, int[] info) {
	        // info : 10-i점 -> 10 9 8 ...을 맞힌 갯수
	        brute(new int[11], 0, n, info);
	        //어피치가 하는 경기에 따라 라이언의 점수도 달라지는 거임 -> 이겼을때의 어피치점수와 배열을 저장해야함.
	        //이겼을때가 empty면 -1리턴하자
	        if(list == null) return new int[] {-1};

	        Collections.sort(list, (arr1, arr2)->{
	        	if(arr1[10]==arr2[10]) {
	        		for(int i=9; i>0; i--) {
	        		if(arr1[i]==arr2[i]) continue;
	        		return arr1[i]-arr2[i];
	        		}
	        	}
	        	return arr1[10]-arr2[10];
	        });

	        return list.getLast();
	    }

	    public void brute(int[] arr, int index, int shots, int[] info) {//shots:화살남은횟수
	    	if(index==arr.length || shots==0) {
	    		int lScore = 0, aScore =0;
	    		for(int i=0; i<arr.length; i++) {
	    			if(info[i]==0&&arr[i]==0) continue;
	    			if(info[i] <= arr[i]) {
	    				aScore += (10-i);
	    			}else{
	    				lScore += (10-i);
	    			}
	    		}
	    		if(aScore-lScore > 0) {
	    			if(max < aScore-lScore) {
	    				list = new LinkedList<>();//새로 만들기
	    				list.add(arr.clone());
	    				max = aScore-lScore;
	    			}else if(max==aScore-lScore) {//기존애 추가
	    				list.add(arr.clone());
	    			}
	    		}
	    		return;
	    	}
	    	//조합 구현 재귀
	    	if(index==10) {//0점일 경우앤 나머지 샷을 넣음
	    		arr[index]=shots;
	    		brute(arr, index+1, 0, info);
	    		arr[index]=0;
	    	}
	    	else {
	    		if(info[index]<shots) {//어피치가 쏠수 있었을때
		    		arr[index] = info[index]+1;//어피치가 쏜경우
		    		//System.out.println("brute("+Arrays.toString(arr)+", "+(index+1)+", "+(shots-arr[index])+")");
		    		brute(arr, index+1, shots-arr[index], info);
	    		}
	    		arr[index] = 0;//어피치가 어쨋든 안쏜경우
		    	//System.out.println("brute("+Arrays.toString(arr)+", "+(index+1)+", "+shots+")");
			    brute(arr, index+1, shots, info);
	    	}

	    }
	}

	static void prac(int[] a, int index) {//000 100 010 110 111 ..
		if(index==a.length) {
			list.add(a);
			return;
		}
		int[] a1 = a;
		int[] a2 = a.clone();
		//a1[index] = 0;
		a2[index] = 1;
		prac(a1, index+1);
		prac(a2, index+1);

	  }
}

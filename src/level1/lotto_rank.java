package level1;

import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/77484
public class lotto_rank {

	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};//기댓값 {3, 5}
		int wrong = 0;
		int dontKnow = 0;
		HashSet<Integer> set = new HashSet<>();
        for(int num : win_nums) set.add(num);
        for(int myNum : lottos) {
        	if(myNum == 0) {//모르는 숫자일때
        		dontKnow +=1;
        	}
        	else if( !set.contains(myNum) ) {//틀리면
        		wrong += 1;
        	}
        }
        int max=0, min=0;
        if(dontKnow + wrong == 6) {
        	min = 6;
        	max = (wrong==6 ? wrong : 1 + wrong);
        }
        else {
        	min = 1 + dontKnow + wrong;
        	max = 1 + wrong;
        }

        //int[] answer = {max, min};

       System.out.print(max+" "+min);

	}

}

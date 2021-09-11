

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class moigosa {
//모의고사
	public static void main(String[] args) {
		int[] answers = {1, 2, 3, 4, 5};
		int[] answer;      
        int std1[] = {1, 2, 3, 4, 5};
        int std2[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int std3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1=0, cnt2=0, cnt3=0;
        for(int i=0; i<answers.length; i++){
            int indx_1 = i%5;
            int indx_2 = i%8;
            int indx_3 = i%10;

            int jungdap = answers[i];
            if( std1[indx_1] == jungdap) cnt1++;
            if( std2[indx_2] == jungdap) cnt2++;
            if( std3[indx_3] == jungdap) cnt3++;
        }
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[] {1, cnt1});
        list.add(new int[] {2, cnt2});
        list.add(new int[] {3, cnt3});
        Collections.sort(list, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
        });
        
        int max = list.get(0)[1];
        if(max==list.get(1)[1] && max!=list.get(2)[1]) {
        	answer = new int[2];
        }else if(max==list.get(1)[1] && max==list.get(2)[1]) {
        	answer = new int[3];
        }else {
        	answer = new int[1];
        }
        
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i)[0];
        }
        
		for(int a : answer) {
			System.out.print(a);
		}
	}

}

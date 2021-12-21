package level3;
//https://programmers.co.kr/learn/courses/30/lessons/42895
//N으로 표현
import java.util.ArrayList;
import java.util.HashSet;

public class expression_with_onlyN {

	public static void main(String[] args) {
		Solution s = new Solution();
		int N = 5;
		int number = 12;
		System.out.print(s.solution(N, number));

	}
	static class Solution {
	    public int solution(int N, int number) {
	        ArrayList<HashSet<Integer>> list = new ArrayList<>();
	        String nnn = ""+ N;// 5 55 555 555 이런식의 숫자 만드는 용도

	        if(N==number) return 1;

	        HashSet<Integer> set = new HashSet<>();
	        list.add(set);//인덱스 0안써서 빈set채우는 용도
	        set.add(N);
	        list.add(set);

	        for(int i=2; i<=8; i++) {
	        	nnn += N;
	        	set = new HashSet<Integer>();
	        	set.add(Integer.parseInt(nnn));

	        	int index1 = 1;
	        	int index2 = i-1;
	        	while(index1<i && index2>0) {// n이5개 = n이1개 + n이4개 = 2개+3개 = 3개+2개 = 4개+1개
	        		ArrayList<Integer> list1 = new ArrayList<>(list.get(index1));//n이 index1개 일때의 집합을 arrayList로 생성
	        		ArrayList<Integer> list2 = new ArrayList<>(list.get(index2));

	        		for(int j=0; j<list1.size(); j++) {
	        			int num1 = list1.get(j);

	        			for(int k=0; k<list2.size(); k++) {
	        				int num2 = list2.get(k);

	        				if(num1+num2 > 0) {
	        					set.add(num1+num2);
	        				}
	        				if(num1-num2 > 0) {
	        					set.add(num1-num2);
	        				}
	        				if(num1*num2 > 0) {
	        					set.add(num1*num2);
	        				}
	        				if(num1/num2 > 0) {
	        					set.add(num1/num2);
	        				}

	        			}//for k
	        		}//for j

	        		index1++;
	        		index2--;
	        	}//while end

	        	if(set.contains(number)) return i;
	        	else {
	        		list.add(set);
	        	}


	        }//for i


	        return -1;
	    }
	}

}

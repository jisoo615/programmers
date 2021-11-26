package kako;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class kakao_2019_blind_CandidateKey {

	public static void main(String[] args) {
		String[][] relation= {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		System.out.print(solution(relation));

	}
	public static LinkedList<String> list;
	static public int solution(String[][] relation) {
		//최소성 : 두개이상의 속성이 후보키가 될때, 속성을 하나 제거하고서도 유일성을 만족하면 후보키가 될수없다.
        //1. 속성들로 만들 수 있는 모든 후보키의 경우의수를 구한다.
		//2. 모든 경우의 수 중 유일성을 만족하는 경우만 list에 저장한다.
		list = new LinkedList<>();
        cases(relation[0].length, relation);

        //3. 이후 최소성을 만족하도록 최소개수의후보키를 포함한 모든 키들을 제거함.
        Collections.sort(list, (str1, str2)->{
        	int cnt1=0, cnt2 =0;
        	for(int ii=0; ii<str1.length(); ii++) {
        		if(str1.charAt(ii)=='1') cnt1++;
        		if(str2.charAt(ii)=='1') cnt2++;
        	}
        	return cnt1-cnt2;
        });

        /*
         * 최소성 만족시키기
         */

        return 0;
    }

	static public void cases(int attribute, String[][] relation) {//모든 경우의 수를 2진수로 나타내자 (속성갯수길이만큼)
		int num=1, n=0;
		int max = (int) Math.pow(2, attribute);
		StringBuilder sb = new StringBuilder();
		while(num<max) {
			sb = new StringBuilder();
			n = num;
			while(n>1) {
				sb.append(Integer.toString(n%2));
				n/=2;
			}
			if(n==1)sb.append("1");
			else sb.append("0");

			String str = "0".repeat(attribute-sb.length());
			sb.append(str);
			sb.reverse();
			if(isUnique(sb.toString(), relation)){
				list.add(sb.toString());
				System.out.println(sb.toString());
			}

			num++;
		}
	}

	static public boolean isUnique(String str, String[][] relation) {
		HashSet<String> set = new HashSet<>();
		StringBuilder sb;
		for(int i=0; i<relation.length; i++) {
			sb = new StringBuilder();

			for(int k=0; k<str.length(); k++) {
				if(str.charAt(k)=='1') sb.append(relation[i][k]);
			}

			if(set.contains(sb.toString())) return false;
			set.add(sb.toString());
		}

		return true;
	}

}

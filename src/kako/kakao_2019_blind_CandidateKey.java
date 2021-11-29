package kako;

import java.util.ArrayList;
import java.util.HashSet;

public class kakao_2019_blind_CandidateKey {

	public static void main(String[] args) {
		//String[][] relation= {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		String[][] relation = { {"a","1","aaa","c","ng"},
								{"a","1","bbb","e","g"},
								{"c","1","aaa","d","ng"},
								{"d","2","bbb","d","ng"}};
		System.out.print(solution(relation));

	}
	public static ArrayList<Integer> list;
	static public int solution(String[][] relation) {
		//최소성 : 두개이상의 속성이 후보키가 될때, 속성을 하나 제거하고서도 유일성을 만족하면 후보키가 될수없다.
        //1. 속성들로 만들 수 있는 모든 후보키의 경우의수 들 중(1 ~ 2^속성)
		//2. 유일성을 먼저 검사하기 (2진수인 String으로 변환해 isUique에 넘겨주기)
		int colsize = relation[0].length;
		list = new ArrayList<>();
		int whole = (int)Math.pow(2, colsize);
		for(int n=1; n<whole; n++) {
			String str = binary(n, colsize);
			if(isUnique(str, relation)) {
				list.add(n);//유일성 만족하는 것만 add함
			}
		}

       //3. 최소성만족(부분집합이 없는) 하도록 비트여산을 이요해 알아낸다.

		for(int i=0; i<list.size(); i++){//지울 대상들
			for(int j=i+1; j<list.size(); j++) {
				if((list.get(i) & list.get(j))==list.get(i)) {
					list.remove(j);
					j--;
				}
			}
		}

        return list.size();
    }

	static public String binary(int n, int colsize) {//받은 수를 2진수로 나타내자 (속성갯수길이만큼)

		StringBuilder sb = new StringBuilder();
		sb = new StringBuilder();
		while(n>1) {
			sb.append(Integer.toString(n%2));
			n/=2;
		}
		if(n==1)sb.append("1");
		else sb.append("0");

		String str = "0".repeat(colsize-sb.length());
		sb.append(str);
		return sb.reverse().toString();
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

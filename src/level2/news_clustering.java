package level2;

import java.util.LinkedList;

//https://programmers.co.kr/learn/courses/30/lessons/17677
//카카오 2018 블라인드 테스트
//뉴스 클러스터링-난이도 중
public class news_clustering {
	public static void main(String[] args) {
		String str1="aa1+aa2";
		String str2="AAAA12";
		System.out.print(solution(str1,str2));
	}

	static public int solution(String str1, String str2) {
		/*
		 * A교B / A합B = A 교 B / A+B - A교B
		 * 여기선 중복을 허용하며, 조합중 숫자,공백,특수문자가 들어가 ㄹ경우 제외한다.
		 */
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();//toUpperCase메소드는 문자열을 반환하기에 자기자신에 다시 대입해줘야함
		LinkedList<String> list1 = johap(str1);
		LinkedList<String> list2 = johap(str2);

		double union = list1.size() + list2.size();//둘을 합친것 A+B
		double inter = 0;//A와 B의 공통점만
		for(int i=0; i<list1.size(); i++) {
			int index = list2.indexOf(list1.get(i));//list1에 있는 원소가 list2중 어느 인덱스에 있는지
													//존재하지 않으면 -1 반환
			if(index==-1) continue;
			//list1은 기준이 되는 거고 0부터 차례로 이동하기 때문에 삭제하지 않아도 된다.
			list2.remove(index);
			inter += 1;
		}

		if(inter==0 && union==0) return 65536;//A와 B가 둘다 공집합이라면 65536을 리턴한다.
		return (int)(inter/(union-inter)*65536);
	}

	static LinkedList<String> johap(String str) {
		LinkedList<String> list = new LinkedList<>();
		StringBuilder sb;
		for(int i=0; i<str.length()-1; i++) {
			sb = new StringBuilder();
			char c1 = str.charAt(i); char c2 = str.charAt(i+1);
			if(c1>='A' && c1<='Z' && c2>='A' && c2<='Z') {
				sb.append(c1); sb.append(c2);
				list.add(sb.toString());
			}
		}
		return list;
	}
}
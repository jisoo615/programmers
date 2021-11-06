package skill_check;

import java.util.LinkedList;

public class Level2_2 {

	public static void main(String[] args) {
		solution_2("{{2,1},{2},{2,1,3,4},{2,1,3}}");

	}

	static public int[] solution_2(String s) {
		LinkedList<String> list = new LinkedList<>();
		String temp ="";
		boolean isNew = true;
		s = s.replace(",", "");
		for(int i=0; i<s.length()-1; i++) {//맨 마지막 }는 검사안도록
			if(s.charAt(i)=='{') {
				temp="";
			}
			else if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9){
				temp += s.charAt(i);
			}
			else if(s.charAt(i)=='}') {
				list.add(temp);
			}
		}

		list.sort((o1, o2)->{
			return o1.length() - o2.length();
		});
		for(String k:list) System.out.println(k);

		StringBuilder sb = new StringBuilder();
		while(list.size()>0) {

		}

		return new int[] {};
	}

}

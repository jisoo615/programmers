package dev_matching_2021_fw;

import java.util.HashSet;

public class p1 {

	public static void main(String[] args) {
		String[] registered_list = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
		String new_id = "ace17";
		System.out.print(solution(registered_list, new_id));

	}

	public static String solution(String[] registered_list, String new_id) {
		String answer = "";
		HashSet<String> set = new HashSet<>();
		for(String s : registered_list) set.add(s);
		while(true) {
			if(set.contains(new_id)) {
				char[] charr = new_id.toCharArray();
				String s = ""; String N = ""; int n=0;
				for(int i=0; i<charr.length; i++) {
					if(charr[i]>=65) {
						s += charr[i];
						continue;
					}
					else {
						N = new_id.substring(i);
						n = Integer.parseInt(N);
						break;
					}
				}

				n+=1;
				new_id = s+Integer.toString(n);
			}
			else {
				return answer = new_id;
			}
		}
	}

}

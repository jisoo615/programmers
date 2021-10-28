package level2;

import java.util.HashMap;
import java.util.Iterator;

//https://programmers.co.kr/learn/courses/30/lessons/17677
//카카오 2018 블라인드 테스트
//뉴스 클러스터링
public class news_clustering {
	public static HashMap<String, Integer> map;

	public static void main(String[] args) {
		String str1="aa1+aa2";
		String str2="AAAA12";
		System.out.print(solution(str1,str2));
	}

	static public int solution(String str1, String str2) {
		str1 = trime(str1);
		System.out.println(str1);
		str2 = trime(str2);
		System.out.println(str2);

		map = new HashMap<>();
		jibhap(str1); jibhap(str2);
		Iterator<String> iter = map.keySet().iterator();
		int common = 0;
		while(iter.hasNext()) {
			int value = map.get(iter.next());
			if(value>1) {
				common += 1;
			}
		}
		double answer = (common/(double)map.size())*65536.0;
		return (int)answer;
	}

	static public void jibhap(String str) {

		for(int i=0; i<str.length()-1; i++) {
			String temp = str.substring(i, i+2);
			if(!map.containsKey(temp)) {
				map.put(temp, 1);
			}else map.put(temp, map.get(temp)+1);
		}
	}

	static public String trime(String str) {
		str.trim();
		str = str.toUpperCase();
		String temp="";
		for(char c : str.toCharArray()) {
			if(c>=65 && c<=90) temp += c;
		}
		return temp;
	}

}

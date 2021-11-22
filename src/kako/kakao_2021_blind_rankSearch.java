package kako;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

//https://programmers.co.kr/learn/courses/30/lessons/72412
//카카오 블라인드 2021 순위검색
public class kakao_2021_blind_rankSearch {
	static public HashMap<String, LinkedList<Integer>> map = new HashMap<>();

	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210",
				"python frontend senior chicken 150","cpp backend senior pizza 260",
				"java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"};

		for(int x : solution(info, query)) {
			System.out.print(x+" ");
		}

	}

	static public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        //해시테이블에 ㅑ info에서 -를 넣은 모든 경우의 수를 key값으로 저장하고, value를 점수로 저장.
        //value 는 integer형의 리스트여야 한다. 같은 키값이 존재할 수 있기에
        boolean[] visited = new boolean[4];
        for(String str : info) {
        	Arrays.fill(visited, false);
        	StringBuilder sb = new StringBuilder();
    	    combi(str.split(" "), sb, 0);
       }

        for(int i=0; i<query.length; i++) {
        	int score = Integer.parseInt(query[i].replaceAll("[a-z-]+", "").strip());
        	String condition = query[i].replace("and", "").replaceAll("[0-9\\s]+", "");
    		// 정규식에서 공백은 \\s 로 표현됨
        	if(map.containsKey(condition)) {//찾는 조건이 있다면
        		LinkedList<Integer> scores = map.get(condition);
        		answer[i] = binarySearch(score, scores);
        	}
        }

        return answer;
    }

	static public void combi(String[] arr, StringBuilder sb, int index) {//dfs 조건 4개 점수 1개
		if(index==4) {//모든 항목 확인했으면
			if(map.containsKey(sb.toString())) {
				LinkedList<Integer> list = map.get(sb.toString());
				list.add(Integer.parseInt(arr[4]));
				Collections.sort(list);
				map.put(sb.toString(), list);
			}else {
				LinkedList<Integer> list = new LinkedList<Integer>();
				list.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), list);
			}

		}else {
			StringBuilder sb2 = new StringBuilder(sb);
			sb2.append("-");
			combi(arr, sb2, index+1);
			sb2 = new StringBuilder(sb);
			sb2.append(arr[index]);
			combi(arr, sb2, index+1);
		}
	}

	public static int binarySearch(int score, LinkedList<Integer> list) {//score 이상인 개수를 반환
		int left = 0; int right = list.size();
		while(left<right) {
			int mid = (left+right)/2;
			if(list.get(mid)>=score) right = mid;//찾는 수보다 크면 mid포함해서 다시 검색
			else left = mid+1;//보다 작으면 mid보다 하나 키워서 다시 검색//lower bound
		}
		return list.size()-right;//존재하지 않는다면 0명 반환
	}
}

package level3;
//https://programmers.co.kr/learn/courses/30/lessons/42579
//베스트 앨범
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class best_album {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] genres= {"classic", "pop", "classic", "classic", "pop"};
		int[] plays= {500, 600, 150, 800, 2500};
		for(int x : s.solution(genres, plays))System.out.println(x);

	}

	static class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	        int[] answer;
	        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
	        for(int i=0; i<genres.length; i++) {
	        	if(!map.containsKey(genres[i])) {
	        		ArrayList<Integer> list = new ArrayList<>();
	        		list.add(plays[i]);//맨처음은 장르별 총 플레이수
	        		list.add(i);
	        		map.put(genres[i], list);
	        	}else {
	        		ArrayList<Integer> list = map.get(genres[i]);
	        		int total = list.get(0)+plays[i];
	        		list.remove(0); list.add(0, total);
	        		list.add(i);
	        		map.put(genres[i], list);
	        	}
	        }

	        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	        for(String genre : map.keySet()) {
	        	ArrayList<Integer> temp = map.get(genre);
	        	result.add(temp);
	        }
	        Collections.sort(result, (list1, list2)->{//장르 내림차순
	        	return list2.get(0) - list1.get(0);
	        });
	        for(int i=0; i<result.size(); i++) {
	        	result.get(i).remove(0);
	        	Collections.sort(result.get(i), (o1, o2)->{
	        		return plays[o2]-plays[o1];
	        	});
	        }


	        ArrayList<Integer> answer_list = new ArrayList<>();
	        for(ArrayList<Integer> list : result) {
	        	int max = list.size()==1? 1:2;
	        	for(int i=0; i<max; i++) {
	        		answer_list.add(list.get(i));
	        	}
	        }

	        answer = new int[answer_list.size()];
	        for(int i=0; i<answer.length; i++) {
	        	answer[i] = answer_list.get(i);
	        }

	        return answer;
	    }
	}

}

package level2;
//https://programmers.co.kr/learn/courses/30/lessons/49993
//스킬트리
import java.util.HashSet;

public class skillTree {

	public static void main(String[] args) {
		Solution s = new Solution();
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.print(s.solution(skill, skill_trees));

	}

	static class Solution {
	    public int solution(String skill, String[] skill_trees) {
	    	int answer = 0;
	    	HashSet<Character> set = new HashSet<>();
	    	for(char c : skill.toCharArray()) {
	    		set.add(c);
	    	}

	    	for(String skill_tree : skill_trees) {
	    		int skill_idx = 0;
	    		boolean flag = true;
	    		for(int i=0; i<skill_tree.length(); i++) {
	    			if(set.contains(skill_tree.charAt(i))) {
	    				if(skill_tree.charAt(i)!=skill.charAt(skill_idx)) {
	    					flag = false;
	    					break;
	    				}else {
	    					skill_idx++;
	    				}
	    			}
	    		}
	    		if(flag) answer++;
	    	}


	    	return answer;
	    }

	}

}

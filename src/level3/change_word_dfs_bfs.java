package level3;

public class change_word_dfs_bfs {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("hit", "cog",
				new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));

	}

	static class Solution {
		public static int answer=Integer.MAX_VALUE;
	    public int solution(String begin, String target, String[] words) {

	        for(int i=0; i<words.length; i++) {
	        	boolean[] visited = new boolean[words.length];
	        	if(isDifferentOnlyOne(begin, words[i])) {//하나만 다를때
	        		visited[i]=true;
	        		dfs(words[i], words, visited, target, 1);
	        	}
	        }
	        if(answer==Integer.MAX_VALUE)return 0;
	        return answer;
	    }

	    void dfs(String word, String[] words, boolean[] visited, String target, int cnt) {
	    	if(word.equals(target)) {
	    		answer = Math.min(answer, cnt);
	    	}

	    	for(int i=0; i<words.length; i++) {
	    		if(!visited[i] && isDifferentOnlyOne(word, words[i])) {
	    			visited[i] = true;
	    			dfs(words[i], words, visited, target, cnt+1);
	    			visited[i] = false;
	    		}
	    	}
	    	return;
	    }

	    boolean isDifferentOnlyOne(String str1, String str2) {//1글자이상 다르면 false
	    	int cnt=0;
	    	for(int i=0; i<str1.length(); i++) {
	    		if(str1.charAt(i)!=str2.charAt(i)) {
	    			cnt++;
	    			if(cnt>1) return false;
	    		}
	    	}
	    	return true;
	    }

	}

}

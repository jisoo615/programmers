package kako;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

//https://programmers.co.kr/learn/courses/30/lessons/17679
//프렌즈 4블록
public class kakao_2018_1st_blind_friends4blocks {

	public static void main(String[] args) {
		Solution s = new Solution();
		int m = 4;
		int n = 5;
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.print(s.solution(m, n, board));

	}

	static class Solution {
		public static char[][] blocks;

	    public int solution(int m, int n, String[] board) {
	        int answer = 0;
	        blocks = new char[m][n];
	        for(int i=0; i<m; i++) {
	        	blocks[i] = board[i].toCharArray();
	        }
	        //모든 블록에서 오른쪽, 아래, 오른쪽아래(대각선)이 같은 블록인지 확인하면 됨
	        while(true) {
	        	HashSet<int[]> set = new HashSet<>();
	        	for(int i=0; i<m-1; i++) {
	        		for(int j=0; j<n-1; j++) {
	        			if(blocks[i][j]!=' ') {
	        				removeSameBlocks(i, j, set);
	        			}
	        		}
	        	}

	        	if(set.isEmpty()) {
	        		break;
	        	}else {
	        		Iterator<int[]> iter = set.iterator();
	        		while(iter.hasNext()) {//2*2 블록 지우고
	        			int[] p = iter.next();
	        			if(blocks[p[0]][p[1]]!=' ') {//set이 배열타입은 중복걸러내지 못하니 이미 공백일때는 제외하고 세어주면 됨
	        				blocks[p[0]][p[1]] = ' ';
	        				answer++;
	        			}

	        		}
	        		fillBlanks();//빈공간 내려 채우기
	        	}
	        }

	        return answer;
	    }

	    void removeSameBlocks(int x, int y, HashSet<int[]> set) {

	    	char standard = blocks[x][y];
	    	char point1 = blocks[x][y+1];
	    	char point2 = blocks[x+1][y];
	    	char point3 = blocks[x+1][y+1];

	    	if(standard==' '||point1==' '||point2==' '||point3==' ') return;

	    	if(standard==point1&&point1==point2&&point2==point3) {
				set.add(new int[] {x,y});
				set.add(new int[] {x, y+1});
				set.add(new int[] {x+1, y});
				set.add(new int[] {x+1, y+1});
	    	}
	    }

	    void fillBlanks() {
	    	//blocks
	    	for(int j=0; j<blocks[0].length; j++) {
	    		LinkedList<Character> list = new LinkedList<>();
	    		for(int i=0; i<blocks.length; i++) {
	    			if(blocks[i][j]!=' ') {
	    				list.add(blocks[i][j]);//위에서부터 가져옴
	    			}
	    		}

	    		for(int k=blocks.length-1; k>=0; k--) {//밑에서부터 채우기
	    			if(list.size()>0) {
	    				blocks[k][j] = list.pollLast();
	    			}else {
	    				blocks[k][j] = ' ';
	    			}

	    		}
	    	}

	    }

	}

}

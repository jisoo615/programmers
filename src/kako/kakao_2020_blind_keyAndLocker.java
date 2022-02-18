package kako;

//https://programmers.co.kr/learn/courses/30/lessons/60059
//키와 열쇠 카카오 2020 blind
class kakao_2020_blind_keyAndLocker {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] key = {{0, 0, 0},{1, 0, 0},{0, 1, 1}};
		int[][] lock = {{1, 1, 1},{1, 1, 0},{1, 0, 1}};
		System.out.println(String.valueOf(s.solution(key, lock)));

	}

	static class Solution {
	    public boolean solution(int[][] key, int[][] lock) {
	        //key 의 1 부분이 lock의 0부분과 맞아떨어져야함
    /*key를 네방향으로 돌려보기
     * key가 lock 바깥에 나와도 되기때문에 key가 움직일 범위 넓히기 위해 key space 확장: lock+key*2 크기
     * key_space에서 key가 막 돌아다니면, 가운데 n*n부분이 lock에 들어맞는가 확인해보면 된다.
     * */
	        int m=key.length; int n=lock.length;
	        int[][] key_space = new int[2*m+n][2*m+n];

	        for(int t=0; t<4; t++) {//방향돌리기

	        	for(int i=0; i<m+n; i++) {
	        		for(int j=0; j<m+n; j++) {

	        			for(int x=m; x<m+n; x++) {
	        				for(int y=m; y<m+n; y++) {
	        					key_space[x][y] = 0; // lock과 결합될 부분 초기화
	        				}
	        			}//초기화 끝내고
	        			// key key_space내에서 움직이기
	        			for(int x=i; x<i+m; x++) {
	        				for(int y=j; y<j+m; y++) {
	        					key_space[x][y] = key[x-i][y-j];
	        				}
	        			}
	        			int[][] resultKey = new int[n][n];//필요한 부분만 잘라서 보내주기 위해
	        			for(int x=m; x<m+n; x++) {
	        				for(int y=m; y<m+n; y++) {
	        					resultKey[x-m][y-m] = key_space[x][y];
	        				}
	        			}
	        			if(fitCheck(resultKey, lock)) return true;
	        		}
	        	}

	        	key = rotate90(key_space, key, lock);
	        }
	        return false;
	    }

	    int[][] rotate90(int[][] key_space, int[][] key, int[][] lock) {//n*n
	    	int m = key.length;
	    	int[][] key_temp = new int[m][m];

	    	for(int i=0; i<m; i++) {
	    		for(int j=0; j<m; j++) {
	    			key_temp[i][j] = key[m-1-j][i];
	    		}
	    	}
	    	return key_temp;
	    }

	    boolean fitCheck(int[][] resultKey, int[][] lock) {
	    	for(int i=0; i<lock.length; i++) {
	    		for(int j=0; j<lock.length; j++) {
	    			if(resultKey[i][j]!=lock[i][j]) continue;
	    			else return false;
	    		}
	    	}
	    	return true;
	    }
	}

}

package level2;

//https://programmers.co.kr/learn/courses/30/lessons/12924
//숫자의 표현  -슬라이딩 윈도우
public class Expression_of_digit {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(15));
	}

	static class Solution {

	    public int solution(int n) {//-슬라이딩 윈도우
	    	int answer=1;
	    	if(n<3) return answer;
	    	//3~
	    	int sum=1;
	    	int left=1; int right=2; //더할때는 right를 증가시키며 더하고, 뺄때는 left를 증가시키며 빼기

	    	while(right<n) {
	    		if(sum>n) {//sum을 줄여야됨
	    			sum-=left;
	    			left++;
	    		}else if(sum<n) {//sum을 늘리자
	    			sum+=right;
	    			right++;
	    		}

	    		if(sum==n) {
	    			answer++;
	    			sum-=left;
	    			left++;
	    		}
	    	}

	        return answer;
	    }
	}

}

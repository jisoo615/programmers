package level2;
//https://programmers.co.kr/learn/courses/30/lessons/12953
// a*b = 최소공배수*최대공약수 = lcm * gcd // 즉 lcm = a*b/gcd;
import java.util.Arrays;

public class N_lcm {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {2,6,8,14};
		System.out.println(s.solution(arr));

	}

	static class Solution {
	    public int solution(int[] arr) {
	        Arrays.sort(arr);
	        int temp = lcm(arr[1], arr[0]);
	        int answer=0;
	        for(int i=2; i<arr.length; i++){
	            answer = lcm(temp, arr[i]);
	            temp = answer;
	            System.out.println(answer);
	        }
	        return answer;
	    }

	    int gcd(int n1, int n2){ //n1>n2
	    	if(n1%n2==0) return n2;
	    	return gcd(n2, n1%n2);
	    }
	    int lcm(int n1, int n2) {
	    	return (n1*n2)/gcd(n1, n2);
	    }
	}

}

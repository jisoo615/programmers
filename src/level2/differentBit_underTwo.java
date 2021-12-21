package level2;
//https://programmers.co.kr/learn/courses/30/lessons/77885
//2개 이하로 다른 비트
public class differentBit_underTwo {

	public static void main(String[] args) {
		Solution s = new Solution();
		long[] numbers = {2, 7};
		for(long x : s.solution(numbers))	System.out.print(x+" ");
	}

	static class Solution {
	    public long[] solution(long[] numbers) {
	        long[] answer = new long[numbers.length];

	        for(int i=0; i<numbers.length; i++) {
	        	if(numbers[i] %2==0) {
	        		//짝수면 홀수로 만들어주면됨
	        		answer[i] = numbers[i]+1;
	        		continue;
	        	}else {//홀수일때
	        		String binary = Long.toBinaryString(numbers[i]);
	        		StringBuilder sb = new StringBuilder(binary);

	        		if(sb.indexOf("0")==-1) {//모두 1일때, 111 -> 1011 로 바꾸기. 기존젤큰 자리수를 한번 더하는것
	        			answer[i] = (long) (numbers[i] + Math.pow(2, binary.length()-1));
	        			continue;
	        		}

	        		else{//중간에 0이 들어갈때
	        			int index = sb.lastIndexOf("0");
	        			sb.setCharAt(index, '1');
	        			sb.setCharAt(index+1, '0');
	        			answer[i] = Long.parseLong(sb.toString(), 2);
	        			continue;
	        		}

	        	}
	        }

	        return answer;
	    }
	}

}

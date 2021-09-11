

import java.util.LinkedList;

//소수찾기
public class findDecimal {
	static LinkedList<Integer> list = new LinkedList<>();
	static boolean visited[];
	
	public static void main(String[] args) {
		String numbers = "17";
		visited = new boolean[numbers.length()];
		
		for(int i=1; i<=numbers.length(); i++) {
			dfs(numbers, "", i);//n배열들의 숫자로 i자릿 수자를 만들어라.
		}
		
		int answer =0;
		for(Integer x : list) {
			if(isPrime(x)) {
				answer +=1;
			}
		}
		System.out.print(answer);
		
	}
	
	static void dfs(String numbers, String newNum, int dept) {
				
		if(newNum.length() == dept) {
			int num = Integer.parseInt(newNum);
			if(!list.contains(num)) list.add(num);
			return;
		}
		else {
			for(int i=0; i<numbers.length(); i++) {
				if( !visited[i]) {
				visited[i] = true;
				newNum += numbers.charAt(i);
				dfs(numbers, newNum, dept);
				visited[i] = false;//"017"일때 01 07 했으면 10 17그리고 70 71도 해줘야 하니까. 하나 전꺼를 false로
				newNum = newNum.substring(0, newNum.length()-1);//맨 끝에꺼를 지우고 새로 하기 위해
				}
			}
		}
	}
	
	static boolean isPrime(int x) {
		if(x==0 || x==1)
			return false;
		for(int i=2; i<x/2+1; i++) {//다른 풀이->애초에 짝수 거르기: i=3; i+=2, 제곱근까지만 나누려면 i<=sqrt(x), 대신 i=3부터 하려면 미리 main에서 x=2인 경우 answer+=1해줘야함.
			if(x % i == 0) return false;
			else continue;
		}
		return true;
	}

}

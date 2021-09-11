

import java.util.LinkedList;

//�Ҽ�ã��
public class findDecimal {//find prime
	static LinkedList<Integer> list = new LinkedList<>();
	static boolean visited[];

	public static void main(String[] args) {
		String numbers = "17";
		visited = new boolean[numbers.length()];

		for(int i=1; i<=numbers.length(); i++) {
			dfs(numbers, "", i);//n�迭���� ���ڷ� i�ڸ� ���ڸ� ������.
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
				visited[i] = false;//"017"�϶� 01 07 ������ 10 17�׸��� 70 71�� ����� �ϴϱ�. �ϳ� ������ false��
				newNum = newNum.substring(0, newNum.length()-1);//�� �������� ����� ���� �ϱ� ����
				}
			}
		}
	}

	static boolean isPrime(int x) {
		if(x==0 || x==1)
			return false;
		for(int i=2; i<x/2+1; i++) {//�ٸ� Ǯ��->���ʿ� ¦�� �Ÿ���: i=3; i+=2, �����ٱ����� �������� i<=sqrt(x), ��� i=3���� �Ϸ��� �̸� main���� x=2�� ��� answer+=1�������.
			if(x % i == 0) return false;
			else continue;
		}
		return true;
	}

}

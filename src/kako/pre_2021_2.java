package kako;

import java.util.LinkedList;

public class pre_2021_2 {

	public static void main(String[] args) {
		int n= 110011;
		int k= 10;//k진수
		int kjinsu =0;
		LinkedList<Integer> list = new LinkedList<>();
		int i = 0;
		while(n>=0) {
			int remain = n%k;
			n /= k;
			if(remain==0) {
				i = 0;
				if(kjinsu>0) list.add(kjinsu);
				kjinsu = 0;
				if(n==0) break;
				continue;
			}
			int x = (int) (remain*(Math.pow(10, i)));
			kjinsu += x;
			i++;

		}

		int answer = 0;
		for(Integer num : list) {
			if( isPrime(num) ){
				answer += 1;
			}
		}

		System.out.println(answer);
		for(Integer nnn : list) {
			System.out.print(nnn+" ");
		}
	}

	static boolean isPrime(int x) {
		if(x<=1) return false;
		else {
			for(int i=3; i<Math.sqrt(x); i++) {
				if(x%i == 0) {
					return false;
				}
			}
		}

		return true;
	}

}

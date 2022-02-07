package skill_check;

import java.util.HashMap;

public class Level2_1 {

	public static void main(String[] args) {
		System.out.println(solution_1(8,1,8));
		System.out.print(solution_2("I"));

	}

	static public int solution_1(int n, int a, int b){
        int answer = 0;

        while(true) {
        	a = (a+1)/2;
        	b = (b+1)/2;
        	answer++;
        	if(a==b) break;
        }

        return answer;
    }

	static public int solution_2(String word) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('A', 1); map.put('E', 2); map.put('I', 3); map.put('O', 4); map.put('U', 5);

		int answer = 0;
		for(int i=0; i<word.length(); i++) {
			int pos = 5-i-1;
			answer += map.get(word.charAt(i))*Math.pow(5, pos);
		}

		return answer;
	}

}

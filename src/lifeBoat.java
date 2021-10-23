import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/42885
//구명보트
//탐욕법
public class lifeBoat {

	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		System.out.print(solution(people, limit));
	}

	static public int solution(int[] people, int limit) {
		int left=0, right=people.length-1;
		int boat=0;
		Arrays.sort(people);
		while(left<=right) {
			if(people[left]+people[right]<=limit) {
				left++;
			}
			right--;
			boat++;
		}
		return boat;
	}

}

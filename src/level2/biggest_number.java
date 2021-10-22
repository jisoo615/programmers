package level2;
//https://programmers.co.kr/learn/courses/30/lessons/42746
//가장 큰수
//정렬 compareTo, comparator
import java.util.Arrays;
public class biggest_number {

	public static void main(String[] args) {
		System.out.print(solution(new int[] {3, 30, 34, 5, 9}));
	}

	static public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(nums, (s1, s2)->{
            return (s2+s1).compareTo(s1+s2);
        });

        if(nums[0].charAt(0)=='0') return "0";
        for(int i=0; i<nums.length; i++){
            answer += nums[i];
        }
        return answer;
    }

}

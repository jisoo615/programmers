package level2;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.util.Arrays;
import java.util.HashMap;

//https://programmers.co.kr/learn/courses/30/lessons/42578
//위장
public class spy_hash {

	public static void main(String[] args) {
		String clothes[][] = {{"yellowhat", "headgear"},
				{"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

		System.out.println(solution(clothes));
		System.out.println(solution_2(clothes));

	}

	public static int solution(String[][] clothes) {
		HashMap<String, Integer> h = new HashMap<>();
		for(String[] str : clothes) {
			if(h.containsKey(str[1])) {
				h.put( str[1], h.get(str[1])+1 );
			}else {
				h.put(str[1], 2);//안입는 경우까지 해서 처음이 2임
			}
		}
		int answer =1;
		for(Integer value : h.values()) {
			answer *= value;
		}
		answer -= 1; //아무것도 안입는 경우 1을 빼준다
		return answer;
	}

	public static int solution_2(String[][] clothes) {//스트림 이용한 풀이
		return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
	}

}

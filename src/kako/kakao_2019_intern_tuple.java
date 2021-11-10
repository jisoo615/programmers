package kako;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class kakao_2019_intern_tuple {
//스킬체크 레벨2문제와 같음 풀었던거 수정해서 풀기
		public static void main(String[] args) {
			String s = "{{2,1},{2},{2,1,3,4},{2,1,3}}";
			for(int x :solution_2(s)) {
				System.out.print(x+" ");
			}

		}

		static public int[] solution_2(String s) {
			//중괄호 없애주고 hashMap에 ,단위로 개수를 추가해줌
			//가장 많은 개수의 숫자가 원래집합에서 맨 앞임
			String s2 = s.replaceAll("[{}]", "");

			String[] arr = s2.split(",");
			HashMap<String, Integer> map = new HashMap<>();
			for(String num : arr) {
				if(!map.containsKey(num)) {
					map.put(num, 1);
				}else {
					map.put(num, map.get(num)+1);
				}
			}

			List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
			Collections.sort(list, (o1, o2)->{
				return o2.getValue() - o1.getValue();
			});

			int[] answer = new int[list.size()];
			int index = 0;
			for(Entry<String, Integer> entry : list) {
				answer[index++] = Integer.parseInt(entry.getKey());
			}

			return answer;
		}

	}


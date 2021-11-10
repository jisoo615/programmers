package kako;

import java.util.HashMap;

public class kakao_2019_intern_tuple {
//스킬체크 레벨2문제와 같음 풀었던거 수정해서 풀기
		public static void main(String[] args) {
			solution_2("{{2,1},{2},{2,1,3,4},{2,1,3}}");

		}

		static public int[] solution_2(String s) {
			//중괄호 없애주고 hashMap에 ,단위로 개수를 추가해줌
			//가장 많은 개슈의 숫자가 맨 앞임
			s = s.replace("[{}]", "");
			String[] arr = s.split(",");
			HashMap<String, Integer> map = new HashMap<>();
			for(String num : arr) {
				if(map.containsKey(num)) {
					map.put(num, 1);
				}else {
					map.put(num, map.get(num)+1);
				}
			}

			String[] arr2 = map.entrySet().toArray();

			return new int[] {};
		}

	}


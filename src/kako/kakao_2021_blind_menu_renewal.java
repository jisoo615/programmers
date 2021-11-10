package kako;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
//https://programmers.co.kr/learn/courses/30/lessons/72411
//메뉴 리뉴얼
public class kakao_2021_blind_menu_renewal {

	public static HashMap<String, Integer> map = new HashMap<>();
	public static LinkedList<String> combi = new LinkedList<>();

	public static void main(String[] args) {
		String orders[] = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};

		for(String str:solution(orders, course)) {
			System.out.print(str+" ");
		}
	}

	public static String[] solution(String orders[], int[] course) {
		for(String order : orders) {
			char[] charr = order.toCharArray();
			Arrays.sort(charr);
			for(int length : course) {
				dfs(0, charr,"", length);
			}
		}

		Collections.sort(combi, (o1, o2) -> {//길이 오름차순. 횟수개수 내림차순
			return o1.length() == o2.length() ?  map.get(o2)-map.get(o1) : o1.length()-o2.length();
				});

		int index=0; int max = map.get(combi.get(0));
		for(Iterator<String> iter = combi.iterator(); iter.hasNext();) {
			String combiStr = iter.next();
			if(combiStr.length() > course[index]) {//조합의 길이가 지금꺼가 더 크면 다음 코스요리 길이로 넘어간다
				index++;
				max = map.get(combiStr);//max는 해당 조합의 최대 개수임(combi는 길이오름차순, 개수내림차순 이니까)
			}
			if(max > map.get(combiStr) || map.get(combiStr)==1) {
				iter.remove();
			}
		}


		String[] answer = new String[combi.size()];
		combi.sort(null);
		for(int i=0; i<answer.length; i++) {
			answer[i] = combi.get(i);
		}
		return answer;
	}

	public static void dfs(int idx, char[] order, String str, int length) {
		if(str.length()==length) {
			if(!map.containsKey(str)) {
				combi.add(str);
				map.put(str, 1);
				return;
			}else {
				map.put(str, map.get(str)+1);
				return;
			}
		}

		for(int i=idx; i<order.length; i++) {//ab 니 ba나 같은거기 때문에
			dfs(i+1, order, str+order[i], length);
		}
	}

}

package kako;
import java.util.LinkedList;

public class pre_2021_1 {

	public static void main(String[] args) {
		int k = 2;
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo",
				"frodo neo","muzi neo","apeach muzi"};
		LinkedList<String> id = new LinkedList<>();
		for(String s : id_list) id.add(s);
		int[] answer = new int[id_list.length];
		LinkedList check[] = new LinkedList[id_list.length];
		for(int i=0; i<id_list.length; i++) {
			check[i] = new LinkedList<Integer>();
		}

		int cnt[] = new int[id_list.length];
        for(int i=0; i<report.length; i++){
        	String[] sarr = report[i].split(" ");
        	int warner = id.indexOf(sarr[0]);
        	int warned = id.indexOf(sarr[1]);
        	if( !check[warner].contains(warned)) {
        		check[warner].add(warned);
        		cnt[warned] += 1;
        	}

        }

        for(int i=0; i<id_list.length; i++) {
        	for(Object index : check[i]) {
        		if(cnt[(int) index] >= k) answer[i] += 1;
        	}
        }

        for(Integer x : answer) System.out.print(x+" ");
	}

}
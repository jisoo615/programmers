package kako;

import java.util.LinkedList;

public class kakao_2021_intern_editTable {

	static public void main(String[] args) {
		int n=8; int k=2;//행개수, 선택된 행
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};//명령어
		System.out.print(solution(n, k, cmd));
	}

	static public String solution(int n, int k, String[] cmd) {
		LinkedList<Integer> list = new LinkedList<>();
		for(String str : cmd) {
			int move = str.length()<=1 ? 0:Integer.valueOf(str.charAt(2));
			int index = 0;

			switch(str.charAt(0)) {
			case 'U' : k = Math.max(0, k-move);//현재보다 위
				break;
			case 'D' : k = Math.min(k-move, n-1);//현재보다 아래
				break;
			case 'C' : list.add(k);
						n-=1;
						if(k==n) k-=1;
				break;
			case 'Z' : index = list.pollLast();
						if(index<=k) k+=1;
						n += 1;
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) sb.append('O');
		while(list.size()>0) {
			int idx = list.pollLast();
			sb.insert(idx, 'X');
		}


		return sb.toString();
	}

}

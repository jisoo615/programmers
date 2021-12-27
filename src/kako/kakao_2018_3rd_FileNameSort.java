package kako;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/17686
//카카오 2018 파일명 정렬
public class kakao_2018_3rd_FileNameSort {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] files = {"img000012345", "img1.png","img2","IMG02"};
		for(String str : s.solution(files)) {
			System.out.println(str);
		}

	}

	static class Solution {
	    public String[] solution(String[] files) {
	        File[] filearr = new File[files.length];
	        for(int i=0; i<files.length; i++) {
	        	filearr[i] = new File(files[i]);
	        }

	        Arrays.sort(filearr, (o1, o2)->{
	        	if (o1.head.equals(o2.head)) {
					if (o1.number == o2.number) {//문제의 부분
                        //여기서는 int형 num을 비교하는게 아님.
                        //문자열 number가 같은지 비교하는 것임.
                        //(head+number가 완전히 똑같을 경우 원래순서따름)
						return 1;
					}else
						return o1.num - o2.num;

	        	}else
					return o1.head.compareTo(o2.head);
	        });

	        String[] answer = new String[files.length];
	        for(int i=0; i<filearr.length; i++) {
	        	answer[i] = filearr[i].fileName;
	        }

	        return answer;
	    }
	}

	static class File{//foo / 010 / bar020.zip
		String fileName;
		String head;
		String number;
		int num;

		public File(String fileName) {
			this.fileName = fileName;

			int idx = 0;
    		for (int i = 0; i < fileName.length(); i++) {
    			char c = fileName.charAt(i);

    			if (idx == 0 && (c<= '9' && c >= '0')) {
    				head = fileName.substring(0, i).toLowerCase();
    				idx = i;
    			}

    			if (idx != 0 && !(c <= '9' && c >= '0')) {
    				number = fileName.substring(idx, i);
    				break;
    			}
    		}

    		if (number == null)	number = fileName.substring(idx);
    		if(number.length()>5) this.number = this.number.substring(0, 5);
    		this.num = Integer.parseInt(this.number);
		}

	}

}

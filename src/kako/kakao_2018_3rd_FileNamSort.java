package kako;

import java.util.HashMap;

//https://programmers.co.kr/learn/courses/30/lessons/17686
//카카오 2018 파일명 정렬
public class kakao_2018_3rd_FileNamSort {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		for(String str : s.solution(files)) {
			System.out.println(str);
		}

	}

	static class Solution {
	    public String[] solution(String[] files) {
	        String[] answer = {};

	        HashMap<String, String> map = new HashMap<>();

	        return answer;
	    }
	}

}

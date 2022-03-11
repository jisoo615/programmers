package kako;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class kakao_2017_thoughts_of_brian {

	public static void main(String[] args) {
		System.out.println(new Solution().solution("HaEaLaLaObWORLDb"));
		System.out.println(new Solution().solution("SpIpGpOpNpGJqOqA"));
		System.out.println(new Solution().solution("AxAxAxAoBoBoB"));// invalid
	}

	static class Solution {
		class Word{
			private int rule;
			private int start;
			private int end;
			public Word(int rule, int start, int end) {
				this.rule=rule; this.start=start; this.end=end;
			}
		}

	    public String solution(String sentence) {
	    	String invalid = "invalid";
	        //대문자 = 원래문구, 소문자=특수문자
	        StringBuilder sb = new StringBuilder();
/* 소문자의 위치 저장 : LinkedHashMap<Character, List<Integer>> 소문자의 위치를 담는 순서보장하는 해시맵
 *
 *
 */
	        LinkedHashMap<Character, List<Integer>> chars_pos = new LinkedHashMap<>();
	        for(int i=0; i<sentence.length(); i++) {
	        	char c = sentence.charAt(i);
	        	if(c>96) {//소문자면 넣기
	        		if(!chars_pos.containsKey(c)) {
	        			chars_pos.put(c, new ArrayList<Integer>());
	        		}
	        		chars_pos.get(c).add(i);
	        	}
	        }

	        int start_str = 0,
	        	start_char, end_char, start_char_pre=-1, end_char_pre=-1,
	        	start_word = 0, end_word=0, end_word_pre = -1,
	        	num, rule = -1, distance;
	        boolean isDistance2= false;
	        List<Word> words = new ArrayList<>();

	        for(List<Integer> positions: chars_pos.values()) {
	        	num = positions.size();
	        	start_word = start_char = positions.get(0);
	        	end_word = end_char = positions.get(num-1);
	        	isDistance2 = true;// 아래 for문에서 별일없으면 간격2임

	        	for(int i=1; i<num; i++) {
	        		distance = positions.get(i) - positions.get(i-1);
	        		if(distance<2) return invalid;
	        		if(distance>2) {// 간격이 3 이상이면 규칙2 or 규칙1 위반
	        			isDistance2 = false;
	        			break;
	        		}
	        	}
	        	// 규칙1: XaXaX  규칙2: aXXXa
	        	if(num>=3 && !isDistance2) return invalid; // aXXXaXa 경우- 규칙1(간격2)위반
	        	if(num==1 || num>=3) {// 특수문자 2개 아니면 무조건 규칙1임 (규칙2는 무조건 num=2)
	        		rule = 1;
	        		start_word--;
	        		end_word++;
	        		if(start_word<0 || end_word>= sentence.length()) return invalid;
	        	}
	        	if(num==2) {// 규칙2인지 판단
	        		rule = isDistance2? 0:2; // 간격2면 규칙1,2둘다, 간격3이상이면 규칙2
	        	}
	        	if(start_char_pre<start_char && end_char < end_char_pre) {
	        		if(rule==2)return invalid;//규칙2오류 - 한 단어에 같은 규칙 2번 적용
	        		continue;// 규칙2 안에 규칙1
	        	}
	        	if(end_word_pre >= start_word)return invalid;// 단어범위 넘어감 오류

	        	words.add(new Word(rule, start_word, end_word));
	        	start_char_pre = start_char;
	        	end_char_pre = end_char;
	        	end_word_pre = end_word;

	        }// for chars_pos.values end

	        // 단어 이어붙이기
	        StringBuilder answer = new StringBuilder();
	        Word word;
	        for(int i=0; i<words.size(); i++) {
	        	word = words.get(i);
	        	rule = word.rule;
	        	start_word = word.start;
	        	end_word = word.end;

	        	if(word.rule==0) {// 규칙1 또는 2
	        		if(start_str<=start_word-1 && end_word+1 < (i<words.size()-1 ?
	        				words.get(i+1).start : sentence.length())) {// 규칙1이면 범위 양옆 1씩 늘려야함
	        			start_word--;
	        			end_word++;
	        		}
	        	}
	        	if(start_str < start_word) answer.append(transStr(start_str, start_word-1, sentence));// 소문자없는 앞부분 붙이기
	        	answer.append(transStr(start_word, end_word,sentence));
	        	start_str = end_word+1;
	        }

	        if(start_str < sentence.length()) answer.append(transStr(start_str, sentence.length()-1, sentence));

	        return answer.toString().trim();
	    }

	    String transStr(int start, int end, String s) {
	    	return s.substring(start, end+1).replaceAll("[a-z]", "")+" ";
	    }
	}

}

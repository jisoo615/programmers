package kako;

import java.util.HashSet;
import java.util.LinkedList;

//https://programmers.co.kr/learn/courses/30/lessons/67257
//[카카오 인턴] 수식 최대화
//설명 보니 괄호를 어디다 줄건지 생각하는 것과 같다. 숫자 순서와 수식은 그대로이고, 연산의 우선순위만 다르게 하여 최대값을 만들어야 하기 때문
public class kakao_2020_intern_maximizeMathExpression {

	public static void main(String[] args) {
		String expression = "200-300-500-600*40+500+500";
		System.out.print(solution(expression));

	}

	static public long solution(String expression) {
        //-+*의 우선순위
        LinkedList<Long> digit = new LinkedList<>();
        LinkedList<String> susik = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();
        set.add('-'); set.add('+'); set.add('*');
        int start = 0;
        for(int i=0; i<expression.length(); i++) {
        	if(set.contains(expression.charAt(i))) {
        		digit.add(Long.parseLong(expression.substring(start, i)));
        		start = i+1;

        		susik.add(String.valueOf(expression.charAt(i)));
        	}
        }
        digit.add(Long.parseLong(expression.substring(start, expression.length())));
        //--------------숫자와 기호 나눠담기-------------------------------------------------

        long answer = 0;
        String[][] rank = {{"-", "+", "*"}, {"-", "*", "+"},
        		{"*", "-", "+"}, {"*", "+", "-"},
        		{"+", "-", "*"}, {"+","*","-"}};
        for(int i=0; i<6; i++) {
        	LinkedList<Long> digit_copy = new LinkedList<>(digit);
        	LinkedList<String> susik_copy = new LinkedList<>(susik);

        	for(int j=0; j<3; j++) {//한 경우의 연산을 한방에 실행

        	while(susik_copy.contains(rank[i][j])) {
        		int index = susik_copy.indexOf(rank[i][j]);
        		if(index==-1) continue;//해당 연산기호가 없으면 다음 기호로.

        		susik_copy.remove(index);
        		long temp = (digit_copy.get(index));
        		digit_copy.remove(index);

        		switch (rank[i][j]){
        			case "-" : temp-=digit_copy.get(index);break;
        			case "+" : temp+=digit_copy.get(index);break;
        			case "*" : temp*=digit_copy.get(index);break;
        		}
        		digit_copy.remove(index);

        		digit_copy.add(index, temp);
        	}

        	}//j
        	answer = Math.max(answer, Math.abs(digit_copy.get(0)));
        }//i

        return answer;
    }

}

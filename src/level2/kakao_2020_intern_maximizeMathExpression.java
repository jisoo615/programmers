package level2;

import java.util.LinkedList;
import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/67257
//[카카오 인턴] 수식 최대화
//설명 보니 괄호를 어디다 줄건지 생각하는 것과 같다. 숫자 순서와 수식은 그대로이고, 연산의 우선순위만 다르게 하여 최대값을 만들어야 하기 때문
public class kakao_2020_intern_maximizeMathExpression {

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.print(solution(expression));

	}

	static public long solution(String expression) {
        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        //-+*의 우선순위
        LinkedList<Integer> digit = new LinkedList<>();
        LinkedList<String> susik = new LinkedList<>();
        int start = 0;
        for(int i=0; i<expression.length(); i++) {
        	if("[-+*]".equals(expression.charAt(i))) {
        		digit.add(Integer.parseInt(expression.substring(start, i)));
        		start = i+1;

        		susik.add(expression.charAt(i), expression);
        	}
        }

        String[][] rank = {{"-", "+", "*"}, {"-", "*", "+"}, {"*", "-", "+"}, {"*", "+", "-"}, {"+", "-", "*"}, {"+","*","-"}};
        for(int i=0; i<6; i++) {
        	LinkedList<Integer> digit_copy = digit;
        	LinkedList<String> susik_copy = susik;

        	for(int j=0; j<3; j++) {

        	while(susik_copy.contains(first)) {
        		int index = susik_copy.indexOf(first);
        		susik_copy.remove(index);
        		int temp = (digit_copy.get(index));
        		digit_copy.remove(index);

        		switch (first){
        			case "-" : temp-=digit_copy.get(index);break;
        			case "+" : temp+=digit_copy.get(index);break;
        			case "*" : temp*=digit_copy.get(index);break;
        		}
        		digit_copy.remove(index);

        		digit_copy.add(index, temp);

        	}

        	}//j
        }//i




        return answer;
    }

}

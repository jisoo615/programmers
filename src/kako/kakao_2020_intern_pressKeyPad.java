package kako;

public class kakao_2020_intern_pressKeyPad {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.print(solution(numbers, hand));

	}

	public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int left = 10;
        int right = 12;
        int differ=0, dl=0, dr=0;
        for(int num:numbers) {
        	if(num==0) num = 11;//키패드의 숫자0은 거리를 따졌을때 11인 자리에 있다.

        	if(num%3==1) {//맨 왼쪽 숫자면 L
        		sb.append("L");
        		left = num;
        		continue;
        	}
        	if(num%3==0) {//맨 오른쪽 숫자면 R
        		sb.append("R");
        		right=num;
        		continue;
        	}

        	differ = Math.abs(num-left);
        	dl= differ/3 + differ%3;

        	differ = Math.abs(num-right);
        	dr = differ/3 + differ%3;

        	if(dl==dr) {
        		if(hand.equals("right")) {
        			sb.append("R");
        			right=num;
        		}else {
        			sb.append("L");
        			left = num;
        		}

        	}else if(dl<dr){
        		sb.append("L");
        		left = num;
        	}else {
        		sb.append("R");
        		right = num;
        	}
        }

        return sb.toString();
    }
}

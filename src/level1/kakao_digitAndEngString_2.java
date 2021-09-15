package level1;

public class kakao_digitAndEngString_2 {
//엄청 짧은 방식...
	public static void main(String[] args) {
		String s="onetwo34five6seven";
		String digit[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String engStr[] = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

		for(int i=0; i<10; i++) {//0~9까지만 돌면서 바꾸면 되니까
			s = s.replaceAll(engStr[i], digit[i]);
		}

		int answer = Integer.parseInt(s);
		System.out.print(answer);
	}

}

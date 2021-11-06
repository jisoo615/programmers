package level2;
//https://programmers.co.kr/learn/courses/30/lessons/70129
//이진변환 반복하기
public class binary_transform {

	public static void main(String[] args) {
		String s = "110010101001";
		for(int x:solution(s)) System.out.print(x+" ");

	}

	static public int[] solution(String s) {
        int zero = 0; int cnt = 0;
        while(true) {
        	int pre_len = s.length();
        	s = s.replaceAll("0", "");
        	int after_len = s.length();

        	zero += (pre_len - after_len);
        	s = trans_binary(after_len);
        	cnt++;

        	if(s.equals("1")) break;
        }

        return new int[] {cnt, zero};
    }

	public static String trans_binary(int x) {
		StringBuilder sb = new StringBuilder();

		while(true) {
			if(x==1) {
				sb.append(x);
				break;
			}
			sb.append(x%2);
			x /=2;
		}
		return sb.reverse().toString();
	}

}

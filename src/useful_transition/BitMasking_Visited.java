package useful_transition;

public class BitMasking_Visited {

	public static void main(String[] args) {
		/**
		 * 비트로 배열의 방문여부를 나타낼 수 있다
		 */

		/**
		 * 1. 인덱스가 2인 부분을 1로 만들고 싶을때
		 * 10010 (오른쪽부터 0번임, 18)
		 * 1<<2 : 100
		 * 10010 | 00100 : 10110
		 */
		System.out.println(18 | 1 << 2);
		System.out.println(Integer.toBinaryString(18));
		System.out.println(Integer.toBinaryString(1 << 2));
		System.out.println(Integer.toBinaryString(18 | 1 << 2));

		/**
		 * 2. 인덱스가 2인 부분을 0으로 만들고 싶을때
		 * 10110 (22)
		 * ~1<<2 : 11011
		 * 10110 & 11011 : 10010
		 */
		System.out.println(22 | ~1 << 2);
		System.out.println(Integer.toBinaryString(22));
		System.out.println(Integer.toBinaryString(~1 << 2));// 왜 11011이 아니고 11000이 되는건지 모르겠음
		System.out.println(Integer.toBinaryString(22 & ~1 << 2));
	}

}

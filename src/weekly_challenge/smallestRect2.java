package weekly_challenge;

public class smallestRect2 {

	public static void main(String[] args) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};//{w, h}


		int small=0, big=0;
		for(int[] rect : sizes) {

			if(rect[0] < rect[1]) {
				small = Math.max(small, rect[0]);
				big = Math.max(big, rect[1]);

			}else {
				small = Math.max(small, rect[1]);
				big = Math.max(big, rect[0]);
			}

		}

		System.out.print(small*big);

	}

}

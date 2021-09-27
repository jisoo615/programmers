package weekly_challenge;
//https://programmers.co.kr/learn/courses/30/lessons/86491
//최소 직사각형 위클리챌린지8주차
public class smallestRect {

	public static void main(String[] args) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};//{w, h}

		int smallest = sizes[0][0];
		int biggest = sizes[0][1];
		if(smallest > biggest) {
			int t = smallest;
			smallest = biggest;
			biggest = t;
		}
		for(int i=1; i<sizes.length; i++) {

			int small = sizes[i][0];
			int big = sizes[i][1];
			if(small > big) {
				int t = small;
				small = big;
				big = t;
			}

			if(small > smallest) {//더 큰 small이 있다면 더 큰거롤 바꿔야함 주의!! small이라고 더 작은것을 하면 안됨
				smallest = small;
			}
			if(big > biggest) {
				biggest = big;
			}

		}

		System.out.print(smallest*biggest);

	}
}

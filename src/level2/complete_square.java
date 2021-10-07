package level2;
//https://programmers.co.kr/learn/courses/30/lessons/62048
//멀쩡한 사각형
public class complete_square {

	public static void main(String[] args) {
		int w =8;
		int h =12;

		//w*h - (w+h-(w, h 의 최대공약수))

		int gcd = gcd(w, h);
	}

	public static int gcd(int w, int h) {
		int k = 0;
		int x = Math.min(w, h);
		int y = Math.max(w, h);
		return k;
	}

}

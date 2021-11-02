package level2;

//https://programmers.co.kr/learn/courses/30/lessons/42842
//카펫
public class carpet {

	public static void main(String[] args) {
		int brown=16;
		int yellow=4;
		for(int x:solution(brown, yellow)) System.out.print(x+" ");

	}

	static public int[] solution(int brown, int yellow) {
        int total = brown+yellow;
        int i=1;
        int width, height;
        int width_y, height_y;
        while(i<=total) {
        	height = total/i;
        	width = total/height;

        	width_y = width-2;
        	height_y = height-2;

        	if(width_y*height_y==yellow && width_y>=height_y) {
        		return new int[] {width, height};
        	}

        	i++;
        }
		return new int[] {};
    }
}

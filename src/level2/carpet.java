package level2;

//https://programmers.co.kr/learn/courses/30/lessons/42842
//카펫
public class carpet {

	public static void main(String[] args) {
		int brown=14;
		int yellow=6;
		for(int x:solution(brown, yellow)) System.out.print(x+" ");

	}

	static public int[] solution(int brown, int yellow) {
        int total = brown+yellow;
        int width, height=2;
        int width_y, height_y;

        while(height<=total) {
        	height++;//끝애 있으면 continue에 걸려서 실행안되니까 앞으로
        	if(total%height != 0) continue;
        	width = total/height;

        	width_y = width-2;
        	height_y = height-2;

        	if(width_y*height_y==yellow && width_y>=height_y) {
        		return new int[] {width, height};
        	}
        }
		return new int[] {0, 0};
    }
}

package winter_coding_2021;

public class rainbow_cake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Cake{
		char flavor;
		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		public Cake(){
		}
	}

	static public int solution(String[] cakes, int[] cut_rows, int[] cut_columns) {
        int answer = 0;
        Cake[][] cake = new Cake[cakes.length][cakes[0].length()];
        for(String c : cakes) {
        	char[] chararr = c.toCharArray();
        	for(int i=0; i<chararr.length; i++) {

        	}
        }
        return answer;

}
}

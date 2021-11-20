package winter_coding_2021;

public class gold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int solution(int time, int gold, int[][] upgrade) {
        int answer = 0;
        for(int i=0; i<upgrade.length-1; i++) {
        	int nextLevelCost = upgrade[i+1][0];

        	double spentTime = (double)(nextLevelCost/gold)/upgrade[i][1];
        	time -= Math.ceil(spentTime);
        	if(time<=0) break;

        }

        return answer;

}

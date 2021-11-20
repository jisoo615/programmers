package level3;

import java.util.HashMap;

public class selling_tooth_brush {
	public static HashMap<String, String> tower;
	public static HashMap<String, Integer>profit;

	public static void main(String[] args) {
		String[] enroll= {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral= {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller= {"young", "john", "tod", "emily", "mary"};
		int[] amount= {12, 4, 2, 5, 10};
		for(int x : solution(enroll, referral, seller, amount)) {
			System.out.print(x+" ");
		}
	}

	static public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        tower = new HashMap<>();//current, parent
        profit = new HashMap<>();//seller, profit money
        for(int i=0; i<enroll.length; i++) {
        	tower.put(enroll[i], referral[i]);
        	profit.put(enroll[i], 0);
        }
        tower.put("-", "");
        profit.put("-", 0);
        for(int i=0; i<seller.length; i++) {
        	String current = seller[i];
        	profit.put(current, profit.get(current)+amount[i]*100);
        	gotoTop(current, amount[i]*100);
        }

        for(int i=0; i<enroll.length; i++) {
        	answer[i] = profit.get(enroll[i]);
        }
        return answer;
    }

	static public void gotoTop(String current, int money) {
		if(money<10 || current.equals("-")) return;

		int tenPercent = (int) (money*0.1);
		String parent = tower.get(current);

		profit.put(parent, profit.get(parent)+tenPercent);
		profit.put(current, profit.get(current)-tenPercent);
		gotoTop(parent, tenPercent);
	}

}

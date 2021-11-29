package winter_coding_2021;

public class monster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public String solution(String character, String[] monsters) {
        String answer = "";
        String[] charac = character.split(" ");
        int stat = Integer.parseInt(charac[0]);
        int attack = Integer.parseInt(charac[1]);
        int defend = Integer.parseInt(charac[2]);
        for(int i=0; i<monsters.length; i++) {
	        while(stat>0) {
	        	//monsters[i]
	        }
        }
        return answer;
    }

}


public class cafe24_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String s:solution(9, 1)) System.out.print(s+" ");
	}

	static public String[] solution(int startNumber, int endNumber) {
        int len = Math.abs(startNumber-endNumber);
        String[] answer = new String[len+1];
        boolean addi = startNumber <= endNumber ? true:false;
        answer[0] = "000000000".concat(Integer.toString(startNumber));
        for(int i=1; i<len+1; i++){
            if(addi){
                answer[i] = answer[i-1].substring(1).concat(Integer.toString(++startNumber));
            }else{
                answer[i] = answer[i-1].substring(1).concat(Integer.toString(--startNumber));
            }

        }
        return answer;
    }

}

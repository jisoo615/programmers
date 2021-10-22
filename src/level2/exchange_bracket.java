package level2;
//https://programmers.co.kr/learn/courses/30/lessons/60058
//괄호 변환
//재귀문제
public class exchange_bracket {

	public static void main(String[] args) {
		System.out.print(solution("(()())()"));

	}

	static public String solution(String p) {

      if(!p.isEmpty()) {//isEmpty()로 빈문자열 확인해야됨. ==""로 했다가 안먹힘

        int index = indexOf(p)+1;
        String u = p.substring(0, index);
        String v = p.substring(index);

        if(u.charAt(0)=='('){//균형잡혔는데 처음이 (이면 어떻게든 올바른 괄호문자열밖에 안되기 때문
            return u+solution(v);
        }else{
        	return "("+solution(v)+")"+reverse(u);
        }


      }else {//p==""
    	  return "";
      }

    }

	static public String reverse(String s) {//첫번째와 마지막 문자 삭제하고 괄호 반대로 바꿔주기
		String tmp="";
		s = s.substring(1, s.length()-1);
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') tmp += ')';
			else tmp += '(';
		}
		return tmp;
	}

	static public int indexOf(String p) {//균형이 처음으로 맞춰지는 지점 반환
		int sum = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='(') sum += 1;
            else sum -= 1;
            if(sum==0){
                return i;
            }
        }return 0;
	}

}

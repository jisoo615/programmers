package ex.lotto;

import java.util.Random;

public class Lotto {
	private int[] lottoNumber = new int[6];
	private boolean isValid = false;

	public Lotto() {}
	public Lotto(int[] lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public boolean verify() {
		//설정된 번호의 유효성
		boolean checked[] = new boolean[46];
		for(int x : this.lottoNumber) {
			if(!checked[x] && x>=1 && x<=45) {
				checked[x] = true;
			}else {
				return this.isValid = false;
			}
		}
		return this.isValid = true;
	}

	public void show() {
		StringBuilder sb = new StringBuilder();
		if( verify() ) {
			for(int x : this.lottoNumber)
			sb.append(x+" ");

		}else {
			sb.append("유효하지 않습니다.");
		}

		System.out.println(sb);
	}

	public int[] getNumbers() {
		if(verify()) {
			return this.lottoNumber;
		}else {
			return null;
		}
	}

	public void generate() {
		Random random = new Random();
		int[] numbers = new int[6];
		//의사 난수 이용 유효 번호의 자동 생성
		boolean checked[] = new boolean[46];
			for(int i=0; i<6;) {
				int num = random.nextInt(45)+1;
				if(!checked[num]) {
					numbers[i] = num;
					checked[num] = true;
					i++;
				}
			}

		this.isValid = true;
		this.lottoNumber = numbers;
	}

}

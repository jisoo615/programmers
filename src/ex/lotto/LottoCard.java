package ex.lotto;

import java.util.Scanner;
import java.util.StringTokenizer;

public class LottoCard {
	public Lotto[] lotto;
	private int n;//값이 설정된 로또번호 개수 1~5

	public LottoCard(int n){
		this.n = n;
		lotto = new Lotto[n];

		for(int i=0; i<n; i++) {
			Lotto lo = new Lotto();
			lo.generate();
			lotto[i] = lo;
		}
	}

	public LottoCard() {
//수동설정
		Scanner sc = new Scanner(System.in);
		System.out.print("몇개의 로또번호를 입력? : ");
		this.n = Integer.parseInt(sc.nextLine());

		lotto = new Lotto[n];

		for(int T=0; T<n;) {
			int[] numbers = new int[6];
			System.out.print(T+1+"번째 로또 번호를 입력하세요. : ");
			StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

			for(int i=0; i<6; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			Lotto lo = new Lotto(numbers);

			if(lo.verify()) {
				lotto[T] = lo;
				T++;
			}else {
				System.out.println("로또 번호를 다시 입력하세요");
			}

		}
		sc.close();
	}
}

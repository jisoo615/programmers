package ex.hw;

import ex.lotto.Lotto;
import ex.lotto.LottoCard;

public class LottoSim {

	public static void main(String args[]) {
		Lotto a = new Lotto();
		a.generate();
		System.out.println(a.verify());

		int[] num = a.getNumbers();
		for(int x :num) System.out.print(x+" ");

		System.out.println();
		a.show();


		LottoCard card = new LottoCard(3);
		for(Lotto l : card.lotto) {
			l.show();
		}
System.out.println();
		LottoCard card2 = new LottoCard();
		System.out.println("---수동 설정한 로또 카드---");
		for(Lotto l : card2.lotto) {
			l.show();
		}
	}
}

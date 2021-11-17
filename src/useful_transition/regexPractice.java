package useful_transition;

public class regexPractice {

	public static void main(String[] args) {
		String email = "java@coding.com";
		//이클립스애선 \를 \\로 써야 알아먹고 알수있음
		boolean isEmail = email.matches("[0-9a-z]+@[0-9a-z]+.[0-9a-z]{2,6}");
		System.out.print(isEmail);

	}

}

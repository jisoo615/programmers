package useful_transition;

public class array_bracket_transform_toJava {

	public static void main(String[] args) {
		String example = "[[1, 2, 1], [3, 2, 1], [2, 4, 1]]";
		example = example.replace("[", "{");
		example = example.replace("]", "}");
		System.out.print(example);
	}

}

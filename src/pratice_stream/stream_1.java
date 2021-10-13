package pratice_stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.util.Arrays;

public class stream_1 {

	public static void main(String[] args) {
		String clothes[][] = {{"yellowhat", "headgear"},
				{"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

		System.out.print(Arrays.stream(clothes)
		.collect( groupingBy( p -> p[1], mapping(p -> p[0], counting()) ) )
		.values().stream()
		.collect( reducing(1L, (x,y) -> x*(y+1)) ).intValue()-1);

	}

}

package Generator;

import java.util.function.Function;

public class Generators {

	public static Function<Integer, Integer> SecuentialGenerator = seed -> ++seed;
	public static Function<Integer, Integer> EvenGenerator = seed -> seed + (seed % 2 == 0 ? 2 : 1);
	public static Function<Integer, Integer> OddGenerator = seed -> seed + (seed % 2 == 0 ? 1 : 2);

}

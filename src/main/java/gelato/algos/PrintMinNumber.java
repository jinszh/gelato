package gelato.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> nums = new ArrayList<>();
        IntStream.of(numbers).forEach(o -> nums.add(String.valueOf(o)));
        Collections.sort(nums, ((o1, o2) -> ((o1 + o2).compareTo(o2 + o1))));
        return String.join("", nums);
    }
}

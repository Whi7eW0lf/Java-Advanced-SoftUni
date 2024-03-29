import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Arrays.stream(read.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int divisibleNum = Integer.parseInt(read.readLine());

        Predicate<Integer> filterByCriteria = num -> num % divisibleNum != 0;

        UnaryOperator<List<Integer>> removeDivisibleByNum = list -> list.stream()
                .filter(filterByCriteria)
                .collect(Collectors.toList());

        nums = removeDivisibleByNum.apply(nums);

        Collections.reverse(nums);

        System.out.println(nums.toString().replaceAll("[\\[\\],]", ""));
    }
}

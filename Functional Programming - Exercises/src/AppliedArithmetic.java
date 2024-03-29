import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Arrays.stream(read.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<Integer, Integer> add = num -> num + 1;
        Function<Integer, Integer> multiply = num -> num * 2;
        Function<Integer, Integer> subtract = num -> num - 1;

        String input;

        while (!"end".equals(input = read.readLine())) {

            switch (input) {
                case "add":
                    nums = nums.stream().map(add).collect(Collectors.toList());
                    break;
                case "multiply":
                    nums = nums.stream().map(multiply).collect(Collectors.toList());
                    break;
                case "subtract":
                    nums = nums.stream().map(subtract).collect(Collectors.toList());
                    break;
                case "print":
                    System.out.println(nums.toString().replaceAll("[\\[\\],]",""));
                    break;
            }

        }
    }
}

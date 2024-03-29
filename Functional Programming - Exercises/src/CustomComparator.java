import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Arrays.stream(read.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = (first, second) -> {

            int compare;

            if (first % 2 == 0 && second % 2 != 0) {
                compare = -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                compare = 1;
            } else {
                compare = first - second;
            }
            return compare;
        };

        nums.sort(comparator);

        System.out.println(nums.toString().replaceAll("[\\[\\],]",""));

    }
}

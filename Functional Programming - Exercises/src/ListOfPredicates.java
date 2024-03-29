import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        List<Integer> nums = Arrays.stream(read.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> divisibleByCriteria = num -> {

            boolean print = true;

            for (Integer number : nums) {
                if (num%number!=0){
                    print = false;
                    break;
                }
            }
            return print;
        };

       for (int i = 1; i <=n; i++) {
           if (divisibleByCriteria.test(i)){
               System.out.print(i+" ");
           }
       }


    }
}

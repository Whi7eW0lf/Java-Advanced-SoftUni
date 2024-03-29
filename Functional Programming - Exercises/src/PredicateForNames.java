import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(read.readLine());
        String[] input = read.readLine().split("\\s+");

        Predicate<String> checkLength = name -> name.length() <= length;

        Consumer<String> printer = System.out::println;

        Arrays.stream(input)
                .filter(checkLength)
                .forEach(printer);

        //Other Solution :

        //int length1 = Integer.parseInt(read.readLine());
        //Arrays.stream(read.readLine()
        //        .split("\\s+"))
        //        .filter(name -> name.length() <= length1)
        //        .forEach(System.out::println);

    }
}

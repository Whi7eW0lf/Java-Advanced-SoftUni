import java.util.Arrays;
import java.util.Scanner;

public class KnightsOfHonor {
    public static void main(String[] args) {

        Arrays.stream(new Scanner(System.in).nextLine().split("\\s+")).forEach(e-> System.out.printf("Sir %s%n",e));

    }
}

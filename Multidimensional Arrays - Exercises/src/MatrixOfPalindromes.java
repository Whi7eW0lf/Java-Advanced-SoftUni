import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i <input[0] ; i++) {
            for (int j = 0; j < input[1]; j++) {
                System.out.print(String.format("%c%c%c ",(char)97+i,(char)97+j+i,(char)97+i));
            }
            System.out.println();
        }
    }
}

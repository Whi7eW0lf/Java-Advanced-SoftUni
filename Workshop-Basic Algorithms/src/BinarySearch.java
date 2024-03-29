import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int searchNum = Integer.parseInt(read.readLine());

        System.out.println(binarySearch(input, 0, input.length-1, searchNum));

    }

    private static int binarySearch(int[] array, int left, int right,int searchNum) {

        if (right >= left) {
            int middle = left + (right - left) / 2;

            if (array[middle] == searchNum)
                return middle;

            if (array[middle] > searchNum){
                return binarySearch(array, left, middle - 1, searchNum);
            }

            return binarySearch(array, middle + 1, right, searchNum);
        }

        return -1;
    }
}

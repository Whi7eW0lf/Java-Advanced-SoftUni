import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] rowCol = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        
        int [][] matrix = new int [rowCol[0]][rowCol[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int row = rowCol[0]-1;
        int col = rowCol[1]-1;

        while (row>=0){
            int r = row;
            int c = col;

            while (c<rowCol[1]&&r>=0){
                System.out.print(matrix[r--][c++]+" ");
            }
            System.out.println();

            col--;

            if (col==-1){
                col=0;
                row--;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String[] rotation = read.readLine().split("[()]");

        int row = 0;
        int col = 0;
        List<String> inputs = new ArrayList<>();

        String input;

        while(!"END".equals(input=read.readLine())){

            inputs.add(input);
            row++;

            if (input.length()>col){
                col=input.length();
            }
        }

        String[][] matrix = new String[row][col];
        fillMatrix(matrix,inputs);

        int degree = Integer.parseInt(rotation[1])%360;

        switch (degree){
            case 90:
                rotate90Degree(matrix);
                break;
            case 180:
                rotate180Degree(matrix);
                break;
            case 270:
                rotate270Degree(matrix);
                break;
            case 0:
                printMatrix(matrix);
                break;
        }
    }

    private static void fillMatrix(String[][] matrix, List<String> inputs) {
        for (int i = 0; i < matrix.length; i++) {
            String text = inputs.get(i);
            for (int j = 0; j < matrix[i].length; j++) {
                if (j<text.length()){
                    matrix[i][j] = String.valueOf(text.charAt(j));
                }else {
                    matrix[i][j] = " ";
                }
            }
        }
    }

    private static void printMatrix(String[][] matrix) {

        for (String[] element : matrix) {
            for (String secondElement : element) {
                System.out.print(secondElement);
            }
            System.out.println();
        }
    }

    private static void rotate90Degree( String[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = matrix.length-1; row >=0 ; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotate180Degree(String[][] matrix) {
        for (int rows = matrix.length-1; rows >=0; rows--) {
            for (int cols = matrix[rows].length-1; cols >= 0; cols--) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static void rotate270Degree(String[][] matrix) {
        for (int col = matrix[0].length-1; col >=0; col--) {
            for (String[] element : matrix) {
                System.out.print(element[col]);
            }
            System.out.println();
        }
    }
}

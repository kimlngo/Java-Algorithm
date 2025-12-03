package algo;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {

    public static void main(String[] args) {
        var matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);


        for (var row : matrix)
            System.out.println(Arrays.toString(row));
    }

    private static void rotate(int[][] matrix) {
        if(matrix.length == 1)
            return;
        flipVertical(matrix);
        transposeArr(matrix);
    }

    private static void transposeArr(int[][] matrix) {
        int len = matrix.length;
        int tmp;

        for (int row = 0; row < len - 1; row++) {
            for (int col = 0; col < len - 1 - row; col++) {
                tmp = matrix[row][col];
                matrix[row][col] = matrix[len - 1 - col][len - 1 - row];
                matrix[len - 1 - col][len - 1 - row] = tmp;
            }
        }
    }

    private static void flipVertical(int[][] matrix) {
        for (int[] row : matrix) {
            reverseArray(row);
        }
    }

    private static void reverseArray(int[] arr) {
        int tmp;
        int len = arr.length;

        for (int i = 0; i < len / 2; i++) {
            tmp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = tmp;
        }
    }
}

package algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {
        FloodFill sut = new FloodFill();

        var result = sut.floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 0);
        for (int[] ints : result) {
            for (int c = 0; c < result[0].length; c++) {
                System.out.print(ints[c] + " ");
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //Pseudocode
        //1) Get the original color of the pixel, store it as reference
        //Set the origin pixel to color
        final int origColor = image[sr][sc];
        final int m = image.length;
        final int n = image[0].length;

        //2) Create a Queue to store the points for processing
        Queue<Pixel> queue = new ArrayDeque<>();
        List<Pixel> processed = new ArrayList<>();
        queue.add(new Pixel(sr, sc));

        //3) Dequeue one by one and fill its neighbors, each filled neighbor is added back to the queue
        //if they are not there yet (to filter out the duplication)
        while (!queue.isEmpty()) {
            Pixel pixel = queue.poll();
            image[pixel.row()][pixel.col()] = color;
            processed.add(pixel);

            //get North neighbor
            if (pixel.row() - 1 >= 0 && image[pixel.row() - 1][pixel.col()] == origColor) {
                var north = new Pixel(pixel.row() - 1, pixel.col());
                if (!queue.contains(north) && !processed.contains(north))
                    queue.add(north);
            }

            //get South neighbor
            if (pixel.row() + 1 < m && image[pixel.row() + 1][pixel.col()] == origColor) {
                var south = new Pixel(pixel.row() + 1, pixel.col());
                if (!queue.contains(south) && !processed.contains(south))
                    queue.add(south);
            }

            //get West neighbor
            if (pixel.col() - 1 >= 0 && image[pixel.row()][pixel.col() - 1] == origColor) {
                var west = new Pixel(pixel.row(), pixel.col() - 1);
                if (!queue.contains(west) && !processed.contains(west))
                    queue.add(west);
            }

            //get East neighbor
            if (pixel.col() + 1 < n && image[pixel.row()][pixel.col() + 1] == origColor) {
                var east = new Pixel(pixel.row(), pixel.col() + 1);
                if (!queue.contains(east) && !processed.contains(east))
                    queue.add(east);
            }
        }
        //4) stop when queue is empty
        return image;
    }
}

record Pixel(int row, int col) {
}

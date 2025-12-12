package algo;

import java.util.*;
import java.util.stream.IntStream;

public class CourseScheduleII {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
//        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
//        System.out.println(Arrays.toString(findOrder(1, new int[][]{{}})));

//        System.out.println(Arrays.toString(findOrder(2, new int[][]{{}})));
        System.out.println(Arrays.toString(findOrder(3, new int[][]{{1, 0}})));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return IntStream.range(0, numCourses)
                            .toArray();
        }
        if (numCourses == 1)
            return new int[]{0};
        else if (numCourses == 2) {
            if (prerequisites.length == 1) {
                int[] preReq = prerequisites[0];
                return new int[]{preReq[1], preReq[0]};
            } else {
                return new int[]{};
            }
        }

        //result
        Set<Integer> courseOrder = new LinkedHashSet<>();

        //constructing a graph
        final Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pair : prerequisites) {
            if (pair.length == 2) {
                int main = pair[0];
                int pre = pair[1];

                graph.putIfAbsent(pre, new ArrayList<>());
                graph.get(pre)
                     .add(main);
            }
        }

        //last course
        graph.putIfAbsent(numCourses - 1, new ArrayList<>());

        //traverse a graph to find out the course sequence.
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0); //starting point

        while (!queue.isEmpty()) {
            Integer courseId = queue.poll();
            courseOrder.add(courseId);

            graph.putIfAbsent(courseId, new ArrayList<>());

            if (graph.get(courseId)
                     .stream()
                     .anyMatch(courseOrder::contains))
                return new int[]{};

            queue.addAll(graph.get(courseId)
                              .stream()
                              .filter(c -> !queue.contains(c))
                              .toList());
        }

        if (courseOrder.size() == numCourses)
            return courseOrder.stream()
                              .mapToInt(Integer::valueOf)
                              .toArray();
        else
            return new int[]{};
    }
}

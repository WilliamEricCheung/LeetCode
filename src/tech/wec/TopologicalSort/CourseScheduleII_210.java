package tech.wec.TopologicalSort;

import java.util.*;

public class CourseScheduleII_210 {



    // use topological sort
    private Map<Integer, List<Integer>> graph;
    private List<Integer> result;
    private Set<Integer> courses;

    // just return one of them
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        result = new ArrayList<>();
        if (prerequisites.length != 0) {
            buildGraph(prerequisites, inDegrees);
            courses = getAllCourse(prerequisites);
            List<Integer> rest = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                if (!courses.contains(i))
                    rest.add(i);
            }
            if (topologicalSort(prerequisites, inDegrees)) {
                result.addAll(rest);
                return result.stream().mapToInt(i -> i).toArray();
            }
            return new int[]{};
        }else {
            for (int i = 0; i < numCourses; i++)
                result.add(i);
            return result.stream().mapToInt(i->i).toArray();
        }
    }

    private void buildGraph(int[][] prerequisites, int[] inDegrees){
        for (int[] vertex: prerequisites){
            int n1 = vertex[1];
            int n2 = vertex[0];
            List<Integer> list = graph.getOrDefault(n1, new ArrayList<>());
            list.add(n2);
            graph.put(n1, list);
            inDegrees[n2]++;
        }
    }

    private boolean topologicalSort(int[][] prerequisites, int[] inDegrees){
        Queue<Integer> queue = new LinkedList<>();
        for (Integer i : courses) if (inDegrees[i] == 0) queue.offer(i);
        while(!queue.isEmpty()){
            int cur = queue.remove();
            result.add(cur);
            List<Integer> nexts = graph.get(cur);
            if (nexts != null && !nexts.isEmpty()){
                for (int i : nexts){
                    inDegrees[i]--;
                    if (inDegrees[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return result.size() == courses.size();
    }

    private Set<Integer> getAllCourse(int[][] prerequisites){
        Set<Integer> res = new HashSet<>();
        for (int[] pre : prerequisites){
            res.add(pre[0]);
            res.add(pre[1]);
        }
        return res;
    }
}

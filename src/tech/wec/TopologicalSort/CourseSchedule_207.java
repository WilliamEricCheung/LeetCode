package tech.wec.TopologicalSort;

import java.util.*;

public class CourseSchedule_207 {
    // use topological sort
    private Map<Integer, List<Integer>> graph;
    public boolean canFinish(int numCourses, int[][] prerequisites){
        graph = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        buildGraph(prerequisites, inDegrees);
        return topologicalSort(prerequisites, inDegrees);
    }

    private void buildGraph(int[][] prerequisites, int[] inDegrees){
        for (int[] vertex: prerequisites){
            int n1 = vertex[0];
            int n2 = vertex[1];
            List<Integer> list = graph.getOrDefault(n1, new ArrayList<>());
            list.add(n2);
            graph.put(n1, list);
            inDegrees[n2]++;
        }
    }

    private boolean topologicalSort(int[][] prerequisites, int[] inDegrees){
        Set<Integer> courses = getAllCourse(prerequisites);
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
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

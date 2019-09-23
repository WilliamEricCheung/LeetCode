package tech.wec.Google;

import java.util.*;

public class EvaluateDivision_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>(); // graph route
        double[] results = new double[queries.size()];
        for (int i = 0; i < values.length; i++){ // add node to node
            map.computeIfAbsent(equations.get(i).get(0), value->new HashMap<>()).put(equations.get(i).get(1), values[i]);
            map.computeIfAbsent(equations.get(i).get(1), value->new HashMap<>()).put(equations.get(i).get(0), 1.0/values[i]);
        }

        int i = 0;
        for (List<String> query : queries){
            String param1 = query.get(0);
            String param2 = query.get(1);
            if (!(map.containsKey(param1) && map.containsKey(param2)))
                results[i++] = -1.0;
            else{
                results[i] = dfs(map, param1, param2, 1.0, new HashSet<>());
                if (results[i] == Double.MAX_VALUE)
                    results[i] = -1.0;
                else{
                    map.get(param1).put(param2, results[i]);
                    map.get(param2).put(param1, 1.0/results[i]);
                }
                i++;
            }
        }
        return results;
    }

    private double dfs(Map<String, Map<String, Double>> map, String start, String end, double value, Set<String> visited){
        if (start.equals(end))
            return value;
        visited.add(start);
        if (map.get(start).containsKey(end))
            return value * map.get(start).get(end);
        Map<String, Double> entry = map.get(start);
        double result = Double.MAX_VALUE;
        for (Map.Entry<String, Double> e : entry.entrySet()){
            if (!visited.contains(e.getKey()))
                result = Math.min(dfs(map, e.getKey(), end, value * e.getValue(), visited), result);
        }
        visited.remove(start);
        return result;
    }
}

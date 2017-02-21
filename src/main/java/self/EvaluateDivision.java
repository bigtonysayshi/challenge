package self;

import java.util.*;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers.
 * If the answer does not exist, return -1.0.
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> nodeMap = new HashMap<>();
        Map<String, List<Double>> weightMap = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String start = equations[i][0];
            String end = equations[i][1];
            double weight = values[i];
            if (!nodeMap.containsKey(start)) {
                nodeMap.put(start, new ArrayList<>());
                weightMap.put(start, new ArrayList<>());
            }
            if (!nodeMap.containsKey(end)) {
                nodeMap.put(end, new ArrayList<>());
                weightMap.put(end, new ArrayList<>());
            }
            nodeMap.get(start).add(end);
            nodeMap.get(end).add(start);
            weightMap.get(start).add(weight);
            weightMap.get(end).add(weight != 0 ? 1.0/weight : 0);
        }
        double[] results = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Double result = findWeight(nodeMap, weightMap, new HashSet<>(), queries[i][0], queries[i][1], 1.0);
            results[i] = result != null ? result : -1.0;
        }
        return results;
    }

    private Double findWeight(Map<String, List<String>> nodeMap,
                              Map<String, List<Double>> weightMap,
                              Set<String> checkedNodes,
                              String start,
                              String end,
                              double baseWeight) {
        if (checkedNodes.contains(start)) return null;
        if (!nodeMap.containsKey(start)) return null;
        if (start.equals(end)) return baseWeight;
        checkedNodes.add(start);
        List<String> nodes = nodeMap.get(start);
        List<Double> weights = weightMap.get(start);
        for (int i = 0; i < nodes.size(); i++) {
            Double sub = findWeight(nodeMap, weightMap, checkedNodes, nodes.get(i), end, weights.get(i) * baseWeight);
            if (sub != null) {
                return sub;
            }
        }
        checkedNodes.remove(start);
        return null;
    }

    public static void main(String[] args){
        EvaluateDivision instance = new EvaluateDivision();
        System.out.println(Arrays.toString(instance.calcEquation(new String[][]{{"a","b"},{"b","c"}},
                new double[]{2.0, 3.0},
                new String[][]{{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}})));
    }
}

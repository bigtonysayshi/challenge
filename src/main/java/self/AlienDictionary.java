package self;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically
 * by the rules of this new language. Derive the order of letters in this language.
 * Note:
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {
    static  final int NUM_CHARS = 26;

    // BFS Solution
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Integer> degreeMap = new HashMap<>();
        Map<Character, Set<Character>> orderMap = new HashMap<>();

        // Construct degree map
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                degreeMap.put(word.charAt(i), 0);
            }
        }

        // Construct order map
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String current = words[i];
            int len = Math.min(prev.length(), current.length());
            for (int j = 0; j < len; j++) {
                char pc = prev.charAt(j);
                char cc = current.charAt(j);
                if (pc != cc) {
                    if (!orderMap.containsKey(pc)) {
                        orderMap.put(pc, new HashSet<>());
                    }
                    Set<Character> tails = orderMap.get(pc);
                    if (!tails.contains(cc)) {
                        tails.add(cc);
                        degreeMap.put(cc, degreeMap.getOrDefault(cc, 0) + 1);
                    }
                    break;
                }
            }
        }

        // BFS and construct result
        StringBuilder sb = new StringBuilder();
        Queue<Character> pool = new LinkedList<>();
        for (Character c : degreeMap.keySet()) {
            if (degreeMap.get(c) == 0) {
                pool.offer(c);
            }
        }
        while (!pool.isEmpty()) {
            Character c = pool.poll();
            sb.append(c);
            if (orderMap.containsKey(c)) {
                Set<Character> tails = orderMap.get(c);
                for (Character tail : tails) {
                    int degree = degreeMap.get(tail) - 1;
                    degreeMap.put(tail, degree);
                    if (degree == 0) {
                        pool.offer(tail);
                    }
                }
            }
        }
        String result = sb.toString();
        return result.length() == degreeMap.size() ? result : "";
    }


    // DFS Solution
    public String alienOrder2(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        boolean[][] edges = new boolean[NUM_CHARS][NUM_CHARS];
        int[] status = new int[NUM_CHARS];
        buildGraph(edges, status, words);

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < NUM_CHARS; i++) {
            if (status[i] == 1) {
                if (!dfs(edges, status, sb, i)) {
                    return "";
                }
            }
        }
        return sb.reverse().toString();
    }

    private void buildGraph(boolean[][] edges, int[] status, String[] words) {
        String current = words[0];
        for (char c : current.toCharArray()) {
            status[c - 'a'] = 1;
        }
        for (int i = 1; i < words.length; i++) {
            String prev = current;
            current = words[i];
            boolean diff = false;
            for (int j = 0; j < current.length(); j++) {
                if (!diff && j < prev.length() && current.charAt(j) != prev.charAt(j)) {
                    edges[prev.charAt(j) - 'a'][current.charAt(j) - 'a'] = true;
                    diff = true;
                }
                status[current.charAt(j) - 'a'] = 1;
            }
        }
    }

    private boolean dfs(boolean[][] edges, int[] status, StringBuilder sb, int start) {
        status[start] = 2;
        for (int i = 0; i < NUM_CHARS; i++) {
            if (edges[start][i]) {
                if (status[i] == 2) {
                    return false;
                }
                if (status[i] == 1) {
                    if (!dfs(edges, status, sb, i)) {
                        return false;
                    }
                }
            }
        }
        status[start] = 3;
        sb.append((char)('a' + start));
        return true;
    }



    public static void main(String[] args){
        AlienDictionary instance = new AlienDictionary();
        System.out.println(instance.alienOrder(new String[]{
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"}));
        System.out.println(instance.alienOrder(new String[]{
                "z",
                "x",
                "z"}));
        System.out.println(instance.alienOrder(new String[]{
                "z",
                "x"}));
    }
}

package self;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 */
public class StrobogrammaticNumber2 {
    public List<String> findStrobogrammatic(int n) {
        Queue<StringBuilder> queue = new LinkedList<>();
        int i = n % 2;
        if (i == 1) {
            queue.add(new StringBuilder("0"));
            queue.add(new StringBuilder("1"));
            queue.add(new StringBuilder("8"));
        } else {
            queue.add(new StringBuilder(""));
        }
        for (; i < n; i += 2) {
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                StringBuilder sub = queue.poll();
                if (i + 2 < n) {
                    queue.add(new StringBuilder(sub).insert(0, "0").append("0"));
                }
                queue.add(new StringBuilder(sub).insert(0, "1").append("1"));
                queue.add(new StringBuilder(sub).insert(0, "8").append("8"));
                queue.add(new StringBuilder(sub).insert(0, "6").append("9"));
                queue.add(new StringBuilder(sub).insert(0, "9").append("6"));
            }
        }
        return queue.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }

    public static void main(String[] args){
        StrobogrammaticNumber2 instance = new StrobogrammaticNumber2();
        System.out.println(instance.findStrobogrammatic(2));
        System.out.println(instance.findStrobogrammatic(3));
        System.out.println(instance.findStrobogrammatic(4));
    }
}

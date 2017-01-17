package self;

import java.util.HashSet;
import java.util.Set;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    // Time: O(n) Space:O(n)
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }

    private boolean isPrime(int n, Set<Integer> primes) {
        if (n == 1) return false;
        for (int p : primes) {
            if (n % p == 0) {
                return false;
            }
        }
        primes.add(n);
        return true;
    }

    public static void main(String[] args){
        CountPrimes instance = new CountPrimes();
        System.out.println(instance.countPrimes(1));
        System.out.println(instance.countPrimes(2));
        System.out.println(instance.countPrimes(10));
        System.out.println(instance.countPrimes(100));
    }
}

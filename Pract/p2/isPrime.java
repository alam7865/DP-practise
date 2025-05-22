import java.util.*;

public class isPrime {
    public static boolean isPrimes(int num) {
        int len = (int) Math.sqrt(num);
        for (int i = 2; i <= len; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // int num = 17;
        // boolean ans = isPrimes(num);
        // System.out.println("IsPrime :" + ans);

        boolean prime[] = new boolean[19 + 1];
        int left = 10;
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int p = 2; p * p <= 19; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= 19; i += p) {
                    prime[i] = false;
                }
            }
        }

        int res[] = { -1, -1 };
        int res1[] = { -1, -1 };
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prime.length; i++) {
            if (i >= left && prime[i] == true) {
                if (res[0] == -1) {
                    res[0] = i;
                } else if (res[1] == -1) {
                    res[1] = i;
                } else {
                    int diff = res[1] - res[0];
                    if (min > diff) {
                        min = diff;
                        res1[0] = res[0];
                        res1[1] = res[1];
                    } else {
                        if (min != Integer.MAX_VALUE) {
                            res[0] = res[1];
                            res[1] = i;
                        }
                    }

                }
            }
        }

        System.out.println(Arrays.toString(prime));
        System.out.println(res1[0] + " " + res1[1]);
    }
}

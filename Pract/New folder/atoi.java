import java.util.*;

public class atoi {
    public static void main(String[] args) {
        String str = "  123";
        str = str.trim();
        System.out.println(str);
    }
}

// public class Solution {

public static int powerSolution(String A) {
    java.math.BigInteger a = new java.math.BigInteger(A);
    if (a.compareTo(java.math.BigInteger.ONE) == 0 || a.compareTo(java.math.BigInteger.ZERO) == 0)
        return 0;
    for (int i = 0; i < a.bitLength() - 1; i++) {
        if (a.testBit(i))
            return 0;
    }
    return a.testBit(a.bitLength() - 1) ? 1 : 0;
}
// public int power(String A) {
// /*int n=Integer.parseInt(A);
// boolean b= n>0 && (1073741824 % n == 0);
// if(b)
// return 1;
// else
// return 0;
// */
// /*int N = Integer.parseInt(A);
// if(N % 2 != 0)
// return 0;
// while(N >= 1){
// N = N/2;
// if(N % 2 != 0 && N != 1)
// return 0;
// }
// return 1;
// */
// return(powerSolution(A));
// }
// }
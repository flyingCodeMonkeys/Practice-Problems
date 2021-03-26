package PDRI;

public class Challenge {
    public static long multiply(long a, long b) {
        long result = 0;
        if(a == 0 || b == 0){
            return 0;
        }

        if(a > 0 && b > 0) {
            return (a + multiply(a, b - 1));
        }

        if(a < 0 && b < 0) {
            return -(a - multiply(a, b + 1));
        }

        if(a < 0 ^ b < 0) {
            return -multiply(-a, b);
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(multiply(-4, -3));

    }
}

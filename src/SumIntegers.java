public class SumIntegers {
    public static long sum_A(int n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static long sum_B(int n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            for (long j = i; j > 0; j--) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public static long sum_C(int n) {
        if (n <= 0) {
            return 0;
        }
        return (long) n * (n + 1L) / 2;
    }

    public static void main(String[] args) {
        int n = 10000;
        long startTime = System.nanoTime();
        long sumA = sum_A(n);
        long elapsedA = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        long sumB = sum_B(n);
        long elapsedB = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        long sumC = sum_C(n);
        long elapsedC = System.nanoTime() - startTime;

        System.out.println("Time taken by sum_A: " + elapsedA + " nanoseconds");
        System.out.println("Time taken by sum_B: " + elapsedB + " nanoseconds");
        System.out.println("Time taken by sum_C: " + elapsedC + " nanoseconds");

        System.out.println("Sum A: " + sumA);
        System.out.println("Sum B: " + sumB);
        System.out.println("Sum C: " + sumC);
    }
}

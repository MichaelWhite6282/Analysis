import java.util.function.LongSupplier;

public class SumAnalysis {
    private static final int[] INPUTS = {1, 10, 100, 1_000, 10_000, 100_000, 1_000_000};
    private static volatile long lastResult;

    private static long measure(LongSupplier operation) {
        long startTime = System.nanoTime();
        lastResult = operation.getAsLong();
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        System.out.printf("%-12s %15s %15s %15s%n", "n", "sum_A (ns)", "sum_B (ns)", "sum_C (ns)");
        System.out.println("----------------------------------------------------------------");

        for (int n : INPUTS) {
            long timeA = measure(() -> SumIntegers.sum_A(n));
            long timeB = measure(() -> SumIntegers.sum_B(n));
            long timeC = measure(() -> SumIntegers.sum_C(n));

            System.out.printf("%-12d %15d %15d %15d%n", n, timeA, timeB, timeC);
        }

        System.out.println();
        System.out.println("Estimated growth rates:");
        System.out.println("sum_A: O(n) - one loop iterates from 1 through n.");
        System.out.println("sum_B: O(n^2) - the nested loops perform n(n + 1) / 2 iterations.");
        System.out.println("sum_C: O(1) - the formula uses a fixed number of arithmetic operations.");
    }
}

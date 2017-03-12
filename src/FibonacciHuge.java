import java.util.*;

public class FibonacciHuge {
    public static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    public static long getFibonacciHugeFast(long n, long m) {
        if (n <= 1)
            return n;

        List<Integer> pisanoPeriod = getPisanoPeriod((int)m);
        long remainder = n % pisanoPeriod.size();

        return pisanoPeriod.get((int)remainder);
    }

    public static List<Integer> getPisanoPeriod(int m) {

        if (m == 2)
            return new ArrayList<Integer>() {{add(0);add(1);add(1);}};

        ArrayList<Integer> F = new ArrayList<>();
        F.add(0);
        F.add(1);
        F.add(1);
        F.add(2);

        int i = 4;
        while(true) {
            if (F.get(i-2) == 0 && F.get(i-1) == 1)
                return F.subList(0,i-2);
            F.add((F.get(i-1) + F.get(i-2)) % m);
            i++;
        }

    }


        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeFast(n, m));
    }
}


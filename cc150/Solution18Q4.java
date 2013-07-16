class Solution18Q4 {
    public int numberOf2sInRange(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            count += numberOf2s(i);
        }
        return count;
    }

    private int numberOf2s(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 2) {
                count++;
            }
            n /= 10;
        }
        return count;
    }

    public int count2sInRangeFast(int n) {
        assert(n > 0);

        int count = 0;
        int len = countDigits(n);

        for (int digit = 0; digit < len; digit++) {
            count += count2sInRangeAtDigit(n, digit);
        }

        return count;
    }

    private int countDigits(int n) {
        if (n == 0) return 1;

        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    private int count2sInRangeAtDigit(int n, int d) {
        int powerOf10 = (int) Math.pow(10, d);
        int digit = (n / powerOf10) % 10;
        int left = n / (powerOf10 * 10);
        int right = n % powerOf10;

        if (digit < 2) {
            return left * powerOf10;
        } else if (digit == 2) {
            return left * powerOf10 + right + 1;
        } else {
            return (left + 1) * powerOf10;
        }
    }
}


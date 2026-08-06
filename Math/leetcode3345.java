package Math;

class Solution {

    public int product(int n, int t) {

        int p = 1;
        int x = n;

        while (x > 0) {
            p *= x % 10;
            x /= 10;
        }

        if (p % t == 0)
            return n;

        return product(n + 1, t);
    }

    public int smallestNumber(int n, int t) {
        return product(n, t);
    }
}
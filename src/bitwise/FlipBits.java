package bitwise;

public class FlipBits {
    static int flipBits(int n) {
        int i = 0, ans = 0;
        while (n > 0) {
            int bit = ((n & 1) ^ 1);
            ans |= bit << i++;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println("ones compliment of " + n + " is " + flipBits(n));
    }
}

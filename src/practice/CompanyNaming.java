package practice;

public class CompanyNaming {
    static int callCounter = 1;

    static int companyNaming(String s1, String s2) {
        int commonLength = lcs(s1, s2, 0, 0);
        return s1.length() + s2.length() - commonLength;
    }

    static Integer[][] dp;

    static int lcs(String s1, String s2, int i, int j) {
        System.out.println("call number: " + callCounter++);
        if (i >= s1.length() || j >= s2.length()) return 0;

        if (dp[i][j] != null) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + lcs(s1, s2, i + 1, j + 1);

        int a = lcs(s1, s2, i + 1, j);
        int b = lcs(s1, s2, i, j + 1);

        return dp[i][j] = Math.max(a, b);
    }

    public static void main(String[] args) {
        String name1 = "penguin";
        String name2 = "engine";

//        p eng u in e

//        word1 + word2 - common

        dp = new Integer[name1.length() + 1][name2.length() + 1];
        int ans = companyNaming(name1, name2);
        System.out.println(ans);
    }
}

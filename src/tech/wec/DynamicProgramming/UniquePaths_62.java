package tech.wec.DynamicProgramming;

public class UniquePaths_62 {
    // Combination(m+n-2, m-1)
    public int uniquePaths(int m, int n) {
        int above = m - 1;
        int sum = m + n - 2;
        long ans = 1;
        int j = 1;
        for (int i = above+1; i <= sum ;i++){
            ans *= i;
            while(j<=n-1 && ans % j == 0){
                ans /= j;
                j++;
            }
        }
        return (int)ans;
    }
}

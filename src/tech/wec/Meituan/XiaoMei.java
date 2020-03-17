package tech.wec.Meituan;

import java.util.Scanner;

/*
数组共有n个元素，每个元素范围从L到R(包括边界点),所有元素之和为k的倍数，请问有多少个这样的数组？
（结果对取余数）


首先将从L到R中的每个数对k取余数，把余数相同的数分为一组，这样就可以把从L到R中所有的数分成k组了，
使用一个数组f[0,...,k-1]记录余数为0,...,k-1的组的个数。
假设使用dp[i][j]代表第前i个数之和除以k余j的种数，那么递推方程为
dp[i][j] = Sum(dp[i-1][t]*f[(j-t+k)%k], t is {0,1,...,k-1})
注意到第t组中任意一个数只有和第(j-t)%k组中任意一个数相加后除以k的余数才是j，最后dp[n][0]就是结果
 */
public class XiaoMei {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            double mod = 1e9;
            double[][] dp = new double[2][100]; // 只和前面的状态有关
            long[] count = new long[10];
            int n = input.nextInt();
            int k = input.nextInt();
            int L = input.nextInt();
            int R = input.nextInt();
            int num = (R - L + 1) / k;
            for (int i = 0; i < k; i++) count[i] = num;
            for (int i = num * k + L; i < R; i++) count[i % k]++; // 统计从L到R中除以k余i的数的个数
            for (int i = 0; i < k; i++) dp[0][i] = count[i];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < k; j++){
                    dp[1][j] = 0;
                    for (int t = 0; t < k; t++)
                        dp[1][j] = (dp[1][j] + dp[0][t] * count[(j - t + k) % k]) % mod;
                }
                for (int j = 0; j < k; j++)
                    dp[0][j] = dp[1][j];
            }
            System.out.println(dp[0][0]);
        }
    }
}

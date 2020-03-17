package tech.wec.Meituan;

import java.util.Scanner;

/**
 有一个2*n的网络，有一个人位于（1,1）的位置，即左上角，他希望从左上角走到右下角，即（2,n）的位置，在每一次，他可以进行三种操作中的一种：
 1.向右走一格，即从（x,y）到（x,y+1）
 2.向右上方走一格，即如果他在（2,y）的位置可以走到（1,y+1）
 3.向右下方走一格，即如果他在（1,y）的位置可以走到（2,y+1）
 问题当然不会这么简单，在这2*n的格子中，有一部分格子上有障碍物，他不能停在障碍物上，当然也不能走出网格，请问他有多少种不同搞得路线可以到达（2,n)

 输入：
 输入第一行仅包含一个正整数n，表示网格的长度（1<=n<=50）
 接下来有2行，每行n个字符，“X”代表障碍物，“.”代表可以停留

 输出：
 如果没有可以到达的路线则输出-1，否则输出方案数量

 样例输入：
 5
 ..X.X
 XX...

 样例输出：
 2
 */
public class ShuangXingDao {

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while(input.hasNextLine()){
//            int n = Integer.parseInt(input.nextLine());
//            String[] lines = new String[2];
//            for (int i = 0; i < 2; i++){
//                lines[i] = input.nextLine();
//            }
//            char[][] graph = new char[2][n];
//            for (int i = 0; i < 2; i++){
//                for (int j = 0; j < n; j++){
//                    graph[i][j] = lines[i].charAt(j);
//                }
//            }
//            long ans = 1;
//            if (n == 1 || graph[0][0] == 'X' || graph[1][n-1] == 'X')
//                ans = -1;
//            else{
//                for (int i = 1; i < n - 1; i++){
//                    if (graph[0][i] == 'X' && graph[1][i] == 'X'){
//                        ans = -1;
//                        break;
//                    }
//                    if (graph[0][i] == '.' && graph[1][i] == '.')
//                        ans *= 2;
//                }
//            }
//            System.out.println(ans);
//        }
//    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            int n = Integer.parseInt(input.nextLine());
            String[] lines = new String[2];
            for (int i = 0; i < 2; i++) {
                lines[i] = input.nextLine();
            }
            char[][] graph = new char[2][n];
            int[][] dp = new int[2][n];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = lines[i].charAt(j);
                }
            }
            if (graph[1][n - 1] == '.')
                dp[1][n - 1] = 1;
            for (int col = n - 1; col >= 0; col--){
                if (graph[0][col] == 'X' && graph[1][col] == 'X')
                    break;
                for (int i = 0; i < 2; i++){
                    if (graph[i][col] == '.')
                        dp[i][col] = i == 0? dp[i][col + 1] + dp[i + 1][col + 1]: dp[i][col + 1] + dp[i - 1][col + 1];
                }
            }
            if (dp[0][0] == 0 || graph[0][0] == 'X' || graph[1][n - 1] == 'X')
                System.out.println(-1);
            else
                System.out.println(dp[0][0]);
        }
    }
}

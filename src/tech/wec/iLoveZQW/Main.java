package tech.wec.iLoveZQW;

import com.sun.source.tree.IfTree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            PriorityQueue<Long> a = new PriorityQueue<>((aa, bb) ->(int)(bb-aa));
            PriorityQueue<Long> b = new PriorityQueue<>((aa, bb) ->(int)(bb-aa));
            for (int i = 0; i < n; i++)
                a.offer(input.nextLong());
            for (int i = 0; i < n; i++)
                b.offer(input.nextLong());
            int num = 3;
            int sumA = 0;
            while(a.size() > 0 && num-- > 0){
                sumA += a.poll();
            }
            num = 3;
            int sumB = 0;
            while(b.size() > 0 && num-- > 0){
                sumB += b.poll();
            }
            System.out.println(Math.max(sumA, sumB));
        }
    }
}

//    private static List<List<Integer>> permutations;
//    private static int n;
//    private static int k;
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while(input.hasNext()) {
//            n = input.nextInt();
//            k = input.nextInt();
//            permutations = new ArrayList<>();
//            getPermutations(n, new ArrayList<>());
//            printPermutations();
//        }
//    }
//
//    public static void printPermutations() {
//        System.out.println(permutations.size());
//        for (List<Integer> per: permutations) {
//            StringBuilder sb = new StringBuilder();
//            for (Integer i: per) {
//                while(i-- > 0) {
//                    sb.append("*");
//                }
//                sb.append("|");
//            }
//            sb.deleteCharAt(sb.length() - 1); // delete last "|"
//            System.out.println(sb.toString());
//        }
//    }
//
//    public static boolean good(List<Integer> temp, int n){
//        int sum = 0;
//        for (Integer i: temp) sum += i;
//        return sum == n;
//    }
//
//    public static void print(){
//        for (List<Integer> temp: permutations){
//            System.out.println(Arrays.toString(temp.toArray()));
//        }
//    }
//
//    /** DFS
//     * @param remain remain candies
//     * @param temp temporary permutation
//     */
//    public static void getPermutations(int remain, List<Integer> temp) {
//        if (temp.size() == k){
//            // System.out.println("*********temp***********\n"+ Arrays.toString(temp.toArray()));
//            if (good(temp, n)) permutations.add(new ArrayList<>(temp));
//            return;
//        }
//        else {
//            for (int i = remain; i >= 0; i--) {
//                temp.add(i);
//                getPermutations(remain - i, temp); // run into next index, and update remains
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }
//
//}

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = 0;
//        while(input.hasNext()) {
//            n = input.nextInt();
//            String[] befores = new String[n];
//            String[] afters = new String[n];
//            for (int i = 0; i < n; i++)
//                befores[i] = input.next();
//            int ans = 0;
//            for (int i = 0; i < n; i++) {
//                afters[i] = input.next();
//                ans += minDistance(befores[i], afters[i]);
//            }
//            System.out.print(ans);
//        }
//    }
//    public static int minDistance(String word1, String word2) {
//        int m = word1.length();
//        int n = word2.length();
//        int[][] dp = new int[m+1][n+1];
//        for (int i = 0; i<=m; i++)
//            dp[i][0] = i;
//        for (int i = 0; i <= n; i++)
//            dp[0][i] = i;
//        for (int i =1;i<=m;i++){
//            for (int j = 1;j <=n;j++){
//                int left = dp[i-1][j];
//                int down = dp[i][j-1];
//                int leftDown = dp[i-1][j-1];
//                if (word1.charAt(i-1) == word2.charAt(j-1))
//                    dp[i][j] = 1 + Math.min(left, Math.min(down, leftDown - 1));
//                else
//                    dp[i][j] = 1 + Math.min(left, Math.min(down, leftDown));
//            }
//        }
//        return dp[m][n];
//    }
//}

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = 0;
//        while (input.hasNext()) {
//            n = input.nextInt();
//            int[][] matrix = new int[n][n];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    matrix[i][j] = input.nextInt();
//                }
//            }
//            int m = input.nextInt() % 4;
//            for (int i = 1; i <= m; i++)
//                rotate(matrix);
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (j != n - 1)
//                        System.out.print(matrix[i][j] + " ");
//                    else
//                        System.out.print(matrix[i][j] + "\n");
//                }
//            }
//        }
//    }
//
//    public static void rotate(int[][] matrix) {
//        int n = matrix.length - 1;
//        for (int i = 0;i<=(n-1)/2;i++){
//            for (int j = 0;j<=n/2;j++){
//                int tmp = matrix[i][j];
//                matrix[i][j] = matrix[n - j][i]; // bottom to left
//                matrix[n-j][i] = matrix[n-i][n-j]; // right to bottom
//                matrix[n-i][n-j] = matrix[j][n-i]; // top to right
//                matrix[j][n-i] = tmp; // left to top
//            }
//        }
//    }
//}




































//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while(input.hasNextLine()){
//            String line = input.nextLine();
//            Map<Character, Integer> map = new HashMap<>();
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < line.length(); i++){
//                if (!map.containsKey(line.charAt(i))){
//                    sb.append(line.charAt(i));
//                    map.put(line.charAt(i), i);
//                }
//            }
//            System.out.println(sb.toString());
//        }
//    }

//    private static String baseString(int num,int base) {
//        String str = "", digit = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        if (num == 0) {
//            return "";
//        } else {
//            str = baseString(num / base, base);
//            return str + digit.charAt(num % base);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while(input.hasNext()){
//            long a = input.nextLong();
//            long b = input.nextLong();
//            System.out.println(a + b);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while(input.hasNextLine()){
//            String[] strs = input.nextLine().split(",");
//            Arrays.sort(strs);
//            for (int i = 0; i < strs.length; i++){
//                if (i != strs.length - 1)
//                    System.out.print(strs[i]+ ",");
//                else
//                    System.out.print(strs[i] + "\n");
//            }
//        }
//    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while(input.hasNextLine()){
//            String[] strs = input.nextLine().split(" ");
//            Arrays.sort(strs);
//            for (int i = 0; i < strs.length; i++){
//                if (i != strs.length - 1)
//                    System.out.print(strs[i]+ " ");
//                else
//                    System.out.print(strs[i] + "\n");
//            }
//        }
//    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        String[] strs = new String[n];
//        for (int i = 0; i < n; i++){
//            strs[i] = input.next();
//        }
//        Arrays.sort(strs);
//        for (int i = 0; i < n; i++){
//            if (i != n - 1)
//                System.out.print(strs[i]+ " ");
//            else
//                System.out.print(strs[i]);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while(input.hasNextLine()){
//            String line = input.nextLine();
//            String[] nums = line.split(" ");
//            int sum = 0;
//            for (String num: nums){
//                sum += Integer.parseInt(num);
//            }
//            System.out.println(sum);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = 0;
//        while(input.hasNext()) {
//            n = input.nextInt();
//            int sum = 0;
//            while (n-- > 0) {
//                sum += input.nextInt();
//            }
//            System.out.println(sum);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int t = input.nextInt();
//        while(t-- > 0){
//            int n = input.nextInt();
//            int sum = 0;
//            while(n-- > 0){
//                sum += input.nextInt();
//            }
//            System.out.println(sum);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = -1;
//        while((n = input.nextInt()) != 0){
//            int sum = 0;
//            while(n-- > 0){
//                sum += input.nextInt();
//            }
//            System.out.println(sum);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while(input.hasNextLine()){
//            String line = input.nextLine();
//            if (!line.equals("")){
//                long a = Long.parseLong(line.split(" ")[0]);
//                long b = Long.parseLong(line.split(" ")[1]);
//                System.out.println(a + b);
//            }
//        }
//    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int t = Integer.parseInt(input.next());
//        if (t > 100 || t < 1) return;
//        while(t-- > 0 && input.hasNextLine()){
//            String line = input.nextLine();
//            int a = input.nextInt();
//            int b = input.nextInt();
//            if (a < 1 || a > 1e9 || b < 1 || b > 1e9) return;
//                System.out.println(a + b);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while(input.hasNextLine()){
//            String line = input.nextLine();
//            long a = Long.parseLong(line.split(" ")[0]);
//            long b = Long.parseLong(line.split(" ")[1]);
//            if (a == 0 && b == 0) return;
//            System.out.println(a + b);
//        }
//    }

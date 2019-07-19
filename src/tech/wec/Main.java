package tech.wec;

import java.util.*;

public class Main {

//    public static void main(String[] args) {
        // write your code here
//        Solution solution = new Solution();
//        System.out.println(solution.addDigits(38));
//        System.out.println("hello, world");
//    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        if (s == null && s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = findCenterLength(s, i, i);
            int len2 = findCenterLength(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        System.out.println(start + " " + end);
        return s.substring(start, end + 1);
    }

    public int findCenterLength(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public int mySqrt(int x) {
        long t = x;
        t = 0x5f3759df - (t >> 1);
        if (t < 2)
            return (int) t;
        else {
            while (t * t > x) {
                t = (t + x / t) / 2;
            }
            return (int) t;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class MinStack {

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (minStack.isEmpty() || x < minStack.peek())
                minStack.push(x);
            else
                minStack.push(minStack.peek());
            stack.push(x);
        }

        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        else if ((n & (n - 1)) == 0)
            return true;
        else
            return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }

    public int addDigits(int num) {
        if (num <= 9)
            return num;
        StringBuilder str = new StringBuilder();
        str.append(num);
        int tmp = 0;
        for (int i = 0; i < str.length(); i++) {
            tmp += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return addDigits(tmp);
    }

//    public boolean isHappy(int n) {
//        while (n != 1) {
//            n = sum(n);
//            if (n == 4)
//                return false;
//        }
//        return true;
//    }

//    public int sum(int n) {
//        int loc = 0;
//        int res = 0;
//        while (n) {
//            loc = n % 10;
//            res += loc * loc;
//            n /= 10;
//        }
//        return res;
//    }

    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        long sum = n * (n + 1) / 2;
        long numSum = 0;
        for (int i : nums
        ) {
            numSum += i;
        }
        return (int) (sum - numSum);
    }

    public int fib(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return fib(N - 1) + fib(N - 2);
    }

    public int hammingDistance(int x, int y) {
        int ans = x ^ y;
        int cnt = 0;
        while (ans / 2 != 0 && ans != 1) {
            if (ans % 2 != 0)
                cnt++;
            ans /= 2;
        }
        if (ans == 1)
            cnt++;
        return cnt;
    }

    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        func(S, 0);
        return ans;
    }

    public void func(String str, int len) {
        if (len == str.length()) {
            ans.add(str);
            return;
        }
        func(str, len + 1);
        char[] status = str.toCharArray();
        if (str.charAt(len) >= 'a' && str.charAt(len) <= 'z') {
//            str.charAt(len) = (char)(str.charAt(len)  - 'a' + 'A');
            status[len] = (char) (status[len] - 'a' + 'A');
            System.out.println(status[len]);
            String string = Arrays.toString(status).replaceAll("[\\[\\]\\s,]", "");
            System.out.println(string);
            func(string, len + 1);
        } else if (str.charAt(len) >= 'A' && str.charAt(len) <= 'Z') {
            status[len] = (char) (status[len] - 'A' + 'a');
            String string = Arrays.toString(status).replaceAll("[\\[\\]\\s,]", "");
            func(string, len + 1);
        }
    }

    public int[] diStringMatch(String S) {
        int low = 0;
        int high = S.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I')
                list.add(low++);
            if (S.charAt(i) == 'D')
                list.add(high--);
        }
        list.add(high);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int trap(int[] height) {
        int n = height.length;
        if (height == null || n <= 0)
            return 0;
        // left[i] == i左边最大值，right[i] == i右边最大值
        int[] left = new int[n];
        left[0] = height[0];
        int[] right = new int[n];
        right[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            int level = Math.min(left[i], right[i]);
            water += Math.max(0, level - height[i]);
        }
        return water;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        while (root.left != null || root.right != null) {
            if (root.val < val)
                root = root.left;
            else if (root.val > val)
                root = root.right;
            else
                return root;
        }
        return null;
    }

    public String convertToBase7(int num) {
        int res = 0;
        double cur = 0;
        while (num / 7 != 0) {
            res = res + (num % 7) * (int) Math.pow(10, cur);
            num /= 7;
            cur++;
        }
        res = res + (num % 7) * (int) Math.pow(10, cur);
        return String.valueOf(res);
    }

    public int findPairs(int[] nums, int k) {
        // ascend nums
        Arrays.sort(nums);
        int len = nums.length;
        int cnt = 0;
        // key is i, value is j
        Map<Integer, Integer> map = new HashMap<>();
        // map.put(nums[0], nums[0]);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] - nums[i] == k) {
                    if (!(map.containsKey(nums[i]) && map.containsValue(nums[j]) && map.get(nums[i]) == nums[j])) {
                        map.put(nums[i], nums[j]);
                        cnt++;
                    }
                }
                // System.out.println(map);
            }
        }
        return cnt;
    }

    public String convertToTitle(int n) {
        StringBuilder str = new StringBuilder();
        while (n / 26 != 0) {
//            res = res + (n % 26) * (int) Math.pow(10, cur);
            str.insert(0, (char) (n % 26 + 'A' - 1));
            n /= 26;
        }
//        res = res + (n % 26) * (int) Math.pow(10, cur);
        str.insert(0, (char) (n % 26 + 'A' - 1));
        return str.toString();
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        List<String> list = new ArrayList<>();
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            // list1 有与 list2 相同的
            if (map.get(list2[i]) != null) {
                // 两个list的index和为当前最小
                if (map.get(list2[i]) + i < len) {
                    list.clear();
                    list.add(list2[i]);
                    len = map.get(list2[i]) + i;
                    // 存在相同的index和
                } else if (map.get(list2[i]) + i == len) {
                    list.add(list2[i]);
                }
            }
        }
        String[] str = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            str[i] = list.get(i);
        return str;
    }

    public String findLongestWord(String s, List<String> d) {
        int len = d.size();
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 相同长度下比较字符大小
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o2.length() - o1.length();
            }
        });

        for (String dd : d
        ) {
            int p1 = 0;
            int p2 = 0;
            while (p1 < s.length() && p2 < dd.length()) {
                if (s.charAt(p1) == dd.charAt(p2)) {
                    p1++;
                    p2++;
                } else
                    p1++;
            }
            if (p2 == dd.length())
                return dd;
        }
        return "";
    }

    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            min = min < nums[i] ? min : nums[i];
            min = min < nums[j] ? min : nums[j];
        }
        return min;
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }


    protected double radius;
    protected double x_center;
    protected double y_center;

    /**
     * x = x_center + radius * cos θ * rand(1)
     * y = y_center + radius * sin θ * rand(1)
     * rand θ and rand 1 to get the result
     *
     * @param radius
     * @param x_center
     * @param y_center
     */
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double r = Math.sqrt(Math.random()) * radius;
        double theta = Math.PI * 2 * Math.random();
        double[] res = new double[2];
        res[0] = Math.cos(theta) * r + x_center;
        res[1] = Math.sin(theta) * r + y_center;
        return res;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> root1Leaves = DFS(root1);
        ArrayList<Integer> root2Leaves = DFS(root2);

        printLeaves(root1Leaves);
        printLeaves(root2Leaves);

        if (root1Leaves.size() != root2Leaves.size())
            return false;
        int size = root1Leaves.size();
        for (int i = 0; i < size; i++) {
            if (root1Leaves.get(i).equals(root2Leaves.get(i)))
                return false;
        }
        return true;
    }

    public void printLeaves(ArrayList<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i) + " ");
        }
    }

    class Node {
        int val;
        boolean isLeaf;
    }

    public ArrayList<Integer> BST(TreeNode root) {
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            if (node.left == null && node.right == null) {
                Node tmp = new Node();
                tmp.val = node.val;
                tmp.isLeaf = true;
                list.add(tmp);
            } else {
                Node tmp = new Node();
                tmp.val = node.val;
                tmp.isLeaf = false;
                list.add(tmp);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isLeaf) {
                res.add(list.get(i).val);
            }
        }
        return res;
    }

    public ArrayList<Integer> DFS(TreeNode root) {
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            if (node.left == null && node.right == null) {
                Node tmp = new Node();
                tmp.val = node.val;
                tmp.isLeaf = true;
                list.add(tmp);
            } else {
                Node tmp = new Node();
                tmp.val = node.val;
                tmp.isLeaf = false;
                list.add(tmp);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isLeaf) {
                res.add(list.get(i).val);
            }
        }
        return res;
    }

    public String largestNumber(int[] nums) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                // String.comparaTo == s2 - s1
                // 合并后的String降序排列
                return s2.compareTo(s1);
            }
        };
        if (nums == null || nums.length < 1) {
            return "";
        }
        // nums数组转化为String数组
        String[] numArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numArray[i] = String.valueOf(nums[i]);
        }
        Collections.sort(Arrays.asList(numArray), comparator);
        if (numArray[0].charAt(0) == '0')
            return "0";
        StringBuilder builder = new StringBuilder();
        for (String str : numArray
        ) {
            builder.append(str);
        }
        return builder.toString();
    }

    public int[] sortedSquares(int[] A) {
        int len = A.length;
        for (int i = 0; i < len; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public void wiggleSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        if (nums.length == 2) {
            Arrays.sort(nums);
            return;
        }
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i * 2 < nums.length) {
                res[i * 2] = nums[i];
            } else {
                if (nums.length % 2 == 0) {
                    res[(i - nums.length / 2) * 2 + 1] = nums[i];
                } else {
                    res[(i - nums.length / 2 - 1) * 2 + 1] = nums[i];
                }
            }
        }
        for (int i = 0; i < nums.length; i++)
            nums[i] = res[i];
    }

    public int monotoneIncreasingDigits(int N) {
        if (N<10)
            return N;
        String n = String.valueOf(N);
        StringBuilder res = new StringBuilder();
        for (int i =0;i<n.length()-1;i++){
            if (n.charAt(i)<=n.charAt(i+1)){
                res.append(n.charAt(i));
                if (i == n.length() - 2){
                    res.append(n.charAt(i+1));
                    return Integer.valueOf(res.toString());
                }
            }else{
                res.append(n.charAt(i)-'1');
                for (int j = i+1;j<n.length();j++)
                    res.append('9');
                break;
            }
        }
        return monotoneIncreasingDigits(Integer.valueOf(res.toString()));
    }


    public List<Integer> splitIntoFibonacci(String S) {
        /**
         使用一个辅助List保存可行的序列, 在回溯过程中发现返回List不为空
         说明有一种满足的序列产生提前终止回溯
         **/
        List<Integer> ret = new ArrayList<>();
        bktrace(S, ret, new ArrayList<>(), 0);
        return ret;
    }

    private void bktrace(String s, List<Integer> ret, List<Integer> temp, int st) {
        // 提前终止回溯
        if(ret.size() != 0) return;
        if(st == s.length() && temp.size() >= 3) {
            ret.addAll(temp);
            return;
        }
        for(int i = st; i < s.length(); ++i) {
            // 每块数组除非为0否则不能以0开头
            if(s.charAt(st) == '0' && i > st)
                break;
            // 每块数字不超过2^31-1
            long num = Long.parseLong(s.substring(st, i+1));
            if(num > Integer.MAX_VALUE)
                break;

            int size = temp.size();
            // 提前终止回溯的条件, 注意是大于, 因为如果是小于的情况还可能继续添加num长度判断是否满足
            if(size >= 2 && num > temp.get(size-1) + temp.get(size-2))
                break;
            else if(size < 2 || (num == temp.get(size-1) + temp.get(size-2))) {
                temp.add((int)num);
                bktrace(s, ret, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
//【笔记】一次遍历法，车能开完全程需要满足两个条件：
//        车从i站能开到i+1。
//        所有站里的油总量要>=车子的总耗油量。
//        那么，假设从编号为0站开始，一直到k站都正常，在开往k+1站时车子没油了。这时，应该将起点设置为k+1站。
//————
//        问题1: 为什么应该将起始站点设为k+1？
//        因为k->k+1站耗油太大，0->k站剩余油量都是不为负的，每减少一站，就少了一些剩余油量。所以如果从k前面的站点作为起始站，剩余油量不可能冲过k+1站。
//————
//        问题2: 为什么如果k+1->end全部可以正常通行，且rest>=零就可以说明车子从k+1站点出发可以开完全程？
//        因为，起始点将当前路径分为A、B两部分。其中，必然有A部分剩余油量<0。B部分剩余油量>0。
//        所以，无论多少个站，都可以抽象为两个站点（A、B）。从B站加满油出发，开往A站，车加油，再开回B站的过程。
//        重点：B剩余的油>=A缺少的总油。必然可以推出，B剩余的油>=A站点的每个子站点缺少的油

        int rest = 0, run = 0, start = 0;
        for (int i =0;i<gas.length;++i){
            run += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);
            if (run < 0){
                start = i + 1;
                run = 0;
            }
        }
        return rest < 0 ? -1 : start;
    }

    public boolean isSubsequence(String s, String t) {
        int curs = 0;
        int curt = 0;
        while(curs<s.length()&&curt<t.length()){
            if (s.charAt(curs) == t.charAt(curt)){
                curs++;
                curt++;
            }else{
                curt++;
            }
        }
        if (curs == s.length())
            return true;
        return false;
    }

    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder();
        while(A>0 || B > 0){
            boolean puta = true;
            // if puta = true, we put a
            // else , we put b
            int len = res.length();
            // 后两位相同
            if (len>=2 && res.charAt(len-2)== res.charAt(len-1)){
                if (res.charAt(len-1)=='a')
                    puta = false;
            }
//            else{
//                if (A<B){
//                    puta = false;
//                }
//            }
            if (puta){
                A--;
                res.append('a');
            }else{
                B--;
                res.append('b');
            }
        }
        return res.toString();
    }
}

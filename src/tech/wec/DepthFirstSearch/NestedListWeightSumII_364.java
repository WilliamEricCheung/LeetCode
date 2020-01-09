package tech.wec.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSumII_364 {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    protected interface NestedInteger {
        // Constructor initializes an empty nested list.
        // public NestedInteger();

        // Constructor initializes a single integer.
        // public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
    class Solution {
        private int maxDepth = 0;
        private List<int[]> valueDepth;
        public int depthSumInverse(List<NestedInteger> nestedList) {
            valueDepth = new ArrayList<>();
            dfs(nestedList, 1);
            int result = 0;
            for (int[] item: valueDepth){
                result += item[0] * (maxDepth - item[1] + 1);
            }
            return result;
        }

        private void dfs(List<NestedInteger> nestedList, int depth){
            maxDepth = Math.max(maxDepth, depth); // 求最大深度，用来求差
            for (NestedInteger nestedInteger: nestedList){
                if (nestedInteger.isInteger()) valueDepth.add(new int[]{nestedInteger.getInteger(), depth});
                else dfs(nestedInteger.getList(), depth + 1);
            }
        }
    }
}

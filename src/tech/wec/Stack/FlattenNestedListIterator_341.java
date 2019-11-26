package tech.wec.Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator_341 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     */
    public interface NestedInteger {

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return null if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
    }
    class NestedIterator implements Iterator<Integer> {

        private List<Integer> result;
        private int index;

        public NestedIterator(List<NestedInteger> nestedList) {
            result = flatten(nestedList);
            index = 0;
        }

        private List<Integer> flatten(List<NestedInteger> nestedList){
            List<Integer> res = new ArrayList<>();
            if (nestedList.size() == 0) return res;
            for (NestedInteger i: nestedList){
                if (i.isInteger()) res.add(i.getInteger());
                else res.addAll(flatten(i.getList()));
            }
            return res;
        }

        @Override
        public Integer next() {
            return result.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < result.size();
        }
    }
}

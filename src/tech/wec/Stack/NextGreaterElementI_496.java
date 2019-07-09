package tech.wec.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<nums1.length;i++)
            map.put(nums1[i],i);
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int e:nums2){
            while (!stack.empty() && stack.peek() < e){
                Integer index = map.get(stack.pop());
                if (index != null)
                    result[index] = e;
            }
            stack.push(e);
        }
        return result;
    }
}

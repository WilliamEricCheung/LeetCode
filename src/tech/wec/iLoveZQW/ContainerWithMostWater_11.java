package tech.wec.iLoveZQW;

public class ContainerWithMostWater_11 {
    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            int left = 0, right = height.length - 1;
            while(left < right){
                int area = (right - left) * Math.min(height[left], height[right]);
                if (max < area) max = area;
                if (height[left] < height[right]) left++;
                else right--;
            }
            return max;
        }
    }
}

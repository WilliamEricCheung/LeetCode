package tech.wec.Array;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while(left < right){
            max = Math.max(max, Math.min(height[right], height[left]) * (right - left));
            if (height[left]<height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}

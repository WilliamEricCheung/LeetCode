package tech.wec.iLoveZQW;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        int left = 0; int right = 0;
        for (int i = 0; i < len; i++){
            if (height[i] > left) left = height[i];
            maxLeft[i] = left;
        }
        for (int i = len - 1; i >= 0; i--){
            if (height[i] > right) right = height[i];
            maxRight[i] = right;
        }
        int ans = 0;
        for (int i = 0; i < len; i++){
            ans += Math.min(maxLeft[i] - height[i], maxRight[i] - height[i]);
        }
        return ans;
    }
}

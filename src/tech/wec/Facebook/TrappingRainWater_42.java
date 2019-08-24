package tech.wec.Facebook;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len-1] = height[len - 1];
        for (int i = 1;i<len;i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        for (int i = len - 2;i>=0;i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        int ans = 0;
        for (int i =0;i<len;i++){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}

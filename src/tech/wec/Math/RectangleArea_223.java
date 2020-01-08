package tech.wec.Math;

public class RectangleArea_223 {
    class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int total = (C - A) * (D - B) + (G- E) * (H - F);
            if (B >= H || D <= F || C <= E || A >= G) return total;
            return total - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        }
    }
}

package tech.wec.BitManipulation;

public class BitwiseANDOfNumbersRange_201 {
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            return m==n?m:rangeBitwiseAnd(m>>1,n>>1)<<1;
        }
    }
}

package tech.wec.Brainteaser;

public class ReverseBits_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n){
        int result = 0;
        for (int i =1;i<=32;i++){
            if ((n & 1) == 1)
                result += (1 << (32 - i));
            n = n >> 1;
        }
        return result;
    }
}

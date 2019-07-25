package tech.wec.Brainteaser;

public class NumberOf1Bits_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        for (int i =1;i<=32;i++){
            if ((n & 1) == 1){
                result++;
            }
            n = n >> 1;
        }
        return result;
    }
}

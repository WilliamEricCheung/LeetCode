package tech.wec.BitManipulation;

public class NumberComplement_476 {

    public int findComplement(int num) {
        return (~num) & getMask(num);
    }

    public int getMask(int num){
        int tmp = 1;
        int mask = 0;
        for (int i = 0; i < 31; i++){
            if ((tmp & num) != 0)
                mask = tmp;
            tmp <<= 1;
        }
        tmp = 1;
        while((tmp & mask) == 0){
            mask |= tmp;
            tmp <<= 1;
        }
        return mask;
    }
}

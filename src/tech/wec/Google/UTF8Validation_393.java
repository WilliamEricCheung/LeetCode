package tech.wec.Google;

public class UTF8Validation_393 {

    public boolean validUtf8(int[] data) {
        int bytes = 0;
        int mask1 = 1 << 7;
        int mask2 = 1 << 6;
        for (int i = 0; i < data.length; i++){
            // new utf8
            if (bytes == 0){
                int mask = 1 << 7;
                while((mask & data[i])!=0){
                    bytes++;
                    mask >>= 1;
                }

                // 1 byte
                if (bytes == 0)
                    continue;
                // invalid
                if (bytes > 4 || bytes == 1)
                    return false;
            }else{
                if (!((data[i] & mask1)!= 0 &&( data[i] & mask2 )==0))
                    return false;
            }
            bytes--;
        }
        return bytes == 0;
    }
}

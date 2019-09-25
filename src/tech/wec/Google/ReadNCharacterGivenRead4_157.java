package tech.wec.Google;

public class ReadNCharacterGivenRead4_157 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int p = 0;
        int cnt;
        while((cnt = read4(buf4))>0){
            int i  = 0;
            while(p < n && i < cnt)
                buf[p++] = buf4[i++];
        }
        return p;
    }

    /**
     * The read4 API is defined in the parent class Reader4.
     *     int read4(char[] buf);
     */
    int read4(char[] buf){
        return 0;
    }
}

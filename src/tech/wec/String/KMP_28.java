package tech.wec.String;

public class KMP_28 {
    // https://www.cnblogs.com/sun-haiyu/p/7289576.html
    // 字符串相同前缀、后缀的最大长度的next数组
    private int[] getNext(String p){
        int M = p.length();
        int[] next = new int[M];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while(j<M-1){
            if (k==-1 || p.charAt(k) == p.charAt(j)){
                next[++j] = ++k;
            }else{
                k = next[k];
            }
        }
        return next;
    }

    private static int[] betterGetNext(String p) {
        int M = p.length();
        int[] next = new int[M];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < M - 1) {
            if (k == -1 || p.charAt(k) == p.charAt(j)) {
                if (p.charAt(k + 1) == p.charAt(j + 1)) {
                    next[++j] = next[++k];
                } else {
                    next[++j] = ++k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public int search(String p, String t){
        int[] next = betterGetNext(p);
        int N = t.length();
        int M = p.length();
        int i = 0;
        int j = 0;
        while (i<N && j<M){
            if (j==-1||p.charAt(j)==t.charAt(i)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if (j == M)
            return i-j;
        else
            return -1;
    }
}

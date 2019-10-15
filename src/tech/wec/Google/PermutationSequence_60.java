package tech.wec.Google;

public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] factorials = new int[n + 1];
        factorials[0] = factorials[1] = 1;
        for (int i = 1; i <= n; i++) {
            sb.append(i);
            factorials[i] = i * factorials[i-1];
        }
        String result = "";
        while(result.length() != n){
            int idx = 0;
            // sb的长度一开始为n
            while(k > factorials[sb.length() - 1]){
                k -= factorials[sb.length() - 1];
                idx++;
            }
            result += sb.charAt(idx);
            sb.deleteCharAt(idx);
        }
        return result;
    }
}

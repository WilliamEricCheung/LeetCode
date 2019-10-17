package tech.wec.Google;

public class LicenseKeyFormatting_482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        S = S.replaceAll("-","");
        S = S.toUpperCase();
        int i = S.length();
        for (; i >= K; i -= K){
            sb.insert(0, "-" + S.substring(i - K, i));
        }
        if (i > 0)
            sb.insert(0, S.substring(0, i));
        return sb.toString();
    }
}

package tech.wec.Math;

public class CountAndSay_38 {
    public String countAndSay(int n) {
        String res = "1";
        for (int i =1;i<n;i++){
            res = count(res);
        }
        return res;
    }

    String count(String in){
        StringBuilder out = new StringBuilder();
        char pt = in.charAt(0);
        int cnt = 1;
        for (int i =1;i<in.length();i++){
            if (in.charAt(i)!=pt){
                out.append(cnt);out.append(pt);
                pt = in.charAt(i);
                cnt = 1;
            }else
                cnt++;
        }
        out.append(cnt);
        out.append(pt);
        return out.toString();
    }
}

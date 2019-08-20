package tech.wec.String;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        int curs = 0;
        int curt = 0;
        while(curs<s.length()&&curt<t.length()){
            if (s.charAt(curs) == t.charAt(curt)){
                curs++;
                curt++;
            }else{
                curt++;
            }
        }
        if (curs == s.length())
            return true;
        return false;
    }
}

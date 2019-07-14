package tech.wec.String;

public class RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int alpha[] = new int[26];
        for (int i = 0; i< magazine.length(); i++){
            alpha[magazine.charAt(i) - 'a']++;
            if (i < ransomNote.length()) alpha[ransomNote.charAt(i) - 'a']--;

        }
        for (int a: alpha){
            if (a < 0) return false;
        }

        return true;
    }
}

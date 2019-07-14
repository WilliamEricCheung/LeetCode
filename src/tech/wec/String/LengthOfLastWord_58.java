package tech.wec.String;

public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        if(s.equals(" ")||s.equals(""))
            return 0;
        String[] words = s.split(" ");
        if(words.length == 0)
            return 0;
        return words[words.length-1].length();
    }
}


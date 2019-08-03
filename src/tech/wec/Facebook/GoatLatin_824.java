package tech.wec.Facebook;

public class GoatLatin_824 {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (String word: words){
            StringBuilder str = new StringBuilder();
            char begin = word.charAt(0);
            if (begin == 'a' || begin == 'e' || begin == 'i' ||
                    begin == 'o' || begin == 'u' || begin == 'A' || begin == 'E' || begin == 'I' ||
                    begin == 'O' || begin == 'U'){
                str.append(word+"ma");
            }else{
                str.append(word.substring(1)+begin+"ma");
            }
            for (int i = 1;i<=cnt;i++)
                str.append("a");
            cnt++;
            sb.append(str+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}

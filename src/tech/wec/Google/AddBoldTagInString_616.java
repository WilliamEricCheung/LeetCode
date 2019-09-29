package tech.wec.Google;

public class AddBoldTagInString_616 {
    public String addBoldTag(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        int last = 0;
        int end = -1;
        for (int start = 0; start < s.length(); start++){
            for (String word : words){
                if (s.startsWith(word, start)){
                    end = Math.max(end, start + word.length());
                }
            }
            if (start == end)
                sb.append("<b>"+s.substring(last, start)+"</b>");
            if (start >= end){
                sb.append(s.charAt(start));
                last = start + 1;
            }
        }
        if (end >= s.length())
            sb.append("<b>" + s.substring(last) + "</b>");
        return sb.toString();
    }
}

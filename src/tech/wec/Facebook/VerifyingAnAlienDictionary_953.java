package tech.wec.Facebook;

public class VerifyingAnAlienDictionary_953 {

    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i<26;i++)
            index[order.charAt(i) - 'a'] = i;
        search: for (int i = 0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            for (int j = 0;j<Math.min(word1.length(), word2.length()); j++){
                if (word1.charAt(j) != word2.charAt(j)){
                    if (index[word1.charAt(j) - 'a'] > index[word2.charAt(j) - 'a'])
                        return false;
                    continue search;
                }
            }
            if (word1.length() > word2.length())
                return false;
        }
        return true;
    }
}

package tech.wec.Google;

public class CompareStringsByFrequencyOfTheSmallestCharacter_1170 {

    public int[] numSmallerByFrequency(String[] a, String[] b){
        int[] cnt = new int[12];
        for (String word: b)
            cnt[f(word)]++;
        for (int i = 10; i >= 0; i--)
            cnt[i] += cnt[i+1];
        int[] ans =  new int[a.length];
        for (int i = 0; i < a.length; i++)
            ans[i] = cnt[f(a[i])+1];
        return ans;
    }

    private static int f(String str){
        char min = 'a' + 26;
        int freq = 0;
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch < min){
                freq = 1;
                min = ch;
            }else if (ch == min)
                freq++;
        }
        return freq;
    }
}

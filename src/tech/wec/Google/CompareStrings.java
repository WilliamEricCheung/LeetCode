package tech.wec.Google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompareStrings {

    public static void main(String[] args){
        String A = "abcd,aabc,bd";
        String B = "aaa,aa";
        System.out.println(Arrays.toString(compareStrings(A, B)));
    }

    public static int[] compareStrings(String A, String B){
        String[] a = A.split(",");
        String[] b = B.split(",");
        int[] result = new int[b.length];
        // key for smallest number, value for frequency
        Map<Integer, Integer> mapA = new HashMap<>();
        for (String str: a){
            int smallestIdx = 26;
            int[] cnt = new int[26];
            for (char ch: str.toCharArray()){
                cnt[ch - 'a']++;
                smallestIdx = Math.min(smallestIdx, ch - 'a');
            }
            if (mapA.containsKey(cnt[smallestIdx]))
                mapA.put(cnt[smallestIdx], mapA.get(cnt[smallestIdx]) + 1);
            else
                mapA.put(cnt[smallestIdx], 1);
        }
        int i = 0;
        for (String str: b){
            int[] cnt = new int[26];
            int smallestIdx = 26;
            for (char ch: str.toCharArray()){
                cnt[ch - 'a']++;
                smallestIdx = Math.min(smallestIdx, ch - 'a');
            }
            int freq = cnt[smallestIdx];
            int count = 0;
            for (Integer key: mapA.keySet()){
                if (freq > key)
                    count += mapA.get(key);
            }
            result[i++] = count;
        }
        return result;
    }
}

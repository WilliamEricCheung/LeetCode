package tech.wec.Brainteaser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryWatch_401 {

    public List<String> readBinaryWatch(int num) {
        Map<Integer, List<Integer>> hour = new HashMap<>();
        Map<Integer, List<Integer>> minute = new HashMap<>();

        // calculate all hours--bit
        for (int i =0;i<=11;i++){
            int bitCount = Integer.bitCount(i);
            List<Integer> value = hour.getOrDefault(bitCount, new ArrayList<>());
            value.add(i);
            hour.put(bitCount, value);
        }
        // calculate all minutes-bit
        for (int i =0;i<=59;i++){
            int bitCount = Integer.bitCount(i);
            List<Integer> value = minute.getOrDefault(bitCount, new ArrayList<>());
            value.add(i);
            minute.put(bitCount, value);
        }
        List<String> ans = new ArrayList<>();
        for (int i =0;i<=num;i++){
            List<Integer> hours = hour.get(i);
            List<Integer> minutes = minute.get(num - i);
            ans.addAll(generateCombination(hours, minutes));
        }
        return ans;
    }

    List<String> generateCombination(List<Integer> hours, List<Integer> minutes){
        List<String> ans = new ArrayList<>();
        for (int i =0;hours!=null && i<hours.size();i++){
            for (int j = 0;minutes != null && j<minutes.size();j++){
                String hour = String.valueOf(hours.get(i));
                String minute = minutes.get(j) > 9 ? String.valueOf(minutes.get(j)) : "0"+String.valueOf(minutes.get(j));
                ans.add(hour+":"+minute);
            }
        }
        return ans;
    }
}

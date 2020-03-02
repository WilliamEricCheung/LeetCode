package tech.wec.iLoveZQW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem_609 {
    class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            Map<String, List<String>> files = new HashMap<>();
            for (String path: paths){
                String[] values = path.split(" ");
                for (int i = 1; i < values.length; i++){
                    String[] fileContent= values[i].split("\\(");
                    String content = fileContent[1].replace(")", "");
                    String file = fileContent[0];
                    List<String> list = files.getOrDefault(content, new ArrayList<>());
                    list.add(values[0] + "/" + file);
                    files.put(content, list);
                }
            }
            List<List<String>> ans = new ArrayList<>();
            for (String key: files.keySet()){
                if (files.get(key).size() > 1)
                    ans.add(files.get(key));
            }
            return ans;
        }
    }
}

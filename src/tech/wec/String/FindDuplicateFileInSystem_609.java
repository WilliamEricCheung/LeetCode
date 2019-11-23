package tech.wec.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem_609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths){
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++){
                String[] fileContent = values[i].split("\\(");
                String content = fileContent[1].replace(")","");
                String file = fileContent[0];
                List<String> list = map.getOrDefault(content, new ArrayList<>());
                list.add(values[0]+"/"+file);
                map.put(content, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key: map.keySet()){
            if (map.get(key).size() > 1)
                result.add(map.get(key));
        }
        return result;
    }
}

package tech.wec.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomianVisitCount_811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain: cpdomains){
            String[] timeDomain = domain.split(" ");
            String domains = timeDomain[1];
            Integer times = Integer.parseInt(timeDomain[0]);
            map.put(domains, times + map.getOrDefault(domains, 0));
            while(domains.indexOf(".")>0){
                domains = domains.substring(domains.indexOf(".")+1, domains.length());
                map.put(domains, times + map.getOrDefault(domains, 0));
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry entry: map.entrySet()){
            String item = entry.getValue() + " " + entry.getKey();
            result.add(item);
        }
        return result;
    }
}

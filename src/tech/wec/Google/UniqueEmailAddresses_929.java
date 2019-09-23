package tech.wec.Google;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses_929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();
        for (String email : emails){
            int idx = email.indexOf('@');
            String local = email.substring(0, idx);
            String domain = email.substring(idx);
            if (local.contains("+")){
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replaceAll("\\.","");
            result.add(local + domain);
        }
        return result.size();
    }
}

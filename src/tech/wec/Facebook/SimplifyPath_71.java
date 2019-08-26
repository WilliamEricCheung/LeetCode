package tech.wec.Facebook;

import java.util.LinkedList;

public class SimplifyPath_71 {

    public String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder();
        int cnt  = 1;
        int len = path.length();
        while(cnt < len){
            if (path.charAt(cnt) == '/'){
                cnt++;
                continue;
            }
            StringBuilder word = new StringBuilder();
            while(cnt < len && path.charAt(cnt) != '/')
                word.append(path.charAt(cnt++));
            String str = word.toString();
            if (str.equals("."))
                continue;
            else if (str.equals("..")){
                if (ans.length() > 0)
                    ans.delete(ans.lastIndexOf("/"), ans.length());
            } else
                ans.append("/").append(str);
        }
        if (ans.length() == 0)
            ans.append("/");
        return ans.toString();
    }
}

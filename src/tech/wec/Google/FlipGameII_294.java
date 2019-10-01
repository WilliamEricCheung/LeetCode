package tech.wec.Google;

import java.util.HashMap;
import java.util.Map;

public class FlipGameII_294 {
    HashMap<String,Boolean> cache = new HashMap<>();
    public boolean canWin(String s) {
        return canWin(s.toCharArray(),true);
    }

    boolean canWin(char[] a,boolean one){
        String key = new String(a);
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        for(int i=0;i<a.length-1;i++){
            if(a[i]=='+' && a[i+1]=='+'){
                a[i]='-';
                a[i+1]='-';
                if(!canWin(a,!one)){
                    a[i]='+';
                    a[i+1]='+';
                    cache.put(key,true);
                    return true;
                }
                a[i]='+';
                a[i+1]='+';
            }
        }
        cache.put(key,false);
        return false;
    }
}

package tech.wec.String;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i =1;i<=n;i++){
            boolean divideThree = (i % 3 == 0);
            boolean divideFive = (i % 5 == 0);

            if (divideThree && divideFive)
                ans.add("FizzBuzz");
            else if (divideThree)
                ans.add("Fizz");
            else if (divideFive)
                ans.add("Buzz");
            else
                ans.add(Integer.toString(i));
        }
        return ans;
    }
}

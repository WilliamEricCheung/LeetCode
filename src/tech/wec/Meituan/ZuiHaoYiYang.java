package tech.wec.Meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZuiHaoYiYang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int[] nums = new int[n];
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0;i < n;i++) {
            nums[i] = input.nextInt();
            Integer initCount = map.getOrDefault(nums[i], 0);
            initCount += 1;
            map.put(nums[i], initCount);
            max = Math.max(initCount, max);
        }
        map.clear();
        for (int i = 0;i < n;i++) {
            if (map.containsKey(nums[i]))
                continue;
            Integer cnt = 1;
            for (int j = 0;j < n && cnt + n - j - 1 >= max;j++) {
                if (j == i)
                    continue;
                if (nums[i] == nums[j] || (nums[j] | x) == nums[i]) {
                    cnt++;
                }
            }
            map.put(nums[i], cnt);
            max = Math.max(cnt, max);
        }
        System.out.println(max);

    }
}

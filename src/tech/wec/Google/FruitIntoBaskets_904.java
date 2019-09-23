package tech.wec.Google;

import java.util.*;

public class FruitIntoBaskets_904 {

    public static void main(String[] args){
        int[] tree = new int[]{0,1,6,6,4,6};
        System.out.println(totalFruit(tree));
    }
    // brute force
    public static int totalFruit(int[] tree) {
        int max = 0;
        for (int k = 0; k < tree.length; k++) {
            int size = 0;
            Map<Integer, Integer> basket = new HashMap<>();
            for (int i = k; i < tree.length; i++) {
                if (basket.size() < 2 && !basket.containsKey(tree[i])) {
                    basket.put(tree[i], 1);
                }
                else if (basket.size() <= 2 && basket.containsKey(tree[i])) {
                    basket.put(tree[i], basket.get(tree[i]) + 1);
                }
                else if (basket.size() == 2 && !basket.containsKey(tree[i]))
                    break;
            }
//            Integer[] baskets = basket.values().toArray(Integer[]::new);
            Integer[] baskets = new Integer[basket.size()];
            baskets =  basket.values().toArray(baskets);
            if (baskets.length == 2)
                size = baskets[0] + baskets[1];
            else
                size = baskets[0];
            if (size > max)
                max = size;
            if (max >= tree.length - k)
                return max;
        }
        return max;
    }

    // optimized brute force scan
    public int totalFruit_1(int[] tree){
        List<Integer> blockLefts = new ArrayList<>();
        for (int i = 0; i <tree.length; i++){
            if (i == 0 || tree[i-1] != tree[i])
                blockLefts.add(i);
        }
        // Add tree.length as a sentinel for convenience
        blockLefts.add(tree.length);
        int ans = 0, i = 0;
        search: while(true){
            Set<Integer> types = new HashSet<>();
            int weight = 0;
            for (int j = i; j < blockLefts.size() - 1; j++){
                types.add(tree[blockLefts.get(j)]);
                weight += blockLefts.get(j+1) - blockLefts.get(j);
                if (types.size() > 2){
                    i = j - 1;
                    continue search;
                }
                ans = Math.max(ans, weight);
            }
            break;
        }
        return ans;
    }

    public int totalFruit_2(int[] tree) {
        int l = 0;
        int firstType = -1, secondType = -1;
        int res = 0;
        for(int r = 0;r < tree.length;r++) {
            if(tree[r] == firstType || tree[r] == secondType) continue;
            if(firstType == -1) {
                firstType = tree[r];
                continue;
            }
            if(secondType == -1) {
                secondType = tree[r];
                continue;
            }
            res = Math.max(res, r - l);
            firstType = tree[r-1];
            secondType = tree[r];
            l = r-1;
            while( tree[l] == firstType) {
                --l;
            }
            ++l;
        }
        res = Math.max(res, tree.length - l);
        return res;
    }
}

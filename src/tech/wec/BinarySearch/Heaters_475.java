package tech.wec.BinarySearch;

import java.util.Arrays;

public class Heaters_475 {
    public int findRadius_1(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        for (int house: houses){
            int low = 0, high = heaters.length - 1;
            int insert = -1;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if (heaters[mid] == house){
                    insert = mid;
                    break;
                }else if (heaters[mid] > house)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            if (high == -1){
                result = Math.max(result, heaters[0]- house);
                continue;
            }
            if (low == heaters.length){
                result = Math.max(result, house - heaters[heaters.length-1]);
                continue;
            }
            if (insert != -1){
                result = Math.max(result, 0);
                continue;
            }
            int min = Math.min(house - heaters[high], heaters[low] - house);
            result = Math.max(result,min);
        }
        return result;
    }

    public int findRadius_2(int[] houses, int[] heaters){
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, j = 0, result = 0;
        while(i<houses.length){
            while(j<heaters.length){
                int t1 = Math.abs(heaters[j+1] - houses[i]);
                int t2 = Math.abs(heaters[j] - houses[i]);
                if (t1 > t2)
                    break;
                j++;
            }
            result = Math.max(result, Math.abs(heaters[j] - houses[i]));
            i++;
        }
        return result;
    }
}

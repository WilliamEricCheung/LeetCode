package tech.wec.BinarySearch;

public class FirstBadVersion_278 {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(isBadVersion(mid))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    // api method
    private boolean isBadVersion(int n){
        return true;
    };
}

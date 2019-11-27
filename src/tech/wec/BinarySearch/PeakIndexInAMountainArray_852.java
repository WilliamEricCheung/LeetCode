package tech.wec.BinarySearch;

public class PeakIndexInAMountainArray_852 {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if (A[mid] > A[mid] + 1)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}

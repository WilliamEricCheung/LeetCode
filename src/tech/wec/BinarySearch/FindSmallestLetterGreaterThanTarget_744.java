package tech.wec.BinarySearch;

public class FindSmallestLetterGreaterThanTarget_744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if (letters[mid] <= target)
                low = mid+1;
            else
                high = mid;
        }
        return letters[low % letters.length];
    }
}

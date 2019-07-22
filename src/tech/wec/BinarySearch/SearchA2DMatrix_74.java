package tech.wec.BinarySearch;

public class SearchA2DMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int low = 0, rows = matrix.length, cols = matrix[0].length;
        int high = rows * cols - 1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            if (matrix[mid / cols][mid % cols] == target)
                return true;
            else if (matrix[mid / cols][mid % cols] < target)
                low = mid + 1;
            else
                high = mid -1;
        }
        return false;
    }
}

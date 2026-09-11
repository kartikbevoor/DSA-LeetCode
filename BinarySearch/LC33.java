package BinarySearch;

// Search in Rotated Sorted Array
public class LC33{
    public int search(int[] nums, int target) {
        // Find a point where the array is rotated.
        int pivot = findPivot(nums);
        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        // Check if target is equal to pivot 
        if (nums[pivot] == target) {
            return pivot;
        }

        // if target is > first elemet search is left part of pivot
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot - 1, target);
        }
        
        // else search in right part of pivot 
        return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }

    public int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (middle < end && nums[middle] > nums[middle + 1]) {
                return middle;
            }

            if (middle > start && nums[middle] < nums[middle - 1]) {
                return middle - 1;
            }

            if (nums[middle] < nums[start]) {
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }

        return -1; // array is not rotated.
    }

    public int binarySearch(int[] nums, int start, int end, int target){
        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] > target) {
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        
    }
}
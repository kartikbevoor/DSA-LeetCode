package SlidingWindow;

public class SlidingWindow {

    // Fixed size sliding window.
    public void fixedWindowSizeTemplate(int[] nums, int windowSize){
        int left = 0;
        // int windowValue = 0;

        for (int right = 0; right < nums.length; right++) {
            
            // Add arr[right]

            if ((right - left + 1) == windowSize) {
                
                // Calculate answer

                // Remove arr[left]
                left++;
            }
        }
    }

    // Find the maximum sum of subarray (fixed window size)
    public static int maxSum(int[] nums, int windowSize){
        int left = 0;
        int windowSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++) {
            windowSum = windowSum + nums[right];

            if ((right - left + 1) == windowSize) {
                if (windowSum > maxSum) {
                    maxSum = windowSum;
                }
            }

            windowSum = windowSum - nums[left];
            left ++;
        }

        return maxSum;
    } 

    // Find the length of the longest subarray whose sum is <= K.
    public static int longestSubArray(int[] nums, int sum){
        int left = 0;
        int maxLength = 0;
        int maxSum = 0;

        for (int right = 0; right < nums.length; right++) {
            
            sum += nums[right];

            while (maxSum > sum) {
                sum -= nums[left];
                left++;
            }

            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        return maxLength;
    }

    public static void main(String[] args) {
        
    }
}

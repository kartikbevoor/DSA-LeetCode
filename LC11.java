package LeetCode;

// Container With Most Water
public class LC11 {
    public int min(int a, int b){
        return a < b ? a : b;
    }

    public int maxArea(int[] height) {
        int area = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {

            int temp = min(height[start], height[end]) * (end - start);


            if (temp > area) {
                area = temp;
            }

            if (height[start] < height[end]) {
                start++;
            }else{
                end--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        
    }
}

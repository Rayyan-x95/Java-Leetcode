class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int index = 0; // pointer for result array
        
        for (int i = 0; i < n; i++) {
            result[index] = nums[i];     // Take x_i from the first half
            index++;
            result[index] = nums[i + n]; // Take y_i from the second half
            index++;
        }
        
        return result;
    }
}

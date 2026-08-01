package Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        // Brute Force Method
        for(int i=0;i<n;i++){
            boolean flag = false;   // optimization
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    ans[0] = i;
                    ans[1] = j;
                    flag = true;
                    break;
                }
            }
            if(flag==true) break;
        }
        return ans;
    }
}

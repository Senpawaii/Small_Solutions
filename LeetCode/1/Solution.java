import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seenValues = new HashMap<Integer, Integer>();
        for(int index = 0; index < nums.length; index++) {
            int lookingForValue = target - nums[index];
            if(seenValues.containsKey(lookingForValue)) {
                return new int[] { seenValues.get(lookingForValue), index};
            }
            seenValues.put(nums[index], index);
        }
        return null;
    }
}


/*
*   Time complexity: O(n)
*   Space complexity: O(n)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer another = map.get(target - nums[i]);
            if (null != another) {
                return new int[]{another, i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
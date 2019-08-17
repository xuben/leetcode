import java.util.*;

class Solution {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{2, 0, 1, 2, 2, -4}));
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> foundSet = new HashSet<>();
        Set<Integer> targetSet = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int target = nums[i];
            if (!targetSet.add(target)) {
                continue;
            }
            Set<Integer> numSet = new HashSet<>();
            for (int j = i + 1; j < length; j++) {
                int left = nums[j];
                int right = 0 - target - left;
                if (numSet.contains(right)) {
                    int min = Math.min(Math.min(left, right), target);
                    int max = Math.max(Math.max(left, right), target);
                    if (foundSet.add(min + "_" + max)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(target);
                        list.add(right);
                        list.add(left);
                        result.add(list);
                    }
                }
                numSet.add(left);
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (0 == length) {
            return result;
        }
        Arrays.sort(nums);
        int lastTarget = 0;
        for (int i = 0; i < length - 2; i++) {
            int target = nums[i];
            if (0 == i) {
            } else if (lastTarget == target) {
                continue;
            }
            lastTarget = target;
            int left = nums[i+1];
            if (target + left + nums[i+2] > 0) {
                break;
            }
            Set<Integer> leftSet = new HashSet<>();
            leftSet.add(left);
            boolean hasLastRight = false;
            int lastRight = 0;
            for (int j = i + 2; j < length; j++) {
                int tmpLeft = nums[j];
                if (target + left + tmpLeft > 0) {
                    break;
                }
                int right = 0 - target - tmpLeft;
                if (leftSet.contains(right) && (!hasLastRight || lastRight != right)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(target);
                    list.add(right);
                    list.add(tmpLeft);
                    result.add(list);
                    lastRight = right;
                    hasLastRight = true;
                }
                leftSet.add(tmpLeft);
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (0 == length) {
            return result;
        }
        Arrays.sort(nums);
        int lastTarget = 0;
        for (int i = 0; i < length - 2; i++) {
            int target = nums[i];
            if (0 == i) {
            } else if (lastTarget == target) {
                continue;
            }
            lastTarget = target;
            if (target + nums[i+1] + nums[i+2] > 0) {
                break;
            }
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int left = nums[j];
                int right = nums[k];
                int sum = target + left + right;
                if (0 == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(target);
                    list.add(left);
                    list.add(right);
                    result.add(list);
                    j++;
                    k--;
                    while (nums[j] == left && j < k) {
                        j++;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
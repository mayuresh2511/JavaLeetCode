package org.example.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     *
     * @param nums
     * @param target
     * @return resultIndex
     * This is bruteForce approach for this problem
     */
    public static int[] twoSumBruteForce(int[] nums, int target){
        int[] resultIndex = new int[2];

        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (target == (nums[i] + nums[j])){
                    resultIndex[0] = i;
                    resultIndex[1] = j;
                    break;
                }
            }
        }
        return resultIndex;
    }

    /**
     *
     * @param nums
     * @param target
     * @return resultIndex
     * This method will make use of HashMap to store the data for reducing the time
     */
    public static int[] twoSumHashMap(int[] nums, int target){
        int [] resultIndex = new int[2];

        HashMap<Integer, Integer> resultDeriver = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (resultDeriver.containsKey(nums[i])){
                resultIndex[0] = resultDeriver.get(nums[i]);
                resultIndex[1] = i;
            }else {
                resultDeriver.put(target-nums[i], i);
            }
        }

        return resultIndex;
    }

    /**
     *
     * @param nums
     * @param target
     * @return resultIndex
     * This method will give correct results only if sorted array is provided
     */
    public static int[] twoSumTwoPointer(int[] nums, int target){
        int [] resultIndex = new int[2];

        int startPointer = 0;
        int endPointer = nums.length - 1;

        for (int i = 0; i < nums.length; i++){
            int sum = nums[startPointer] + nums[endPointer];
            if (target == sum){
                resultIndex[0] = startPointer;
                resultIndex[1] = endPointer;
            }else if (sum > target){
                endPointer--;
            } else {
                startPointer++;
            }
        }

        return resultIndex;
    }
}

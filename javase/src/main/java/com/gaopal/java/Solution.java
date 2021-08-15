package com.gaopal.java;

import java.util.Arrays;

class Solution {
  public static int maximumGap(int[] nums) {
    if (nums.length < 2) return 0;

    Arrays.sort(nums);

    int maxVal = nums[0];
    int returnMaxVal = nums[0];
    for (int i = 0; i < nums.length - 2; i++) {
      maxVal =
          (nums[i + 1] - nums[i]) > (nums[i + 2] - nums[i + 1])
              ? (nums[i + 1] - nums[i])
              : (nums[i + 2] - nums[i + 1]);
      returnMaxVal = maxVal > returnMaxVal ? maxVal: returnMaxVal;
    }
    return returnMaxVal;
  }

  public static void main(String[] args) {
//    int[] nums = {3, 6, 9, 1};
//    System.out.println(maximumGap(nums));

    int[] nums = {1,1,1,1,1,5,5,5,5,5};
    System.out.println(maximumGap(nums));
  }
}

package com.company;

public class NumArrayMutable {

  private int[] data;
  private int[] sum;

  public NumArrayMutable(int[] nums) {
    data = new int[nums.length];
    for (int i = 0; i < nums.length; i++) data[i] = nums[i];

    sum = new int[nums.length + 1];
    sum[0] = 0;
    for (int i = 1; i < sum.length; i++) sum[i] = sum[i - 1] + nums[i - 1];
  }

  public void update(int i, int val) {
    data[i] = val;
    for (int j = i + 1; j < sum.length; j++) sum[j] = sum[j - 1] + data[j - 1];
  }

  public int sumRange(int i, int j) {
    return sum[j + 1] - sum[i];
  }
}

package com.company;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * <p>Example 1:
 *
 * <p>Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2] Example 2:
 *
 * <p>Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4] Note:
 *
 * <p>Each element in the result must be unique. The result can be in any order.
 */
public class Intersection {

  public int[] intersection(int[] nums1, int[] nums2) {
    TreeSet<Integer> set = new TreeSet<>();
    for (int num : nums1) set.add(num);
    ArrayList<Integer> list = new ArrayList<>();
    for (int num : nums2) {
      if (set.contains(num)) {
        list.add(num);
        set.remove(num);
      }
    }
    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i);
    }
    return res;
  }
}

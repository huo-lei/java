package com.company;

import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * <p>Find the median of the two sorted arrays. The overall run time complexity should be O(log
 * (m+n)).
 *
 * <p>You may assume nums1 and nums2 cannot be both empty.
 *
 * <p>Example 1:
 *
 * <p>nums1 = [1, 3] nums2 = [2]
 *
 * <p>The median is 2.0 Example 2:
 *
 * <p>nums1 = [1, 2] nums2 = [3, 4]
 *
 * <p>The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSourtedArrays {

  public static void main(String[] args) {
    System.out.println(
        (new MedianOfTwoSourtedArrays()).findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
    System.out.println(
        (new MedianOfTwoSourtedArrays())
            .findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));

    System.out.println(
        (new MedianOfTwoSourtedArrays())
            .findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0}));
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] res = new int[nums1.length + nums2.length];
    int k = 0;
    for (int i = 0, j = 0; i < nums1.length || j < nums2.length; ) {
      if (i >= nums1.length) {
        res[k] = nums2[j++];
        k++;
        continue;
      }
      if (j >= nums2.length) {
        res[k] = nums1[i++];
        k++;
        continue;
      }
      res[k] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
      k++;
    }

    System.out.println(Arrays.toString(res));
    if (res.length % 2 == 1) {
      return res[res.length / 2];
    } else {
      return (res[res.length / 2] + res[res.length / 2 - 1]) / 2.0;
    }
  }
}

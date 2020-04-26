package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * <p>Example:
 *
 * <p>Input: n = 4, k = 2 Output: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */
public class Combinations {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    solution(res, n, k);
    return res;
  }

  private void solution(List<List<Integer>> res, int n, int k) {
    solutionRecur(res, new ArrayList<>(), n, k);
  }

  private void solutionRecur(List<List<Integer>> res, List<Integer> prefix, int n, int k) {
    if (prefix.size() == k) {
      res.add(prefix);
      return;
    }

    for (int i = 1; i <= n; i++) {
      List<Integer> temp = new ArrayList<>(prefix);
      if (temp.contains(i)) return;
      temp.add(i);
      solutionRecur(res, temp, n, k);
    }
  }

  public static void main(String[] args) {
    System.out.println((new Combinations()).combine(4, 2));
  }
}

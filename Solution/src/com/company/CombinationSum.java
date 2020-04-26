package com.company;
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

        The same repeated number may be chosen from candidates unlimited number of times.

        Note:

        All numbers (including target) will be positive integers.
        The solution set must not contain duplicate combinations.
        Example 1:

        Input: candidates = [2,3,6,7], target = 7,
        A solution set is:
        [
        [7],
        [2,2,3]
        ]
        Example 2:

        Input: candidates = [2,3,5], target = 8,
        A solution set is:
        [
        [2,2,2,2],
        [2,3,3],
        [3,5]
        ]
        */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    solution(res, candidates, target);
    return res;
  }

  private void solution(List<List<Integer>> res, int[] candidates, int target) {
    solutionRec(res, candidates, new ArrayList<>(), target);
  }

  private void solutionRec(
      List<List<Integer>> res, int[] candidates, List<Integer> item, int target) {
    if (sumItem(item) == target) {
      res.add(item);
      return;
    }
    if (sumItem(item) > target) {
      return;
    }

    for (int i = 0; i < candidates.length; i++) {
      List<Integer> prefix = new ArrayList<>(item);
      if (prefix.size() - 1 >= 0 && candidates[i] < prefix.get(prefix.size() - 1)) {
        continue;
      }
      prefix.add(candidates[i]);
      solutionRec(res, candidates, prefix, target);
    }
  }

  private int sumItem(List<Integer> item) {
    int res = 0;
    for (int i = 0; i < item.size(); i++) {
      res = res + item.get(i);
    }
    return res;
  }

  public static void main(String[] args) {

    System.out.println((new CombinationSum()).combinationSum(new int[] {2, 3, 5}, 8));
    System.out.println((new CombinationSum()).combinationSum(new int[] {2, 3, 6, 7}, 7));
  }
}

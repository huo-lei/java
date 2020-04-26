package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 *
 * <p>For example, given n = 3, a solution set is:
 *
 * <p>[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 */
public class GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> allCombinations = new ArrayList<>();
    printAllKLength(allCombinations, "()".toCharArray(), 2 * n);
    List<String> res = valid(allCombinations);
    return res;
  }

  private void printAllKLength(List<String> allCombinations, char[] set, int k) {
    int n = set.length;
    printAllKLengthRec(allCombinations, set, "", n, k);
  }

  void printAllKLengthRec(List<String> allCombinations, char[] set, String prefix, int n, int k) {
    if (k == 0) {
      allCombinations.add(prefix);
      return;
    }
    for (int i = 0; i < n; ++i) {
      String newPrefix = prefix + set[i];
      printAllKLengthRec(allCombinations, set, newPrefix, n, k - 1);
    }
  }

  private List<String> valid(List<String> all) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < all.size(); i++) {
      String item = all.get(i);
      int balance = 0;
      for (int j = 0; j < item.length(); j++) {
        char temp = item.charAt(j);
        if (temp == '(') {
          balance++;
          continue;
        } else balance--;
        if (balance < 0) break;
      }
      if (balance == 0) res.add(item);
    }
    return res;
  }

  public static void main(String[] args) {

    System.out.println((new GenerateParentheses()).generateParenthesis(3));
  }
}

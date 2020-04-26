package com.company;

/**
 * Share Given a string s, find the longest palindromic substring in s. You may assume that the
 * maximum length of s is 1000.
 *
 * <p>Example 1:
 *
 * <p>Input: "babad" Output: "bab" Note: "aba" is also a valid answer. Example 2:
 *
 * <p>Input: "cbbd" Output: "bb"
 */
public class LongestPalindromic {

  public static void main(String[] args) {
    System.out.println((new LongestPalindromic()).longestPalindrome("babad"));
    System.out.println((new LongestPalindromic()).longestPalindrome("cbbd"));
    System.out.println((new LongestPalindromic()).longestPalindrome("aaaa"));
    System.out.println((new LongestPalindromic()).longestPalindrome("ac"));
      System.out.println((new LongestPalindromic()).longestPalindrome("c"));
      System.out.println((new LongestPalindromic()).longestPalindrome(""));
  }

  public String longestPalindrome(String s) {
    if (isPalindrome(s)) {
      return s;
    }
    char[] items = s.toCharArray();
    String res, temp;
    res = temp = items[0] + "";

    for (int i = 1; i < s.length() - 1; i++) {
      res = res.length() < temp.length() ? temp : res;
      for (int j = 1; i - j >= 0 && i + j < s.length(); j++) {
        if (items[i] == items[i - 1] || items[i] == items[i + 1])
          res = res.length() < 2 ? items[i] + "" + items[i] : res;
        if (items[i - j] == items[i + j]) {
          temp = s.substring(i - j, i + j + 1);
          continue;
        } else break;
      }
    }
    res = res.length() < temp.length() ? temp : res;

    return res;
  }

  private boolean isPalindrome(String s) {
    boolean flag = true;
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        flag = false;
      }
    }
    return flag;
  }
}

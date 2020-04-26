package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * <p>Example 1:
 *
 * <p>Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3. Example 2:
 *
 * <p>Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1. Example 3:
 *
 * <p>Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Note that
 * the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {
  public static void main(String[] args) {
    System.out.println((new LongestSubstring()).lengthOfLongestSubstring("abcabcbb"));
    System.out.println((new LongestSubstring()).lengthOfLongestSubstring("bbbbb"));
    System.out.println((new LongestSubstring()).lengthOfLongestSubstring("pwwkew"));
    System.out.println((new LongestSubstring()).lengthOfLongestSubstring("au"));
  }

  public int lengthOfLongestSubstring(String s) {
    char[] stringArray = s.toCharArray();
    if (s.isEmpty()) {
      return 0;
    }
    int res = 1;
    for (int i = 0; i < stringArray.length; i++) {

      List<Character> item = new ArrayList<>();
      item.add(stringArray[i]);
      for (int j = i + 1; j < stringArray.length; j++) {
        if (item.contains(stringArray[j])) {
          res = item.size() > res ? item.size() : res;
          break;
        } else {
          item.add(stringArray[j]);
          res = item.size() > res ? item.size() : res;
          continue;
        }
      }
    }
    return res;
  }
}

package com.company;

import java.util.HashMap;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't
 * exist, return -1.
 *
 * <p>Examples:
 *
 * <p>s = "leetcode" return 0.
 *
 * <p>s = "loveleetcode", return 2. Note: You may assume the string contain only lowercase letters.
 */
public class FirstUnique {

  public int firstUniqChar(String s) {
    int[] freq = new int[26];

    for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;

    for (int i = 0; i < s.length(); i++) if (freq[s.charAt(i) - 'a'] == 1) return i;
    return -1;
  }
}

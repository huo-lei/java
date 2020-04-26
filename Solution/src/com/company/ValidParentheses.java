package com.company;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * <p>An input string is valid if:
 *
 * <p>Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order. Note that an empty string is also considered valid.
 */
public class ValidParentheses {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char item = s.charAt(i);
      if (item == '(' || item == '[' || item == '{') {
        stack.push(item);
        continue;
      }

      if (stack.isEmpty()) {
        return false;
      } else {
        char topChar = stack.pop();
        if (item == ')' && topChar != '(') return false;
        if (item == '}' && topChar != '{') return false;
        if (item == ']' && topChar != '[') return false;
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println((new ValidParentheses()).isValid("()[]{}"));
    System.out.println((new ValidParentheses()).isValid("}"));
  }
}

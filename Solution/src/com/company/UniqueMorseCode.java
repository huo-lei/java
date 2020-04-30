package com.company;

import java.util.TreeSet;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of
 * dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * <p>For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * <p>[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each
 * letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." +
 * "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 *
 * <p>Return the number of different transformations among all words we have. Example: Input: words
 * = ["gin", "zen", "gig", "msg"] Output: 2 Explanation: The transformation of each word is: "gin"
 * -> "--...-." "zen" -> "--...-." "gig" -> "--...--." "msg" -> "--...--."
 *
 * <p>There are 2 different transformations, "--...-." and "--...--.".
 */
public class UniqueMorseCode {
  public int uniqueMorseRepresentations(String[] words) {
    String[] codes = {
      ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
      "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    TreeSet<String> treeSet = new TreeSet<>();
    for (String word : words) {
      StringBuilder res = new StringBuilder();
      for (int i = 0; i < word.length(); i++) {
        res.append(codes[word.charAt(i) - 'a']);
      }
      treeSet.add(res.toString());
    }
    return treeSet.size();
  }

  public static void main(String[] args){

  }
}

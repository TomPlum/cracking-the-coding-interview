package com.github.tomplum.chapter1.question1;

public interface StringUtility {
    /**
     * Question 1.1 - Is Unique
     *
     * @param input Input String
     * @return true if input contains unique characters
     */
    boolean containsUniqueCharacters(String input);

    /**
     * Question 1.2 - String Permutation
     *
     * @param input Input String
     * @param comparator String to check if input is a permutation of
     * @return true if string inputs are permutations of one another
     */
    boolean stringsArePermutation(String input, String comparator);

    /**
     * Question 1.3 - URLify
     *
     * @param input String to URLify
     * @param trueLength The true length of the string when all the spaces are not encoded.
     * @return Input string with all spaces encoded to %20
     */
    String encodeSpaces(String input, int trueLength);

    /**
     * Question 1.4 - Palindrome Permutation
     *
     * @param input String to check if it is a palindrome
     * @return true if palindrome, false if not
     */
    boolean isPalindrome(String input);
}

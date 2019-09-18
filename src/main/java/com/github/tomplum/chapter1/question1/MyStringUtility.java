package com.github.tomplum.chapter1.question1;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * Chapter 1: Arrays and Strings
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * Question 1.1
 *
 * "Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?"
 *
 * Hint #44 - Try a HashTable
 * Hint #117 - Could a bit vector be useful?
 * Hint #132 - Can you solve it in O(N log N) time? What might a solution like that look like?
 *
 * Good answer on BitShifting here: https://stackoverflow.com/a/12811293
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * Question 1.2
 *
 * "String permutation: Given two strings, write a method to decide if one is a permutation of the other"
 *
 * Hint #1 -
 * Hint #84 -
 * Hint #122 -
 * Hint #131 -
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * Question 1.3
 *
 * "URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
 * space at the end to hold the additional characters, and that you are given the "true" length of the string.
 * (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)
 *
 * Hint #58 - Try thinking about the array as circular, such that the end of the array "wraps around" to the start of
 * the array.
 *
 * Hint #118 - You might find you need to know the number of spaces. Can you just count them?
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Thomas Plumpton
 */
public class MyStringUtility implements StringUtility {
    /**
     * Question 1.1 - Is Unique
     * @param input Input String
     * @return true if input contains unique characters
     */
    @Override
    public boolean containsUniqueCharacters(final String input) {
       if (input == null) return true;

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) return false;
            }
        }
        return true;
    }

    /**
     * Question 1.2 - String Permutation
     * @param input Input String
     * @param comparator String to check if input is a permutation of
     * @return true if string inputs are permutations of one another
     */
    @Override
    public boolean stringsArePermutation(String input, String comparator) {
        if (input.length() != comparator.length()) return false;

        char[] sortedInput = input.toCharArray();
        Arrays.sort(sortedInput);

        char[] sortedComparator = comparator.toCharArray();
        Arrays.sort(sortedComparator);

        for (int i = 0; i < comparator.length(); i++) {
            if (sortedInput[i] != sortedComparator[i]) return false;
        }

        return true;
    }

    /**
     * Question 1.3 - URLify
     * @param input String to URLify
     * @param trueLength The true length of the string when all the spaces are not encoded.
     * @return Input string with all spaces encoded to %20
     */
    @Override
    public String encodeSpaces(String input, int trueLength) {
        input =  input.replaceAll(" ", "%20");
        return input.trim();
    }

}
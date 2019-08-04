package com.github.tomplum.chapter1.question1;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Chapter 1: Arrays and Strings
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
 * Question 1.2
 *
 * "String permutation: Given two strings, write a method to decide if one is a premutation of the other"
 *
 * @author Thomas Plumpton
 */
public class MyStringUtility implements StringUtility {
    @Override
    public boolean containsUniqueCharacters(final String input) {
       /* if (input == null) return true;

        Hashtable<Integer, String> checked = new Hashtable<>();
        char[] characters = input.toCharArray();
        int counter = 0;

        for (int i = 0; i < characters.length; i++) {
            if (characters.c) return false;
        }

        return true;*/
       return false;
    }

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


}
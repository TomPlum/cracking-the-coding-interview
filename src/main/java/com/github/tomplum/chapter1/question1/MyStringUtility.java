package com.github.tomplum.chapter1.question1;

import java.util.Arrays;

/**
 * Chapter 1: Arrays and Strings
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
 * Question 1.4
 *
 * "Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. A
 * palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words. You can ignore casing and non-letter characters.
 *
 * Hint #106 - You do not have to - and should not - generate all permutations. This would be very inefficient.
 * Hint #121 - What characteristics would a string that is a permutation of a palindrome have?
 * Hint #134 - Have you tried a hash table? You should be able to get this down to O(N) time.
 * Hint #136 - Can you reduce the space usage by using a bit vector?
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * Question 1.5
 *
 * "One Away: There are three types of edits that can be performed on strings: insert a character, remove a character,
 * or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away."
 *
 * Hint #23 - Start with the easy thing. Can you check each of the conditions separately?
 * Hint #97 - What is the relationship between between the "insert character" and the "remove character" option? Do
 * these two need to be separate checks?
 * Hint #130 - Can you do all three checks in a single pass?
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * Question 1.6
 *
 * "String Compression: Implement a method to perform basic String compression using the counts of repeated characters.
 * For example, the String aabcccccaaa would become a2b1c5a3. If the "compressed" String would not become smaller than
 * the original Sting, your method should return the original String. You can assume that the String has only
 * uppercase and lowercase letters (a-z)."
 *
 * Hint #92 - Do the easy thing first. Compress the String, the compare the lengths.
 * Hint #110 - Be careful that you aren't repeatedly concatenating Strings together. This can be very inefficient.
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * Question 1.7
 *
 * "Rotate Matrix: Given an image represented by an N x N matrix, where each pixel in the image is an integer, write a
 * method to rotate the image by 90 degrees. Can you do it in place?"
 *
 * Hint #51 -
 * Hint #100 -
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Thomas Plumpton
 */
public class MyStringUtility implements StringUtility {

    @Override
    public boolean containsUniqueCharacters(String input) {
        if (input == null) return true;

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) return false;
            }
        }
        return true;
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

    @Override
    public String encodeSpaces(String input, int trueLength) {
        input = input.replaceAll(" ", "%20");
        return input.trim();
    }

    @Override
    public boolean isPalindrome(String input) {
        return input != null && input.equalsIgnoreCase(new StringBuilder(input).reverse().toString());
    }

    @Override
    public boolean isOneEditAway(String before, String after) {
        if (before.equals(after) || (Math.abs(before.length() - after.length())) == 1) return true;

        if (before.length() == after.length()) {
            char[] beforeArray = before.toCharArray();
            char[] afterArray = after.toCharArray();

            int replacedCharacters = 0;

            for (int i = 0; i < beforeArray.length; i++) {
                if (beforeArray[i] != afterArray[i]) replacedCharacters++;
            }

            return replacedCharacters < 2;
        }
        return false;
    }

    @Override
    public String compressString(String input) {
        StringBuilder compressed = new StringBuilder();

        int consecutiveChars = 0;

        for (int i = 0; i < input.length(); i++) {
            consecutiveChars++;

            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressed.append(input.charAt(i));
                compressed.append(consecutiveChars);
                consecutiveChars = 0;
            }
        }

        return compressed.toString().length() < input.length() ? compressed.toString() : input;
    }

    @Override
    public int[][] rotateImage(int x, int y) {
        //Print Image
        int[][] pixels = new int[x][y];
        int count = 1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                pixels[i][j] = count++;
            }
        }

        printImage(pixels);

        return new int[][]{};
    }

    private void printImage(int[][] pixels) {
        for (int x = 0; x < pixels.length; x++) {
            for (int y = 0; y < pixels[1].length; y++) {
                if (pixels[x][y] >= 10 || pixels.length <= 3) {
                    System.out.print("[" + pixels[x][y] + "]");
                } else {
                    System.out.print("[" + pixels[x][y] + " ]");
                }
            }
            System.out.println();
        }
    }

}
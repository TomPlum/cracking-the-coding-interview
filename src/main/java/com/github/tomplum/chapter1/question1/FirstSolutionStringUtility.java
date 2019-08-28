package com.github.tomplum.chapter1.question1;

/**
 * First solution of Gayles.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author Thomas Plumpton
 */
public class FirstSolutionStringUtility implements StringUtility {
    @Override
    public boolean containsUniqueCharacters(String input) {
        if (input == null) return true;

        //Assuming ASCII. Therefore, cannot have > 128 unique characters
        if (input.length() > 128) return false;

        boolean[] charSet = new boolean[128];

        for (int i = 0; i < input.length(); i++) {
            int value = input.charAt(i);
            if (charSet[value]) return false; //Found
            charSet[value] = true;
        }
        return true;
    }

    @Override
    public boolean stringsArePermutation(String input, String comparator) {
        return false;
    }

    @Override
    public String encodeSpaces(String input, int trueLength) {
        return null;
    }
}

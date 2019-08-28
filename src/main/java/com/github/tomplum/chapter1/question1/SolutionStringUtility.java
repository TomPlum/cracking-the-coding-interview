package com.github.tomplum.chapter1.question1;

/**
 * Assuming that the string inputs are only lower-case letters a-z.
 *
 * @author Thomas Plumpton
 */
public class SolutionStringUtility implements StringUtility {
    @Override
    public boolean containsUniqueCharacters(final String input) {
        if (input == null) return true;

        int checker = 0;
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    @Override
    public boolean stringsArePermutation(String input, String comparator) {
        if (input.length() != comparator.length()) return false; //Permutations must be same length

        int[] letters = new int[128]; //Assuming ASCII
        for (int i = 0; i < input.length(); i++) {
            letters[input.charAt(i)]++;
        }

        for (int i = 0; i < comparator.length(); i++) {
            if (letters[input.charAt(i)] < 0) {
                return false;
            }
        }

        return true; //letters has no negative values, and therefore no positive values either.
    }

    @Override
    public String encodeSpaces(String input, int trueLength) {
        return null;
    }
}

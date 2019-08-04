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
        return false;
    }
}

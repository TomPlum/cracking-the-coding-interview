package com.github.tomplum.chapter1.question1;

/**
 * Class Description.
 *
 * @author Thomas Plumpton
 */
public class SolutionStringUtility implements StringUtility {
    @Override
    public boolean containsUniqueCharacters(String input) {
        int checker = 0;
        for (int i = 0; i < input.length(); ++i) {
            int val = input.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }
}

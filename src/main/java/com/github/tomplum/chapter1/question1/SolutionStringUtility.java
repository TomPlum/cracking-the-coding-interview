package com.github.tomplum.chapter1.question1;

/**
 * @author Thomas Plumpton
 */
public class SolutionStringUtility implements StringUtility {
    @Override
    public boolean containsUniqueCharacters(String input) {
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
        char[] str = input.toCharArray();
        int numberOfSpaces = countOccurrencesOfChar(str, 0, trueLength, ' ');
        int newIndex = trueLength - 1 + numberOfSpaces * 2;

        /* If there are excess spaces, add a null character. This indicates that the spaces after that point have
        not been replace with %20 */
        if (newIndex + 1 < str.length) str[newIndex + 1] = '\0';
        for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1) {
            if (str[oldIndex] == ' ') {
                str[newIndex] = '0';
                str[newIndex - 1] = '2';
                str[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                str[newIndex] = str[oldIndex];
                newIndex -= 1;
            }
        }

        return new String(str);
    }

    @Override
    public boolean isPalindrome(String input) {
        return false;
    }

    @Override
    public boolean isOneEditAway(String before, String after) {
        /* Length checks. */
        if (Math.abs(before.length() - after.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string.*/
        String s1 = before.length() < after.length() ? before : after;
        String s2 = before.length() < after.length() ? after : before;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                /* Ensure that this is the first difference found.*/
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) { // On replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }
        return true;
    }

    @Override
    public String compressString(String input) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < input.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressed.append(input.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < input.length() ? compressed.toString() : input;
    }

    @Override
    public int[][] rotateImage(int x, int y) {
        return new int[0][];
    }

    private int countOccurrencesOfChar(char[] str, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (str[i] == target) count++;
        }
        return count;
    }
}

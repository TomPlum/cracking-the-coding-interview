package com.github.tomplum.chapter1.question1;

/**
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

    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        int[] table = buildCharFrequencyTable(input);
        return checkMaxOneOdd(table);
    }

    @Override
    public boolean isOneEditAway(String before, String after) {
        return false;
    }

    @Override
    public String compressString(String input) {
        String compressedString = "";
        int countConsecutive = 0;
        for (int i = 0; i < input.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressedString += "" + input.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressedString.length() < input.length() ? compressedString : input;
    }

    @Override
    public int[][] rotateImage(int x, int y) {
        return new int[0][];
    }

    private boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    private int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a' + 1)];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) table[x]++;
        }
        return table;
    }
}

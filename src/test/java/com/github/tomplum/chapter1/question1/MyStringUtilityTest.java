package com.github.tomplum.chapter1.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class MyStringUtilityTest {
    private final StringUtility utility = new MyStringUtility();

    @Tag("1.1")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef", "abc45678def", "-/'~#@", "abc123-/_"})
    @DisplayName("Input string contains only characters that are unique. Should return true.")
    void containsOnlyUnique(String input) {
        boolean result = utility.containsUniqueCharacters(input);
        assertThat(result).isTrue();
    }

    @Tag("1.1")
    @ParameterizedTest
    @ValueSource(strings = {"aabcdfre", "aabcd66fre", "aabcd66fr--;;e"})
    @DisplayName("Input string contains duplicate characters. Should return false.")
    void containsDuplicate(String input) {
        boolean result = utility.containsUniqueCharacters(input);
        assertThat(result).isFalse();
    }

    @Tag("1.2")
    @ParameterizedTest
    @CsvSource({"abcd, dcba", "1234, 4312", "-/;@, @-/;"})
    @DisplayName("Given that the two strings are permutations of each other, should return true.")
    void stringsArePermutationsOfEachOther(String input, String comparator) {
        boolean result = utility.stringsArePermutation(input, comparator);
        assertThat(result).isTrue();
    }

    @Tag("1.2")
    @ParameterizedTest
    @CsvSource({"abcd, dcgba", "1234, 412", "-/;@, -/;", "abcdefghi, abcde"})
    @DisplayName("Given that the two strings are not permutations of each other, should return false.")
    void stringsAreNotPermutationsOfEachOther(String input, String comparator) {
        boolean result = utility.stringsArePermutation(input, comparator);
        assertThat(result).isFalse();
    }

    @Test
    @Tag("1.3")
    @DisplayName("When the input string contains a single space separating two words, it should encode that single space")
    void singleSpaceBetweenWords() {
        String input = "Thomas Plumpton";
        int trueLength = 14;

        String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("Thomas%20Plumpton");
    }

    @Test
    @Tag("1.3")
    @DisplayName("When the input string is just a single space, it should just return %20.")
    void stringIsOnlyOneSpace() {
        String input = " ";
        int trueLength = 0;

        String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("%20");
    }

    @Test
    @Tag("1.3")
    @DisplayName("When the input string contains multiple words separated by spaces, it should encode all spaces.")
    void multipleWordsSeparatedBySpaces() {
        String input = "a b c";
        int trueLength = 3;

        String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("a%20b%20c");
    }

    @Test
    @Tag("1.3")
    @DisplayName("When the string contains two consecutive spaces, it should encode both of them.")
    void stringContainsTwoConsecutiveSpaces() {
        String input = "a  b";
        int trueLength = 2;

        String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("a%20%20b");
    }

    @Tag("1.4")
    @EmptySource
    @ParameterizedTest
    @DisplayName("Given the input String is a palindrome, it should return true")
    @ValueSource(strings = {"tacocat", "abcecba", "RACECAR", "level", "civic", "Able was I ere I saw Elba"})
    void stringIsPalindrome(String input) {
        assertThat(utility.isPalindrome(input)).isTrue();
    }

    @Tag("1.4")
    @NullSource
    @ParameterizedTest
    @DisplayName("Given the input String is not a palindrome, it should return false")
    @ValueSource(strings = {"tacoccat", "word", "notapalindrome", " racecar"})
    void stringIsNotPalindrome(String input) {
        assertThat(utility.isPalindrome(input)).isFalse();
    }

    @Tag("1.5")
    @ParameterizedTest
    @CsvSource({"example, example", "string, string", "same, same", "123, 123", "-/@#, -/@#"})
    @DisplayName("Given the strings have no edits between them (they are the same), it should return true")
    void inputStringsHaveNoEditsDifference(String before, String after) {
        boolean response = utility.isOneEditAway(before, after);
        assertThat(response).isTrue();
    }

    @Tag("1.5")
    @ParameterizedTest
    @CsvSource({"example, examples", "different, differnt", "123, 153", "-[;, [;"})
    @DisplayName("Given the strings have exactly one edit difference between them, it should return true")
    void inputStringsHaveExactlyOneEditDifference(String before, String after) {
        boolean response = utility.isOneEditAway(before, after);
        assertThat(response).isTrue();
    }

    @Tag("1.5")
    @ParameterizedTest
    @CsvSource({"something, sething", "12345, 19365", "sentence, biggersentence"})
    @DisplayName("Given the strings have more than more than one difference between them, it should return false")
    void inputStringsHaveMoreThanOneDifference(String before, String after) {
        boolean response = utility.isOneEditAway(before, after);
        assertThat(response).isFalse();
    }

    @Test
    @Tag("1.6")
    @DisplayName("The input string can benefit from compression and therefore should be return compressed")
    void stringCanBeCompressed() {
        String input = "aaabccccccdd";
        String compressed = utility.compressString(input);
        assertThat(compressed).isEqualTo("a3b1c6d2");
    }

    @Test
    @Tag("1.6")
    void stringCannotBeCompressed() {
        String input = "abcdef";
        String result = utility.compressString(input);
        assertThat(result).isEqualTo(input);
    }
}
package com.github.tomplum.chapter1.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Thomas Plumpton
 */
class SolutionStringUtilityTest {
    private final StringUtility utility = new SolutionStringUtility();

    @Tag("Question 1.1")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef", "kjsopw", "lkqwer", "zxcvbnm"})
    @DisplayName("Input string contains only characters that are unique. Should return true.")
    void containsOnlyUnique(String input) {
        boolean result = utility.containsUniqueCharacters(input);
        assertThat(result).isTrue();
    }

    @Tag("Question 1.1")
    @ParameterizedTest
    @ValueSource(strings = {"aabcdfre", "aabcd66fre", "aabcd66fr--;;e"})
    @DisplayName("Input string contains duplicate characters. Should return false.")
    void containsDuplicate(String input) {
        boolean result = utility.containsUniqueCharacters(input);
        assertThat(result).isFalse();
    }

    @Tag("Question 1.2")
    @ParameterizedTest
    @CsvSource({"abcd, dcba", "1234, 4312", "-/;@, @-/;"})
    @DisplayName("Given that the two strings are permutations of each other, should return true.")
    void stringsArePermutationsOfEachOther(String input, String comparator) {
        boolean result = utility.stringsArePermutation(input, comparator);
        assertThat(result).isTrue();
    }

    @Tag("Question 1.2")
    @ParameterizedTest
    @CsvSource({"abcd, dcgba", "1234, 412", "-/;@, -/;", "abcdefghi, abcde"})
    @DisplayName("Given that the two strings are not permutations of each other, should return false.")
    void stringsAreNotPermutationsOfEachOther(String input, String comparator) {
        boolean result = utility.stringsArePermutation(input, comparator);
        assertThat(result).isFalse();
    }

    @Tag("Question 1.3")
    @ParameterizedTest
    @CsvSource({" a , 1", "  a  , 1"})
    void stringContainsSpaces(String input, int trueLength) {
        String result = utility.encodeSpaces(input, trueLength);
    }

    @Test
    @Tag("Question 1.3")
    @DisplayName("When the input string contains a single space separating two words, it should encode that single space")
    void singleSpaceBetweenWords() {
        String input = "Thomas Plumpton  ";
        int trueLength = 15;

        String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("Thomas%20Plumpton");
    }

    @Test
    @Tag("Question 1.3")
    @DisplayName("When the input string is just a single space, it should just return %20.")
    void stringIsOnlyOneSpace() {
        String input = "   ";
        int trueLength = 1;

        String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("%20");
    }

    @Test
    @Tag("Question 1.3")
    @DisplayName("When the input string contains multiple words separated by spaces, it should encode all spaces.")
    void multipleWordsSeparatedBySpaces() {
        String input = "a b c    ";
        int trueLength = 5;

        String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("a%20b%20c");
    }

    @Test
    @Tag("Question 1.3")
    @DisplayName("When the string contains two consecutive spaces, it should encode both of them.")
    void stringContainsTwoConsecutiveSpaces() {
        String input = "a  b    ";
        int trueLength = 4;

        String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("a%20%20b");
    }
}

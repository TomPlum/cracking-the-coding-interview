package com.github.tomplum.chapter1.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class MyStringUtilityTest {
    private final StringUtility utility = new MyStringUtility();

    @Tag("Question 1.1")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef", "abc45678def", "-/'~#@", "abc123-/_"})
    @DisplayName("Input string contains only characters that are unique. Should return true.")
    void containsOnlyUnique(final String input) {
        final boolean result = utility.containsUniqueCharacters(input);
        assertThat(result).isTrue();
    }

    @Tag("Question 1.1")
    @ParameterizedTest
    @ValueSource(strings = {"aabcdfre", "aabcd66fre", "aabcd66fr--;;e"})
    @DisplayName("Input string contains duplicate characters. Should return false.")
    void containsDuplicate(final String input) {
        final boolean result = utility.containsUniqueCharacters(input);
        assertThat(result).isFalse();
    }

    @Tag("Question 1.2")
    @ParameterizedTest
    @CsvSource({"abcd, dcba", "1234, 4312", "-/;@, @-/;"})
    @DisplayName("Given that the two strings are permutations of each other, should return true.")
    void stringsArePermutationsOfEachOther(final String input, final String comparator) {
        final boolean result = utility.stringsArePermutation(input, comparator);
        assertThat(result).isTrue();
    }

    @Tag("Question 1.2")
    @ParameterizedTest
    @CsvSource({"abcd, dcgba", "1234, 412", "-/;@, -/;", "abcdefghi, abcde"})
    @DisplayName("Given that the two strings are not permutations of each other, should return false.")
    void stringsAreNotPermutationsOfEachOther(final String input, final String comparator) {
        final boolean result = utility.stringsArePermutation(input, comparator);
        assertThat(result).isFalse();
    }

    @Tag("Question 1.3")
    @ParameterizedTest
    @CsvSource({" a , 1", "  a  , 1"})
    void stringContainsSpaces(final String input, final int trueLength) {
        final String result = utility.encodeSpaces(input, trueLength);
    }

    @Test
    @Tag("Question 1.3")
    @DisplayName("When the input string contains a single space separating two words, it should encode that single space")
    void singleSpaceBetweenWords() {
        final String input = "Thomas Plumpton";
        final int trueLength = 14;

        final String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("Thomas%20Plumpton");
    }

    @Test
    @Tag("Question 1.3")
    @DisplayName("When the input string is just a single space, it should just return %20.")
    void stringIsOnlyOneSpace() {
        final String input = " ";
        final int trueLength = 0;

        final String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("%20");
    }

    @Test
    @Tag("Question 1.3")
    @DisplayName("When the input string contains multiple words separated by spaces, it should encode all spaces.")
    void multipleWordsSeparatedBySpaces() {
        final String input = "a b c";
        final int trueLength = 3;

        final String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("a%20b%20c");
    }

    @Test
    @Tag("Question 1.3")
    @DisplayName("When the string contains two consecutive spaces, it should encode both of them.")
    void stringContainsTwoConsecutiveSpaces() {
        final String input = "a  b";
        final int trueLength = 2;

        final String result = utility.encodeSpaces(input, trueLength);

        assertThat(result).isEqualTo("a%20%20b");
    }
}
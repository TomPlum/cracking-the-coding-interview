package com.github.tomplum.chapter1.question1;

import org.junit.jupiter.api.DisplayName;
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

    //Question 1.1
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef", "kjsopw", "lkqwer", "zxcvbnm"})
    @DisplayName("Input string contains only characters that are unique. Should return true.")
    void containsOnlyUnique(final String input) {
        final boolean result = utility.containsUniqueCharacters(input);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aabcdfre", "aabcd66fre", "aabcd66fr--;;e"})
    @DisplayName("Input string contains duplicate characters. Should return false.")
    void containsDuplicate(final String input) {
        final boolean result = utility.containsUniqueCharacters(input);
        assertThat(result).isFalse();
    }

    //Question 1.2
    @ParameterizedTest
    @CsvSource({"abcd, dcba", "1234, 4312", "-/;@, @-/;"})
    @DisplayName("Given that the two strings are permutations of each other, should return true.")
    void stringsArePermutationsOfEachOther(final String input, final String comparator) {
        final boolean result = utility.stringsArePermutation(input, comparator);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"abcd, dcgba", "1234, 412", "-/;@, -/;", "abcdefghi, abcde"})
    @DisplayName("Given that the two strings are not permutations of each other, should return false.")
    void stringsAreNotPermutationsOfEachOther(final String input, final String comparator) {
        final boolean result = utility.stringsArePermutation(input, comparator);
        assertThat(result).isFalse();
    }
}

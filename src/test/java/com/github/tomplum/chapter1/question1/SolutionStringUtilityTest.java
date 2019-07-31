package com.github.tomplum.chapter1.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Class Description.
 *
 * @author Thomas Plumpton
 */
class SolutionStringUtilityTest {
    private final StringUtility algorithm = new SolutionStringUtility();

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef", "kjsopw", "lkqwer", "zxcvbnm"})
    @DisplayName("Input string contains only characters that are unique. Should return true.")
    void containsOnlyUnique(final String input) {
        final boolean result = algorithm.containsUniqueCharacters(input);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aabcdfre", "aabcd66fre", "aabcd66fr--;;e"})
    @DisplayName("Input string contains duplicate characters. Should return false.")
    void containsDuplicate(final String input) {
        final boolean result = algorithm.containsUniqueCharacters(input);
        assertThat(result).isFalse();
    }
}

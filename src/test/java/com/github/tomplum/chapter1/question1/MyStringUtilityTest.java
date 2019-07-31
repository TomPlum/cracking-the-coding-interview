package com.github.tomplum.chapter1.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class MyStringUtilityTest {
    private final MyStringUtility algorithm = new MyStringUtility();

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef", "abc45678def", "-/'~#@", "abc123-/_"})
    @DisplayName("Input string contains only characters that are unique. Should return true.")
    void containsOnlyUnique(final String input) {
        boolean result = algorithm.containsUniqueCharacters(input);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aabcdfre", "aabcd66fre", "aabcd66fr--;;e"})
    @DisplayName("Input string contains duplicate characters. Should return false.")
    void containsDuplicate(final String input) {
        boolean result = algorithm.containsUniqueCharacters(input);
        assertThat(result).isFalse();
    }
}
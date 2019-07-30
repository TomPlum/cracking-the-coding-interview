package com.github.tomplum.chapter1.question1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class StringUtilityTest {
    private final StringUtility algorithm = new StringUtility();

    @Test
    void stringContainsOnlyUniqueLetters_shouldReturnTrue() {
        String string = "abcdef";
        boolean result = algorithm.containsUniqueCharacters(string);
        assertThat(result).isTrue();
    }

    @Test
    void stringContainsOnlyUniqueAlphaNumericCharacters_shouldReturnTrue() {
        String string = "abc45678def";
        boolean result = algorithm.containsUniqueCharacters(string);
        assertThat(result).isTrue();
    }

    @Test
    void stringContainsOnlyUniqueCharacters_shouldReturnTrue() {
        String string = "abc45678def-/:;";
        boolean result = algorithm.containsUniqueCharacters(string);
        assertThat(result).isTrue();
    }

    @Test
    void stringIsEmpty_shouldReturnTrue() {
        String string = "";
        boolean result = algorithm.containsUniqueCharacters(string);
        assertThat(result).isTrue();
    }

    @Test
    void stringIsNull_shouldReturnTrue() {
        String string = null;
        boolean result = algorithm.containsUniqueCharacters(string);
        assertThat(result).isTrue();
    }

    @Test
    void stringContainsDuplicateLetters_shouldReturnFalse() {
        String string = "aabcdfre";
        boolean result = algorithm.containsUniqueCharacters(string);
        assertThat(result).isFalse();
    }

    @Test
    void stringContainsDuplicateAlphaNumericCharacters_shouldReturnFalse() {
        String string = "aabcd66fre";
        boolean result = algorithm.containsUniqueCharacters(string);
        assertThat(result).isFalse();
    }

    @Test
    void stringContainsDuplicateCharacters_shouldReturnFalse() {
        String string = "aabcd66fr--;;e";
        boolean result = algorithm.containsUniqueCharacters(string);
        assertThat(result).isFalse();
    }
}
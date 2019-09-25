package com.github.tomplum.chapter1.question1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Class Description.
 *
 * @author Thomas Plumpton
 */
class FirstSolutionStringUtilityTest {
    private final StringUtility utility = new FirstSolutionStringUtility();

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
    @ValueSource(strings = {"tacoccat", "word", "notapalindrome", " racecars"})
    void stringIsNotPalindrome(String input) {
        assertThat(utility.isPalindrome(input)).isFalse();
    }
}

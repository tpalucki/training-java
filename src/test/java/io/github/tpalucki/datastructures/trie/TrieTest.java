package io.github.tpalucki.datastructures.trie;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class TrieTest {

    @Nested
    class Search {
        @Test
        void givenEmptyTrieWhenSearchThenShouldReturnEmptySet() {
            var trie = new Trie();

            assertThat(trie.search("prefix")).isEmpty();
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "ab", "abc", "abcd"})
        void givenOnePrefixWhenSearchThenShouldReturnOneSet(String prefix) {
            var trie = new Trie();
            trie.insert(prefix);

            assertThat(trie.search(prefix)).containsExactly(prefix);
        }

        @Test
        void givenMultiplePrefixesInTreeWhenSearchThenShouldReturnOnlyMatching() {
            var trie = new Trie();
            trie.insert("a");
            trie.insert("ab");
            trie.insert("abc");
            trie.insert("abcd");

            trie.insert("bumblebee");
            trie.insert("binary");
            trie.insert("bank");

            trie.insert("call");
            trie.insert("cold");
            trie.insert("cat");
            trie.insert("caterpillar");

            trie.insert("ace");
            trie.insert("abba");
            trie.insert("abacus");
            trie.insert("abel");
            trie.insert("abduction");

            // skip [a, ab, abc] - because overwritten with other entries
            assertThat(trie.search("ab")).containsExactlyInAnyOrder("abcd", "abba", "abacus", "abel", "abduction");
        }

    }
}
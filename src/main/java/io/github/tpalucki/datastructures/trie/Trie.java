package io.github.tpalucki.datastructures.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

interface PrefixSearch {
    Set<String> search(String prefix);

    void insert(String prefix);
}

interface PrefixInsert {
    void insert(String prefix);
}

public class Trie implements PrefixSearch, PrefixInsert {

    private final TrieNode root;

    public Trie() {
        root = new TrieRootNode();
    }

    @Override
    public Set<String> search(String prefix) {
        return root.search(prefix);
    }

    @Override
    public void insert(String prefix) {
        root.insert(prefix);
    }

    final class TrieRootNode extends TrieNode {
        TrieRootNode() {
            this.children = new HashMap<>();
        }
    }

    final class TrieChildNode extends TrieNode {
        private String value;

        TrieChildNode(String value) {
            this.value = value;
            this.children = new HashMap<>();
        }

        // todo not sure if needed yet
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isWord() {
            return false; // TODO implement it
        }
    }

    sealed abstract class TrieNode implements PrefixInsert, PrefixSearch permits TrieRootNode, TrieChildNode {
        protected Map<String, TrieNode> children;

        @Override
        public void insert(String prefix) {
            requireNonNull(prefix, "prefix cannot be null");
            if (prefix.isEmpty()) {
                return;
            }
            var firstLetter = prefix.substring(0, 1).toLowerCase();
            var hasKey = children.containsKey(firstLetter);
            switch (hasKey) {
                case true -> children.get(firstLetter).insert(prefix.substring(1));
                case false -> {
                    var child = new TrieChildNode(firstLetter);
                    children.put(firstLetter, child);
                    child.insert(prefix.substring(1));
                }
            }
        }

        @Override
        public Set<String> search(String prefix) {
            requireNonNull(prefix, "prefix cannot be null");
            if (prefix.isEmpty()) {
                return collectAllWords();  // Collect all subtrees, not just ""
            }

            var firstLetter = prefix.substring(0, 1).toLowerCase();
            var hasKey = children.containsKey(firstLetter);
            if (!hasKey) {
                return Set.of();
            }
            TrieNode child = children.get(firstLetter);
            return child.search(prefix.substring(1)).stream().map(searchResultPrefix -> firstLetter + searchResultPrefix).collect(Collectors.toSet());
        }

        private Set<String> collectAllWords() {
            Set<String> results = new java.util.HashSet<>();
            if (this instanceof TrieChildNode childNode && childNode.isWord()) {
                results.add("");
            }
            for (var entry : children.entrySet()) {
                var key = entry.getKey();
                var node = entry.getValue();
                node.collectAllWords().stream().map(word -> key + word).forEach(results::add);
            }
            return results;
        }
    }
}

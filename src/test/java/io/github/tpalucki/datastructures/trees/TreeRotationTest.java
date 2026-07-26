package io.github.tpalucki.datastructures.trees;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeRotationTest {

    @Nested
    class IsBalanced {
        @Test
        void isBalanced() {
            // balanced tree
            var a = new Node(5, null, null);
            var b = new Node(2, null, null);
            var x = new Node(4, b, a);
            var z = new Node(8, null, null);
            var y = new Node(6, x, z);

            BinarySearchTree tree = new BinarySearchTree(y);
            assertTrue(tree.isBalanced());
        }

        @Disabled("Balance is enforced in constructor")
        @Test
        void isNotBalanced() {
            // unbalanced tree
            var a = new Node(5, null, null);
            var b = new Node(2, null, null);
            var x = new Node(4, b, a);
            var z = new Node(8, null, null);
            var y = new Node(6, x, z);
            var w = new Node(10, y, null);

            BinarySearchTree tree = new BinarySearchTree(w);
            assertFalse(tree.isBalanced());
        }
    }

    @Nested
    class RightRotation {
        @Test
        void rotateRight() {
            // tree before right rotation
            var a = new Node(5, null, null);
            var b = new Node(2, null, null);
            var x = new Node(4, b, a);
            var z = new Node(8, null, null);
            var y = new Node(6, x, z);

            BinarySearchTree treeOriginal = new BinarySearchTree(y);

            // expected
            var a1 = new Node(5, null, null);
            var b1 = new Node(2, null, null);
            var z1 = new Node(8, null, null);
            var y1 = new Node(6, a1, z1);
            var x1 = new Node(4, b1, y1);
            BinarySearchTree expectedTree = new BinarySearchTree(x1);

            assertTrue(expectedTree.equals(treeOriginal.rotateRight()));
        }
    }
}
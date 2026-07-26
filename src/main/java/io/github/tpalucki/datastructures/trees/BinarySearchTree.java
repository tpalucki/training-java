package io.github.tpalucki.datastructures.trees;

record Node(int value, Node left, Node right) {

    public Node {
        if (left != null && left.value() > value) {
            throw new IllegalArgumentException("Left is greater than value");
        }
        if (right != null && right.value() < value) {
            throw new IllegalArgumentException("Right is less than value");
        }
    }
}

class BinarySearchTree {
    private final Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public boolean equals(BinarySearchTree obj) {
        return root.equals(obj.root);
    }

    // todo add rotateLeft operation
    BinarySearchTree rotateRight() {
        var left = root.left();
        var leftRightSubtree = left.right();
        var leftLeftSubtree = left.left();

        var right = root.right();

        var newRight = new Node(root.value(), leftRightSubtree, right);

        return new BinarySearchTree(new Node(left.value(), leftLeftSubtree, newRight));
    }

    public boolean isBalanced() {
        return this.isBalanced(root);
    }

    // todo too simple - depends on tree type there are additional rules,
    //  here left smaller, right greater rule is enforced in constructor
    boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left()) && isBalanced(root.right());
    }

}

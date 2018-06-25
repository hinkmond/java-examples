public class JavaDistanceTwoNodesInBinaryTree {
    // Change to true to debug
    private static final boolean DEBUG = false;

    public static class Node {
        int value;
        Node left;
        Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    // Find the Lowest Common Ancestor (LCA) of the two nodes which the distance is being measured
    private static Node findLCA(Node root, int n1, int n2) {
        // Check edge condition if root is null
        if (root == null) {
            return null;
        }

        // Check if reach either n1 or n2, then return the root which is one of the branches of the LCA
        if ((root.value == n1) || (root.value == n2)) {
            return root;
        }

        Node leftBranchCheck = findLCA(root.left, n1, n2);
        Node rightBranchCheck = findLCA(root.right, n1, n2);

        // Check if found both n1 and n2 exists in leftCheck and rightCheck return values,
        //   then root has the LCA
        if ((leftBranchCheck != null) && (rightBranchCheck != null)) {
            if (DEBUG) {
                System.out.println("Found LCA = " + root.value);
            }
            return root;
        }

        // Recurse down left tree if LCA of both nodes still in left tree, else LCA of both is still down right tree
        if (leftBranchCheck != null) {
            return findLCA(root.left, n1, n2);
        } else {
            return findLCA(root.right, n1, n2);
        }
    }

    // Get the level (distance from root) to any given value in the binary tree
    private static int getLevel(Node root, int searchValue, int currLevel) {
        // Check if passing in edge condition
        if (root == null) {
            return -1;
        }

        // Check if now reached the value being searched
        if (root.value == searchValue) {
            return currLevel;
        }

        // Get the left tree distance to the searchValue.  If left does not have the value, the level will be -1
        int leftLevel = getLevel(root.left, searchValue, currLevel + 1);

        // If left tree does not have the searchValue, it must be in the right tree
        if (leftLevel == -1) {
            return getLevel(root.right, searchValue, currLevel + 1);
        }

        // It wasn't in right tree, so return the left tree distance
        return leftLevel;
    }

    private static int findDistance(Node root, int n1, int n2) {
        Node lcaNode = findLCA(root, n1, n2);
        if (DEBUG) {
            System.out.println("LCA of: " + n1 + ":" + n2 + " is = " + lcaNode.value);
        }

        int distN1fromLCA = getLevel(lcaNode, n1, 0);
        int distN2fromLCA = getLevel(lcaNode, n2, 0);

        return distN1fromLCA + distN2fromLCA;
    }

    // Driver program to test above functions
    public static void main(String[] args) {

        // Let us create binary tree given in
        // the above example
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println("Dist(4, 5) = "
                + findDistance(root, 4, 5));

        System.out.println("Dist(4, 6) = "
                + findDistance(root, 4, 6));

        System.out.println("Dist(3, 4) = "
                + findDistance(root, 3, 4));

        System.out.println("Dist(2, 4) = "
                + findDistance(root, 2, 4));

        System.out.println("Dist(8, 5) = "
                + findDistance(root, 8, 5));

    }
}

package trees.treeMap;

// TreeNode class
class TreeNode<K extends Comparable<K>, V> {
    K key;
    V value;
    TreeNode<K, V> left, right;

    TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class TreeMap<K extends Comparable<K>, V> {
    private TreeNode<K, V> root;

    public void put(K key, V value) {
        root = insert(key, value, root);
    }

    private TreeNode<K, V> insert(K key, V value, TreeNode<K, V> node) {
        if (node == null) {
            return new TreeNode<>(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = insert(key, value, node.left);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(key, value, node.right);
        } else node.value = value; // key already exists as compareTo send 0

        return node;
    }

    public V get(K key) {
        return search(root, key);
    }

    private V search(TreeNode<K, V> node, K key) {
        if (node == null) {
            return null; // Key not found
        }

        if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return search(node.right, key);
        } else return node.value; // key found

    }

    public void remove(K key) {
        root = remove(root, key);
    }

    private TreeNode<K, V> remove(TreeNode<K, V> node, K key) {
        if (node == null) return null;  // Base case: Key not found

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);  // Search in left subtree
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);  // Search in right subtree
        } else {
            // Node found! Handle 4 cases:

            // Case 1: No child
            if (node.left == null && node.right == null) {
                return null;  // Just remove the node
            }
            // Case 2: One child (right exists)
            else if (node.left == null) {
                return node.right;
            }
            // Case 2: One child (left exists)
            else if (node.right == null) {
                return node.left;
            }
            // Case 3: Two children
            else {
                // Find in-order successor (smallest node in right subtree)
                TreeNode<K, V> successor = findMin(node.right);
                node.key = successor.key;
                node.value = successor.value;
                node.right = remove(node.right, successor.key);  // Delete successor
            }
        }
        return node;
    }

    // Helper function to find the smallest node in a subtree
    private TreeNode<K, V> findMin(TreeNode<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}

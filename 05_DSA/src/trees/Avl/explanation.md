# AVL Tree Notes

## What is an AVL Tree?

An AVL (Adelson-Velsky and Landis) tree is a self-balancing binary search tree (BST). It's named after its inventors. The key property that distinguishes an AVL tree from a regular BST is its **self-balancing mechanism**.

For every node in an AVL tree, the **height difference between its left and right subtrees (known as the balance factor) must be at most 1**. The balance factor for a node is calculated as `height(left_subtree) - height(right_subtree)`. It can only be -1, 0, or 1. If at any point this property is violated after an insertion or deletion operation, the tree performs rotations to rebalance itself.

## Self-Balancing Mechanism (Rotations)

When an insertion or deletion causes a node's balance factor to become -2 or +2, the AVL tree performs one or more of the following rotations to restore balance:

1.  **Left Rotation:** Used when a node's right-right child causes imbalance.
2.  **Right Rotation:** Used when a node's left-left child causes imbalance.
3.  **Left-Right Rotation (Double Rotation):** Combination of left then right rotation. Used when a node's left-right child causes imbalance.
4.  **Right-Left Rotation (Double Rotation):** Combination of right then left rotation. Used when a node's right-left child causes imbalance.

These rotations efficiently reconfigure the tree structure to maintain the height balance property.

## Advantages of AVL Trees

1.  **Guaranteed Logarithmic Time Complexity:** Because AVL trees are always balanced, search, insertion, and deletion operations are guaranteed to take $O(\log N)$ time in the worst case, where $N$ is the number of nodes. This is a significant improvement over regular BSTs, which can degenerate to $O(N)$ in the worst case (e.g., a skewed tree).
2.  **Efficient Range Queries:** Due to their sorted nature and balanced structure, range queries (finding all elements within a specific range) can be performed efficiently.
3.  **Predictable Performance:** The consistent $O(\log N)$ performance makes AVL trees suitable for applications where predictable response times are crucial.

## Disadvantages of AVL Trees

1.  **Increased Complexity of Implementation:** Implementing AVL trees is more complex than regular BSTs dueabs to the need for balance factor tracking and rotation logic after every insertion or deletion.
2.  **Higher Constant Factors:** While the asymptotic complexity is $O(\log N)$, the constant factors involved in operations (due to balance factor calculations and rotations) can be slightly higher than for an unbalanced BST in the average case. This might make them marginally slower for operations on very small datasets where the overhead of balancing outweighs the benefits.
3.  **More Memory Overhead:** Each node in an AVL tree typically requires extra space to store its height or balance factor, adding to the memory footprint compared to a simple BST.
4.  **Less Flexible for Non-Unique Keys:** While possible, handling duplicate keys in AVL trees can add further complexity to the implementation.

## Use Cases of AVL Trees

1.  **Database Indexing:** Used in database systems to efficiently store and retrieve data, ensuring fast lookups, insertions, and deletions.
2.  **Symbol Tables in Compilers:** Compilers use symbol tables to store information about variables, functions, etc. AVL trees can provide efficient access to this information.
3.  **Sets and Maps (Ordered Collections):** When you need a dynamic set or map data structure where elements are always kept in sorted order and efficient $O(\log N)$ operations are required (e.g., C++ `std::map` or `std::set` are often implemented using balanced BSTs, though typically Red-Black Trees).
4.  **Network Routers:** Can be used to store routing tables, where fast lookups for next-hop destinations are critical.
5.  **Applications Requiring Guaranteed Performance:** Any application where worst-case performance is a critical concern and consistent $O(\log N)$ behavior is necessary.
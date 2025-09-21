# Java-with-DSA 📚⚔️
> A structured, hands‑on journey through core Data Structures & Algorithms in Java.

## 🌟 Overview
Java-with-DSA is a curated collection of Java implementations, examples, and practice problems covering foundational and intermediate data structures and algorithms.  
It is meant as a personal learning log and a reference for revision and interview prep.  
Each topic aims to pair: (1) clean Java implementation, (2) complexity analysis, and (3) (optional) problem variations.

## 🎯 Learning Objectives
- Master time & space complexity intuition (Big-O)
- Build reusable implementations of common data structures
- Practice algorithmic paradigms: recursion, divide & conquer, greedy, backtracking, dynamic programming, graph traversal
- Strengthen problem‑solving patterns for interviews

## 🗂 Content Map (Planned / Typical)
| Category | Topics (examples) |
|----------|-------------------|
| Arrays & Strings | Two-pointer, Sliding Window, Prefix/Suffix, Kadane |
| Linked Lists | Singly, Doubly, Fast/Slow pointer tricks, Reversal |
| Stacks & Queues | Stack via arrays/list, Min Stack, Queue via stacks, Circular queue |
| Hashing | Frequency maps, Set usage, Collision concepts |
| Trees | Binary Tree, BST ops, Traversals (DFS/BFS), Height, Balance, Lowest Common Ancestor |
| Heaps / PriorityQueue | Min/Max heap usage, HeapSort rationale |
| Tries (Prefix Trees) | Insert, search, word break style usage |
| Graphs | Representations (Adj List/Matrix), BFS, DFS, Topological Sort, Cycle detection, Shortest path (BFS / Dijkstra – 🔧), Union-Find |
| Recursion & Backtracking | Subsets, Permutations, N-Queens, Sudoku skeleton (🔧) |
| Sorting | Bubble, Selection, Insertion, Merge, Quick, Counting/Radix (🔧) |
| Searching | Linear, Binary, Search in rotated array |
| Dynamic Programming | Fibonacci (memo & tab), Knapsack (0/1), LIS, Coin Change (🔧) |
| Greedy | Interval scheduling, Activity selection, Huffman idea (🔧) |
| Math / Misc | GCD, Sieve of Eratosthenes, Bit tricks (🔧) |


## 🏗  Directory Structure 
```
Java-with-DSA/
  README.md
  src/
    arrays/
    strings/
    linkedlist/
    stack/
    queue/
    hashing/
    trees/
    heaps/
    tries/
    graphs/
    sorting/
    searching/
    recursion/
    backtracking/
    dp/
    greedy/
    math/
  docs/
    complexity-cheatsheet.md
    patterns.md
  test/ (🔧 if using JUnit)
```


## 🚀 Getting Started

### Prerequisites
- Java 17+ (🔧 confirm version)
- (Optional) Maven or Gradle if you introduce a build system
- An IDE (IntelliJ IDEA / VS Code with Java extensions)

### Clone
```bash
git clone https://github.com/codeShinobi-sarthak/Java-with-DSA.git
cd Java-with-DSA
```

### Compile & Run Single File (No build tool)
```bash
javac src/arrays/TwoPointerExample.java
java -cp src arrays.TwoPointerExample
```

### With Maven (if you add a pom.xml later)
```bash
mvn clean test
```

### With Gradle (if you add build.gradle)
```bash
./gradlew build
```

## 🧪 Testing (optional if you want)
Add JUnit tests under `test/`:
```bash
# Maven style
mvn test
# or Gradle
./gradlew test
```

## 🧠 Patterns Cheat Sheet (Planned)
Create a `docs/patterns.md` with sections:
- Sliding Window
- Two Pointers
- Fast & Slow (Floyd)
- Monotonic Stack
- Prefix Sum / Difference Array
- Bitmask Enumeration
- Memoization vs Tabulation

## 📈 Progress Tracking:
```
[ ] Arrays basics
[ ] Sliding window patterns
[ ] Linked list reversal
[ ] Stack / queue implementations
[ ] BST operations
[ ] Graph traversal set
[ ] Topological sort
[ ] Dynamic programming starter set
[ ] Backtracking core problems
[ ] Heap & priority queue examples
```
Update with ✅ as you go.

## 🗺 Roadmap (Customize)
- ✅ Initialize repository
- 🔧 Add core array & string problems
- 🔧 Introduce JUnit tests
- 🔧 Add complexity cheat sheet
- 🔧 Add graph algorithms set
- 🔧 Add dynamic programming section
- 🔧 Add CLI runner to choose problems
- 🔧 Add benchmarking (JMH) for key algorithms

## 🛡 License
No license declared yet.  
Legally all rights are reserved by default.

## 🤝 Contributing
This is a personal learning repo, contributions are Welcome — open a discussion or issue before large changes.

## 🔐 Security
Not applicable (no runtime service), but if you notice incorrect algorithmic explanation or potential license issues, open an issue.

## 🙌 Inspiration & References 
- CLRS (Introduction to Algorithms)
- "Algorithms" by Sedgewick & Wayne
- LeetCode / HackerRank problem sets
- GeeksForGeeks explanations

## ⭐ Support
If this repository helps your learning journey, consider starring it so you can find it again easily.

---
Made with consistent practice and curiosity by @codeShinobi-sarthak

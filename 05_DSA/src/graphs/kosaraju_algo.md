## 🌪️ **Kosaraju’s Algorithm – Full Breakdown**

---

### 🧠 **Core Idea**:

Kosaraju’s algorithm uses **2 DFS traversals** and a **graph reversal** to uncover SCCs.

---

## 🪜 Step-by-Step Plan:

1. **Do a DFS and push nodes onto a stack** in order of **finishing time**.
2. **Reverse the entire graph** (i.e., reverse all edges).
3. **Pop nodes from the stack** one by one, and for each unvisited node, do a **DFS on the reversed graph** to discover one full SCC.

---

### ⚙️ Why does this work?

The **finishing time** in the first DFS gives you the right order to process the nodes in the reversed graph so that each DFS call after reversal only hits **one SCC**.

---

### 🧩 Components Needed:

* A **visited\[] array**
* A **stack** for storing nodes by finish time
* A **reversed graph**
* Two rounds of **DFS**

---

## ⛓️ Let’s Walk Through Each Step

---

### 🔹 Step 1: Fill Stack Using Finish Time

Run DFS on the original graph and whenever a node finishes, **push it onto a stack**.

This stack now has nodes **in the order of decreasing finish time**.

---

### 🔄 Step 2: Reverse the Graph

Reverse the direction of all edges. So if `u → v` in the original, it becomes `v → u`.

This flips dependencies, making each SCC reachable in isolation.

---

### 🔹 Step 3: DFS on Reversed Graph

Now pop each node from the stack, and **run DFS on the reversed graph** from it if it's unvisited.

Each DFS here gives **one SCC**, because in the reversed world, we’re only able to walk within one SCC.

---

## 💡 Intuition Time:

Imagine SCCs as islands 🌴🌴🌴 connected by bridges. The first DFS orders islands based on how deep their outgoing bridges go. Reversing the graph reverses the flow of bridges — now DFS can safely explore **one island at a time**.

---

## 🧠 Time & Space Complexity:

| Thing | Complexity |
| ----- | ---------- |
| Time  | `O(V + E)` |
| Space | `O(V + E)` |

Because we do **two DFS** traversals and store graphs and stack.

---

## 📌 Summary Cheat Sheet:

| Step                             | Purpose           |
| -------------------------------- | ----------------- |
| DFS + Stack                      | Get finish times  |
| Reverse Graph                    | Flip dependencies |
| DFS on reversed (in stack order) | Discover SCCs     |

---

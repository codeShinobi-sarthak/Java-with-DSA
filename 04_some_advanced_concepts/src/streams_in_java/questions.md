## 🎯 Stream Questions

### ✅ **Challenge 1** – Filter, Sort, and Limit
**Problem:** From a list of integers, get the top 3 even numbers in **descending order**.

**Input:**
```java
List<Integer> nums = List.of(11, 22, 5, 30, 18, 7, 14, 60);
```

🔧 Try to:
1. Filter only even numbers
2. Sort them in descending order
3. Take the first 3

---

### ✅ **Challenge 2** – Word Frequency Counter

**Problem:** Given a paragraph, count how many times each word appears.

**Input:**
```java
String paragraph = "java stream is powerful and java stream is cool";
```

🔧 Steps:
1. Split the string into words
2. Use `Collectors.groupingBy()` and `Collectors.counting()`

---

### ✅ **Challenge 3** – Find Duplicate Elements

**Problem:** Given a list, print only the duplicates.

**Input:**
```java
List<Integer> nums = List.of(1, 2, 3, 4, 2, 3, 5, 6, 1, 7);
```

🔧 Hint:
- Use a `Set` in `filter()` to track seen elements.

---

### ✅ **Challenge 4** – Get Names with Highest Scores

**Input:**
```java
record Player(String name, int score) {}

List<Player> players = List.of(
    new Player("Sarthak", 95),
    new Player("Aryan", 98),
    new Player("Simran", 97),
    new Player("Rahul", 92)
);
```

🔧 Goal: Print the name(s) with the **highest score**.

---

### ✅ **Challenge 5** – FlatMap to Flatten Sentence Words

**Input:**
```java
List<String> sentences = List.of(
    "Java streams are powerful",
    "Practice makes perfect"
);
```

🔧 Goal:
- Split each sentence into words
- Flatten into one list using `flatMap()`

---

## ⚡ Want a Real-World Project?

you can try building a **"Student Analytics Dashboard" CLI app** using streams?

💡 It can:
- Read a CSV file (or hardcoded list)
- Show:
    - 🧮 Average score
    - 🏅 Top 3 students
    - 📊 Subject-wise stats
    - ❗ Students below pass mark
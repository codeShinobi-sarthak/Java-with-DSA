# ☕ Java Streams — The Ultimate Chef's Special 🍲

Java **Streams** were introduced in **Java 8** and are all about **processing data in a functional style**. They allow you to **work with collections elegantly** without writing complex loops and conditionals.

---

## 🧭 Plan to Master Streams in Java

We’ll follow this roadmap:

### ✅ 1. What are Streams?
### ✅ 2. Stream Structure (Source → Intermediate Ops → Terminal Ops)
### ✅ 3. Types of Streams (Stream, IntStream, LongStream, DoubleStream, etc.)
### ✅ 4. Stream Operations:
- Filtering (`filter`)
- Mapping (`map`, `flatMap`)
- Sorting (`sorted`)
- Matching (`anyMatch`, `allMatch`, `noneMatch`)
- Reducing (`reduce`)
- Collecting (`collect`, `Collectors`)
- Counting (`count`)
- Grouping (`groupingBy`)
- Partitioning (`partitioningBy`)

### ✅ 5. Lazy vs Eager Evaluation
### ✅ 6. Parallel Streams
### ✅ 7. Common Interview Questions
### ✅ 8. Practice Examples & Visualizations

---

# Let’s start with the **first course** 🍽️

---

## 🔥 1. What are Streams?

- A **Stream** is a sequence of elements that supports **sequential and parallel** aggregate operations.
- Think of it as a **conveyor belt**:
  - Data (source) is placed at one end.
  - You can filter, modify, or group items as they move along.
  - Finally, you collect the result at the other end.

💡 It does **NOT** store data—it operates **on data**.

---

### Example:

```java
List<String> names = List.of("Sarthak", "Aryan", "Nikita", "Sanya");

names.stream()
     .filter(name -> name.startsWith("S"))
     .map(String::toUpperCase)
     .forEach(System.out::println);
```

**Output**:
```
SARTHAK
SANYA
```

---

## 🧱 2. Structure of a Stream Pipeline

### 🍯 Stream Pipeline = 
🔹 **Source** → 🔹 **Intermediate Operations** → 🔹 **Terminal Operation**

### 🍽️ Let’s break it down:

| Component               | Example                       | Description |
|-------------------------|-------------------------------|-------------|
| Source                  | `list.stream()`               | Where data comes from |
| Intermediate Operation  | `.filter()`, `.map()`         | Transforms data (lazy) |
| Terminal Operation      | `.collect()`, `.forEach()`    | Ends the stream (eager) |

---

### Code Example:

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

List<Integer> evenSquares = numbers.stream()
    .filter(n -> n % 2 == 0)         // Intermediate
    .map(n -> n * n)                 // Intermediate
    .collect(Collectors.toList());  // Terminal
```

---

# Move on to Next  **Types of Streams**?
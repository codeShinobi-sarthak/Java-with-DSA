# 👨‍🍳 Let's cook up an **all-in-one complete platter** of Java Streams, covering:

1. 🧃 Intermediate vs ☕ Terminal Operations
2. 🧠 Lazy vs Eager Evaluation
3. ⚡ Parallel Streams
4. 🔄 Stream Lifecycle (How it all flows)
5. 🛠️ Best Practices & Notes

---

# 🧃 Intermediate vs ☕ Terminal Operations

| Type           | What They Do                              | Examples                                | Runs Immediately? |
|----------------|-------------------------------------------|-----------------------------------------|-------------------|
| 🧃 Intermediate | Transforms or filters the data            | `map()`, `filter()`, `sorted()`, `distinct()` | ❌ No (lazy)       |
| ☕ Terminal     | Produces a result or side-effect          | `collect()`, `forEach()`, `reduce()`     | ✅ Yes (executes)  |

💡 Intermediate operations **build the pipeline**, Terminal **executes** it.

---

# 🧠 Lazy vs Eager Evaluation

Streams are **lazy**. They won't do anything until a terminal operation **demands** results.

### 👇 Code:
```java
List<String> names = List.of("Sarthak", "Aryan", "Nikita");

Stream<String> stream = names.stream()
    .filter(name -> {
        System.out.println("Filtering: " + name);
        return name.startsWith("S");
    });
```

🔸 Nothing is printed until this:
```java
stream.forEach(System.out::println);
```

🔸 Output:
```
Filtering: Sarthak
Sarthak
Filtering: Aryan
Filtering: Nikita
```

✅ Lazy allows Java to **short-circuit**: If result is found early, no need to scan all.

---

# ⚡ Parallel Streams (Multithreaded Boost)

Wanna go BRRRTT 💨 on big data? Use `.parallelStream()`:

```java
List<Integer> list = IntStream.range(1, 1_000_000).boxed().toList();

list.parallelStream()
    .filter(i -> i % 2 == 0)
    .map(i -> i * 2)
    .forEach(System.out::println);
```

### 🍕 When to use:
✅ Big datasets  
✅ Stateless operations  
✅ CPU-heavy logic  
❌ Don’t use for small data or shared resources

---

# 🔄 Stream Lifecycle – How Stream Flows 🍥

```
           +----------------+       +--------------------+
List --->  | Stream Source  | --->  | Intermediate Ops   | ---> Terminal Op
           +----------------+       +--------------------+
                                     | map, filter, sort |
                                     +--------------------+
```

### 🌊 Example:
```java
List<String> data = List.of("Java", "Stream", "Power");

List<String> result = data.stream()
    .filter(w -> w.length() > 4)
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

---

# 🛠️ Best Practices for Java Streams

✅ **Use method references** when possible:
```java
.map(String::toUpperCase) // Instead of s -> s.toUpperCase()
```

✅ **Use `collect(Collectors.toList())`** for list result.

✅ **Use `.findFirst()`, `.anyMatch()`** for fast early results.

❌ **Don’t mix stream and collection logic** inside a pipeline.

❌ **Avoid stateful operations** (like modifying external variables).

✅ **Chain smartly**, don’t overuse `.peek()` or `.forEach()` if not terminal.

---

### 🎯 Common Pitfalls to Avoid:
- Streams can only be used **once**.
- Avoid `.parallelStream()` with I/O.
- Avoid using **mutable objects** in streams carelessly.

---

📦 Summary Box

| Topic              | Summary |
|--------------------|---------|
| Stream Types       | Object vs Primitive (`IntStream`, etc.) |
| Core Operations    | `map`, `filter`, `collect`, `reduce`, etc. |
| Lazy Evaluation    | Stream doesn’t run until terminal op |
| Parallel Streams   | Boost speed using multiple threads |
| Best Practices     | Pure functions, no side effects, reuse, method refs |

# 🧪 Real-World Java Stream Practice Problems

Each one includes:
- 🧩 **Problem**
- 🛠️ **Stream solution**
- 💡 **Why it's useful**

---

### 🔹 1. Get Even Numbers and Square Them

**Problem**: Given a list of integers, return a list of squares of even numbers.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

List<Integer> result = numbers.stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * n)
    .collect(Collectors.toList());

System.out.println(result); // [4, 16, 36]
```

✅ Used in filtering data + transforming for analytics.

---

### 🔹 2. Find the First Word Starting with "A"

```java
List<String> words = List.of("Banana", "Apple", "Avocado", "Berry");

Optional<String> first = words.stream()
    .filter(w -> w.startsWith("A"))
    .findFirst();

System.out.println(first.orElse("None")); // Apple
```

✅ Useful for **search suggestions**, **search result previews**.

---

### 🔹 3. Count Word Frequencies

```java
List<String> words = List.of("apple", "banana", "apple", "orange", "banana");

Map<String, Long> frequency = words.stream()
    .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

System.out.println(frequency);
// {orange=1, banana=2, apple=2}
```

✅ Applies to **logs**, **hashtags**, **analytics**.

---

### 🔹 4. Group People by Department

```java
record Person(String name, String dept) {}

List<Person> people = List.of(
    new Person("Sarthak", "IT"),
    new Person("Aryan", "HR"),
    new Person("Simran", "IT")
);

Map<String, List<Person>> grouped = people.stream()
    .collect(Collectors.groupingBy(Person::dept));

System.out.println(grouped);
```

✅ Used in **admin dashboards**, **HR tools**, **visual groupings**.

---

### 🔹 5. Create a Comma-Separated String of Names

```java
List<String> names = List.of("Sarthak", "Aryan", "Simran");

String joined = names.stream()
    .collect(Collectors.joining(", "));

System.out.println(joined); // Sarthak, Aryan, Simran
```

✅ Used for **emails**, **UI lists**, **CSV exports**.

---

### 🔹 6. Get Top 3 Highest Scoring Students

```java
record Student(String name, int score) {}

List<Student> students = List.of(
    new Student("A", 90),
    new Student("B", 75),
    new Student("C", 85),
    new Student("D", 95)
);

List<Student> top3 = students.stream()
    .sorted((a, b) -> b.score() - a.score())
    .limit(3)
    .collect(Collectors.toList());

top3.forEach(System.out::println);
```

✅ Applies to **leaderboards**, **rankings**, **statistics**.

---

### 🔹 7. Flatten a List of Lists of Integers

```java
List<List<Integer>> matrix = List.of(
    List.of(1, 2),
    List.of(3, 4),
    List.of(5, 6)
);

List<Integer> flat = matrix.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());

System.out.println(flat); // [1, 2, 3, 4, 5, 6]
```

✅ Used in **2D game boards**, **grid data**, **spreadsheets**.

---

# 🎁 BONUS: Streams with Files

```java
Files.lines(Paths.get("file.txt"))
    .filter(line -> line.contains("Sarthak"))
    .forEach(System.out::println);
```

✅ Used for **log processing**, **config scanning**, **parsing data**.

---

# ✅ Ready to Test Your Skills?
- 🧠 Mini challenges
- 🧪 Debug-my-stream quiz
- 🔨 Project idea using streams
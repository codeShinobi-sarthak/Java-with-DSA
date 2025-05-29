# ⚙️ 4. Core Stream Operations in Java

Streams have **two types** of operations:

| Type           | Examples                         | Executes Immediately? |
|----------------|----------------------------------|------------------------|
| 🧃 Intermediate | `filter()`, `map()`, `sorted()`  | ❌ Lazy (chainable)     |
| ☕ Terminal     | `collect()`, `forEach()`, `reduce()` | ✅ Yes                 |

---

We’ll explore each with **example + output + when to use**.

---

## 1️⃣ `filter(Predicate)` → 🍳 *Selective Cooking*

Filters elements based on a **condition**.

```java
List<String> names = List.of("Sarthak", "Aryan", "Simran");

names.stream()
     .filter(name -> name.startsWith("S"))
     .forEach(System.out::println);
```

🔸 **Output**:
```
Sarthak
Simran
```

---

## 2️⃣ `map(Function)` → 🎨 *Transformation Station*

Converts each element to another form.

```java
List<String> names = List.of("sarthak", "aryan");

names.stream()
     .map(String::toUpperCase)
     .forEach(System.out::println);
```

🔸 **Output**:
```
SARTHAK
ARYAN
```

---

## 3️⃣ `flatMap(Function)` → 📦 *Unpacking Lists within Lists*

Flattens nested structures into a single stream.

```java
List<List<String>> listOfLists = List.of(
    List.of("A", "B"),
    List.of("C", "D")
);

listOfLists.stream()
           .flatMap(List::stream)
           .forEach(System.out::print);
```

🔸 **Output**: `ABCD`

---

## 4️⃣ `sorted()` → 📚 *Natural or Custom Sorting*

```java
List<Integer> nums = List.of(4, 1, 3, 2);

nums.stream()
    .sorted()
    .forEach(System.out::println);
```

🔸 **Output**:
```
1
2
3
4
```

🔸 With custom comparator:
```java
.sorted((a, b) -> b - a) // Descending
```

---

## 5️⃣ `distinct()` → 🎯 *Remove Duplicates*

```java
List<Integer> nums = List.of(1, 2, 2, 3, 3, 4);

nums.stream()
    .distinct()
    .forEach(System.out::println);
```

🔸 **Output**:
```
1
2
3
4
```

---

## 6️⃣ `limit(n)` and `skip(n)` → 🎬 *Paging Data*

```java
IntStream.range(1, 10)
         .limit(5)
         .forEach(System.out::print); // 12345
```

```java
IntStream.range(1, 10)
         .skip(5)
         .forEach(System.out::print); // 6789
```

---

## 7️⃣ `forEach(Consumer)` → 🎯 *Consume & Print*

**Terminal** operation to print or act on each item.

```java
List<String> list = List.of("Hi", "Bye");

list.stream().forEach(System.out::println);
```

---

## 8️⃣ `collect()` + `Collectors` → 🧺 *Gather Results*

```java
List<String> names = List.of("Sam", "Siri", "Alex");

List<String> filtered = names.stream()
    .filter(n -> n.startsWith("S"))
    .collect(Collectors.toList());

System.out.println(filtered);
```

🔸 **Output**:
```
[Sam, Siri]
```

✨ Popular Collectors:
- `toList()`
- `toSet()`
- `joining(", ")`
- `groupingBy()`
- `partitioningBy()`

---

## 9️⃣ `reduce()` → 🧠 *Total Sum, Min, Max, etc.*

```java
List<Integer> nums = List.of(1, 2, 3, 4, 5);

int sum = nums.stream()
              .reduce(0, Integer::sum);

System.out.println(sum); // 15
```

---

## 🔟 `anyMatch()`, `allMatch()`, `noneMatch()` → 🕵️‍♂️ *Condition Checkers*

```java
boolean hasEven = List.of(1, 3, 5).stream().anyMatch(x -> x % 2 == 0);
System.out.println(hasEven); // false
```

---

### 🧠 Pro Tip: Intermediate operations are **lazy**, terminal ones are **eager** (execute the whole pipeline).

---

# Next up:
> 🔥 **Lazy vs Eager Evaluation**  
> 🧵 **Parallel Streams**  
> ❓ **Common Interview Questions**  
> 🧪 **Practice Problems**

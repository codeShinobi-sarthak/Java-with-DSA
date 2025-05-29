
# 🧪 3. Types of Streams in Java

Java provides **two main categories** of streams:

---

## 🌟 1. **Generic Object Streams**
These are the ones you use with any object type, like `Stream<T>`, where `T` can be `String`, `Integer`, `User`, etc.

```java
Stream<String> names = Stream.of("Sarthak", "Aryan", "Nikita");
```

✅ Most commonly used with collections:
```java
List<String> list = List.of("a", "b", "c");
Stream<String> stream = list.stream();
```

---

## 🧮 2. **Primitive Streams**
Java has special stream types for primitive data to avoid boxing overhead:

| Primitive Stream | Description                              | Example                      |
|------------------|------------------------------------------|------------------------------|
| `IntStream`      | Stream of `int` values                   | `IntStream.range(1, 5)`      |
| `LongStream`     | Stream of `long` values                  | `LongStream.of(100L, 200L)`  |
| `DoubleStream`   | Stream of `double` values                | `DoubleStream.of(1.5, 2.5)`  |

### 🔄 Conversion Methods:
You can convert between object and primitive streams:

```java
List<Integer> numbers = List.of(1, 2, 3);

// Object Stream to IntStream
int sum = numbers.stream()
                 .mapToInt(Integer::intValue) // IntStream
                 .sum();
```

---

## 🍩 Key Primitive Stream Methods:

| Stream Type | Useful Methods                          |
|-------------|------------------------------------------|
| `IntStream` | `sum()`, `average()`, `min()`, `max()`   |
| `LongStream`| Same as IntStream                        |
| `DoubleStream`| Plus `summaryStatistics()`             |

---

## 🧠 Summary

| Type             | Class             | Usage Example                         |
|------------------|------------------|---------------------------------------|
| Object Stream    | `Stream<T>`      | `Stream.of("a", "b")`                 |
| Integer Stream   | `IntStream`      | `IntStream.range(1, 10)`              |
| Long Stream      | `LongStream`     | `LongStream.of(100L, 200L)`           |
| Double Stream    | `DoubleStream`   | `DoubleStream.of(1.0, 2.0)`           |

---

# Next to **core Stream operations** like `filter`, `map`, `reduce`, `collect`, etc.? That’s where the real fun begins! 🧪💥
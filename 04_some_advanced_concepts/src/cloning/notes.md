## 🔍 What is Copying in Java?
Copying an object means **creating a new object** with the **same values** as the original one. But there’s a catch — do we copy just the reference to the original object's fields (shallow), or do we also copy all the objects inside it too (deep)?

---

## 🪞 Shallow Copy – "Copying the Surface"

### 🤔 Definition:
A **shallow copy** copies the top-level object but **not the nested objects inside**. Instead, it copies references to those nested objects.

### 🧠 Analogy:
Imagine photocopying a file. The main paper is copied, but if that file refers to other folders, you don’t copy those — just point to the same folder.

### 📦 In Java:

#### Example:

```java
class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy using clone
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```

#### Usage:

```java
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Delhi");
        Person p1 = new Person("Sarthak", address);
        Person p2 = (Person) p1.clone(); // Shallow copy

        p2.address.city = "Mumbai"; // Modifying nested object

        System.out.println(p1.address.city); // 👀 Output: Mumbai (changed!)
    }
}
```

### 🧠 Why? Because both `p1` and `p2` point to the **same Address object**.

---

## 🧬 Deep Copy – "Cloning Everything Deeply"

### 🤔 Definition:
A **deep copy** creates a completely **independent copy**, including all nested objects.

### 🧠 Analogy:
Imagine writing a new file and also copying all linked folders into new folders. Now changes to one file or folder won’t affect the other.

### 📦 In Java:

#### Example:

```java
class Address {
    String city;

    Address(String city) {
        this.city = city;
    }

    // Deep copy of Address
    public Address(Address other) {
        this.city = other.city;
    }
}

class Person {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Deep copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.address = new Address(other.address); // 👈 Deep copy here
    }
}
```

#### Usage:

```java
public class Main {
    public static void main(String[] args) {
        Address address = new Address("Delhi");
        Person p1 = new Person("Sarthak", address);
        Person p2 = new Person(p1); // Deep copy

        p2.address.city = "Mumbai";

        System.out.println(p1.address.city); // ✅ Output: Delhi (not changed)
    }
}
```

---

## 🧪 Key Differences Table:

| Feature              | Shallow Copy 🪞            | Deep Copy 🧬                |
|----------------------|----------------------------|-----------------------------|
| Copies nested objects? | ❌ No, only references      | ✅ Yes, new independent copy |
| Memory usage         | 🔽 Lower                    | 🔼 Higher                   |
| Performance          | 🚀 Faster                   | 🐢 Slower                   |
| Use cases            | When immutability is ensured | When full separation is needed |
| Changes in copy affect original? | ✅ Yes (for nested objects) | ❌ No                       |

---

## 🛠️ How to Create Deep Copies in Java
✅ **Options**:
1. **Manual Copy Constructors** (Best practice)
2. **Serialization** (ObjectOutputStream/InputStream)
3. **Using libraries like Apache Commons Lang** (`SerializationUtils.clone()`)

---

## 📌 When to Use What?

- Use **shallow copy** when:
    - Your object is immutable or you don’t care about inner changes.
    - Performance is critical.

- Use **deep copy** when:
    - You want complete independence between original and copied object.
    - You are working with mutable nested structures.

---

## 🔚 Summary in 1 Line:
> **Shallow Copy** = Copy of references 🪞  
> **Deep Copy** = Copy of actual objects 🧬

---
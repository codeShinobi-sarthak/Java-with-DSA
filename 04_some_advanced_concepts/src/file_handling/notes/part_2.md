### 🔎 Java File Classes Overview

Java provides multiple **classes grouped into two main categories**, based on **what kind of data you're working with**:

---

## 📁 1. **File Class** (From `java.io`)
> 👉 Used to **represent the file or directory**, not to read/write content.

### ✅ Key uses:
- Check if a file exists
- Create new file or folder
- Get file name, path, size, etc.
- Delete files

```java
import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("example.txt");
        
        if (!file.exists()) {
            System.out.println("File does not exist. Creating...");
        } else {
            System.out.println("File already exists.");
            System.out.println("Path: " + file.getAbsolutePath());
        }
    }
}
```

---

## 📝 2. **Character Streams** (For reading/writing text files)

### ➕ Unbuffered:
- `FileReader` – reads characters
- `FileWriter` – writes characters

```java
FileWriter writer = new FileWriter("output.txt");
writer.write("Hello, Sarthak!");
writer.close();
```

### 🚀 Buffered (Faster):
- `BufferedReader` – reads lines of text efficiently
- `BufferedWriter` – writes text with buffer

```java
BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
String line = reader.readLine();
reader.close();
```

---

## 🧊 3. **Byte Streams** (For binary files like images, PDFs)

### ➕ Unbuffered:
- `FileInputStream` – reads bytes
- `FileOutputStream` – writes bytes

```java
FileInputStream input = new FileInputStream("photo.jpg");
FileOutputStream output = new FileOutputStream("copy.jpg");

int byteData;
while ((byteData = input.read()) != -1) {
    output.write(byteData);
}
input.close();
output.close();
```

### 🚀 Buffered (Faster):
- `BufferedInputStream` – buffered byte reading
- `BufferedOutputStream` – buffered byte writing

---

## 🧃 4. **Utility Classes**
These are super helpful in daily coding:

### ✏️ `PrintWriter`
- Easy writing to files (like `System.out` but for files)

```java
PrintWriter pw = new PrintWriter("notes.txt");
pw.println("Java is awesome!");
pw.close();
```

### 🔍 `Scanner`
- Easy reading from files like reading input

```java
Scanner sc = new Scanner(new File("notes.txt"));
while (sc.hasNextLine()) {
    System.out.println(sc.nextLine());
}
sc.close();
```

---

### 🎯 Quick Comparison Table

| Type            | Class               | For          | Buffered? | File Type     |
|------------------|---------------------|--------------|-----------|---------------|
| Metadata         | `File`              | Exists, Info | ❌         | Both          |
| Character Stream | `FileReader`        | Reading      | ❌         | Text Files    |
| Character Stream | `FileWriter`        | Writing      | ❌         | Text Files    |
| Character Stream | `BufferedReader`    | Reading      | ✅         | Text Files    |
| Character Stream | `BufferedWriter`    | Writing      | ✅         | Text Files    |
| Byte Stream      | `FileInputStream`   | Reading      | ❌         | Binary Files  |
| Byte Stream      | `FileOutputStream`  | Writing      | ❌         | Binary Files  |
| Byte Stream      | `BufferedInputStream`| Reading     | ✅         | Binary Files  |
| Byte Stream      | `BufferedOutputStream`| Writing    | ✅         | Binary Files  |
| Utility          | `PrintWriter`       | Writing      | ❌ (fast)  | Text Files    |
| Utility          | `Scanner`           | Reading      | ❌         | Text Files    |

---

# Next **Part 3: Categorization of file handling** 
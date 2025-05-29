## ✍️ PART 4: Core File Operations

We’ll cover each operation with code snippets and clear explanations:

---

### ✅ 1. **Create a New File**

You can create a new file using the `File` class.

```java
import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        File file = new File("file.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("✅ File created: " + file.getName());
            } else {
                System.out.println("⚠️ File already exists.");
            }
        } catch (IOException e) {
            System.out.println("❌ An error occurred.");
            e.printStackTrace();
        }
    }
}
```

---

### 📖 2. **Read From a File**

#### Using `Scanner` (easy way for text):
```java
import java.io.File;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File file = new File("file.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("❌ Error reading file.");
            e.printStackTrace();
        }
    }
}
```

---

### 📝 3. **Write to a File (Overwrite)**

```java
import java.io.FileWriter;

public class WriteFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("file.txt");
            writer.write("Java File Handling is 💯 cool!");
            writer.close();
            System.out.println("✅ Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("❌ Error writing file.");
            e.printStackTrace();
        }
    }
}
```

---

### ➕ 4. **Append to a File**

Just pass `true` to the `FileWriter` constructor to append:

```java
FileWriter writer = new FileWriter("file.txt", true);
writer.write("\nNow adding more content to the file 🔥");
writer.close();
```

---

### ❌ 5. **Delete a File**

```java
File file = new File("file.txt");
if (file.delete()) {
    System.out.println("✅ Deleted file: " + file.getName());
} else {
    System.out.println("⚠️ Failed to delete file.");
}
```

---

## 🧪 Summary of File Operations

| Operation | Method/Class | Notes |
|----------|--------------|-------|
| Create   | `File.createNewFile()` | Creates only if it doesn't exist |
| Read     | `Scanner`, `BufferedReader` | Use `Scanner` for simplicity |
| Write    | `FileWriter` | Overwrites existing file |
| Append   | `FileWriter(true)` | Adds to the end |
| Delete   | `File.delete()` | Removes the file permanently |

---

# 🚀 Up Next for a **Real-Life Mini Project to use everything we’ve learned**?
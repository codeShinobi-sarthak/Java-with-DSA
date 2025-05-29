## 📚 **What is Java NIO (New I/O)?**

Java NIO (introduced in **Java 1.4**) provides a more flexible and efficient way of handling I/O operations compared to the traditional `java.io` package. It's built around **buffers** and **channels**, making it suitable for high-performance I/O tasks.

The main features of NIO include:
- **Non-blocking I/O**: It allows you to perform I/O operations asynchronously.
- **Buffers**: A buffer is an area of memory where data is stored before it’s written to a file or read from it.
- **Channels**: A channel is the medium through which data flows in and out of I/O operations.

---

### ⚡ Key NIO Concepts

1. **Buffer**: A container for data, used to read/write data.
2. **Channel**: A channel facilitates data transfer between buffers and I/O devices (files, sockets, etc.)
3. **Path**: A `Path` represents a file or directory in a file system.

---

## 🛠️ Key Classes in NIO

1. **Path** (from `java.nio.file`):
    - Replaces `File` class (more flexible, especially with newer file systems).
2. **Files** (from `java.nio.file`):
    - Contains utility methods for file operations (e.g., reading, writing).
3. **FileChannel**:
    - Used to read and write data to files (much like streams in traditional I/O but with better performance).

---

### 🎯 **File Operations Using Java NIO**

Let's see how to perform some basic file operations using NIO.

---

### 📖 1. **Reading a File with NIO**

```java
import java.nio.file.*;
import java.io.IOException;

public class ReadFileNIO {
    public static void main(String[] args) {
        Path path = Paths.get("notes.txt"); // Path to your file
        try {
            // Read all bytes from the file into a byte array
            byte[] data = Files.readAllBytes(path);
            System.out.println(new String(data)); // Convert byte array to string and print
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### 📝 2. **Writing to a File with NIO**

```java
import java.nio.file.*;
import java.io.IOException;

public class WriteFileNIO {
    public static void main(String[] args) {
        Path path = Paths.get("notes_nio.txt");
        String content = "Java NIO is faster and more efficient than old I/O.";

        try {
            Files.write(path, content.getBytes()); // Write content to file
            System.out.println("✅ File written successfully with NIO!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### 🔄 3. **Appending to a File with NIO**

To append data, you need to pass an option in `Files.write`:

```java
import java.nio.file.*;
import java.io.IOException;

public class AppendFileNIO {
    public static void main(String[] args) {
        Path path = Paths.get("notes_nio.txt");
        String content = "\nAppended content with NIO!";

        try {
            // Append data to file
            Files.write(path, content.getBytes(), StandardOpenOption.APPEND);
            System.out.println("✅ Appended successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### 🔥 4. **Using FileChannel for Reading/Writing Large Files**

```java
import java.io.*;
import java.nio.channels.*;
import java.nio.*;

public class FileChannelExample {
    public static void main(String[] args) {
        try (FileChannel channel = new FileOutputStream("channel_example.txt").getChannel()) {
            String content = "This is an example of writing using FileChannel in Java NIO!";
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            channel.write(buffer); // Write data into file
            System.out.println("✅ Written using FileChannel.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### 📊 **Comparison with Traditional I/O**

| Feature             | Java I/O (FileWriter/BufferedReader) | Java NIO (FileChannel, Files) |
|---------------------|-------------------------------------|-------------------------------|
| Speed               | Slower for large files             | Much faster (especially with buffers) |
| Complexity          | Simple                             | More advanced (requires understanding of channels and buffers) |
| Flexibility         | Limited (stream-based)             | More flexible (supports non-blocking I/O, memory-mapped files, etc.) |
| Buffering           | Available in `BufferedReader`      | Integral to NIO (buffer-based) |

---

## 🧠 Summary of NIO

- **Non-blocking I/O**: Allows you to perform asynchronous file operations (useful for servers or applications with many I/O tasks).
- **Path and Files classes**: Simplify file handling tasks with better methods and flexibility.
- **Buffer and Channel**: Efficiently read/write data using buffers instead of streams.
- **Ideal Use Case**: When you need faster file operations, especially for large files or performance-critical applications.
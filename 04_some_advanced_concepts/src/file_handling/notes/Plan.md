## 📚 **Study Plan for File Handling in Java**

### 🧱 **Part 1: Basics of File Handling**
- ✅ What is file handling?
- ✅ Why and where it's used in real-world apps
- ✅ File paths (absolute vs relative)

### 🛠️ **Part 2: Java File Classes Overview**
- `File` class (for file properties, not content)
- `FileReader` / `FileWriter` (character streams)
- `BufferedReader` / `BufferedWriter` (performance boost)
- `FileInputStream` / `FileOutputStream` (byte streams)
- `BufferedInputStream` / `BufferedOutputStream` (buffered byte streams)
- `PrintWriter`, `Scanner` (easy writing and reading)

### 🧠 **Part 3: Categorization of File Handling**
We'll explore the **two major types of streams**:
1. **Character-based** (text files)
2. **Byte-based** (binary files like images, PDFs)

Each type has **unbuffered and buffered** variations.

### 🔁 **Part 4: File Handling Operations**
- Create new file
- Write to file
- Append to file
- Read from file
- Delete file

#### 🧑‍💻 **Real Examples**
- Lets build a "NoteSaver App" that uses file handling to save and read notes from files ! 💡

---

## ✅ Let's Start with **Part 1: Basics of File Handling**

#### ❓ What is File Handling?
File handling allows Java programs to **store**, **retrieve**, and **manipulate data in files** on disk (like `.txt`, `.csv`, `.jpg`, etc.)

#### 📍 Where it's used?
- Saving game progress
- Writing logs
- Reading configuration
- Generating reports

#### 🔗 File Paths
- **Absolute Path**: Full path  
  `C:/Users/Sarthak/data.txt`
- **Relative Path**: Relative to your project directory  
  `data.txt`

---

# Next **Part 2: Java File Classes Overview**,
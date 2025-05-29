
## **BigInteger & BigDecimal in Java**

### **1. Why Use Them?**
✔ `BigInteger`: Handles arbitrarily large integers (factorials, cryptography).  
✔ `BigDecimal`: Provides high-precision decimal calculations (financial applications).  
✔ **Slower than primitives** (`int`, `long`, `double`) but **necessary for precision**.

---

### **2. BigInteger Basics**
- **Creation:**
  ```java
  BigInteger num1 = new BigInteger("123456789123456789");
  BigInteger num2 = BigInteger.valueOf(100); // Preferred for small values
  ```
- **Operations:**
  ```java
  num1.add(num2);    // Addition
  num1.subtract(num2); // Subtraction
  num1.multiply(num2); // Multiplication
  num1.divide(num2);   // Division
  num1.mod(num2);      // Modulo
  num1.pow(2);         // Power
  ```
- **Factorial Calculation:**
  ```java
  BigInteger fact = BigInteger.ONE;
  for (int i = 2; i <= n; i++) fact = fact.multiply(BigInteger.valueOf(i));
  ```

---

### **3. BigDecimal Basics**
- **Avoid `new BigDecimal(double)`** (precision issues). Use:
  ```java
  BigDecimal num1 = new BigDecimal("0.1"); 
  BigDecimal num2 = BigDecimal.valueOf(0.1);
  ```
- **Operations:**
  ```java
  num1.add(num2);
  num1.subtract(num2);
  num1.multiply(num2);
  num1.divide(num2, 2, RoundingMode.HALF_UP); // Division with rounding
  ```
- **Set Scale & Rounding:**
  ```java
  num1.setScale(2, RoundingMode.HALF_UP); // Round to 2 decimal places
  ```

---

### **4. Performance & When to Use**
| Scenario | Use |
|----------|-----|
| Large integers (factorials, cryptography) | `BigInteger` |
| Financial calculations (money, tax) | `BigDecimal` |
| Performance-sensitive operations | `int`, `long`, `double` |

---

### **5. Advanced Uses**
- **Modular Exponentiation** (Used in cryptography):
  ```java
  num1.modPow(exponent, mod); // (num1^exponent) % mod
  ```
- **Converting Types:**
  ```java
  num1.intValue();  // Convert BigInteger to int
  num1.toString();  // Convert to String
  num2.doubleValue(); // Convert BigDecimal to double
  ```

---

### **Final Takeaways**
✔ **Use `BigInteger` for huge numbers, `BigDecimal` for precision.**  
✔ **Always use `setScale()` for rounding in `BigDecimal`.**  
✔ **Avoid `new BigDecimal(double)`, use `String` or `BigDecimal.valueOf()`.**  
✔ **Use primitive types if performance matters more than precision.**

🚀 **Summary:** If precision or large numbers matter → `BigInteger` & `BigDecimal`. If performance is key → `int`, `long`, `double`.
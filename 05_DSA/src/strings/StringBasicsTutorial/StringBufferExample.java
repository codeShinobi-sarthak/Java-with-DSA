package strings.StringBasicsTutorial;

// StringBuffer in Java

import java.util.Arrays;

/**
 * StringBuffer is a mutable sequence of characters. It is similar to String but allows modifications.
 * It provides an efficient way to manipulate character sequences without creating multiple objects.
 * <p>
 * Why use StringBuffer?
 * - Unlike String, which is immutable, StringBuffer can be modified without creating a new object.
 * - It is useful when performing multiple string manipulations (e.g., appending, inserting, deleting).
 * - Provides better performance in scenarios where frequent modifications are needed.
 * <p>
 * StringBuffer vs String:
 * - String is immutable, meaning any modification creates a new object, increasing memory usage.
 * - StringBuffer is mutable, meaning modifications happen on the same object, reducing memory consumption.
 * <p>
 * StringBuffer vs String Pool:
 * - String Pool optimizes memory by storing string literals, but strings remain immutable.
 * - StringBuffer is better when frequent changes are needed as it avoids multiple object creation.
 * - If a string needs to be used multiple times without modifications, String Pool is better for memory efficiency.
 * <p>
 * Key Methods:
 * - append(): Adds text at the end.
 * - insert(): Inserts text at a specific position.
 * - replace(): Replaces text in a specified range.
 * - delete(): Removes characters from a range.
 * - reverse(): Reverses the string buffer.
 * - toString(): Converts StringBuffer to a regular String.
 */


public class StringBufferExample {
    public static void main(String[] args) {
        // Creating a StringBuffer
        StringBuffer sb = new StringBuffer("Hello");

        System.out.println("Initially sb : " + sb);

        // Appending text to the buffer
        sb.append(" World"); // Now sb = "Hello World"
        System.out.println("After append: " + sb);

        // Inserting text at a specific position
        sb.insert(5, " Java"); // Inserts " Java" at index 5
        System.out.println("After insert: " + sb);

        // Replacing text in a specific range
        sb.replace(6, 10, "Python"); // Replaces "Java" with "Python"
        System.out.println("After replace: " + sb);

        // Deleting a portion of text
        sb.delete(6, 12); // Removes "Python"
        System.out.println("After delete: " + sb);

        // Reversing the string buffer
        sb.reverse(); // Reverses the entire buffer
        System.out.println("After reverse: " + sb);

        // Converting StringBuffer to String
        String result = sb.toString();
        System.out.println("Converted to String: " + result);


//        get a random string of length any size
        RandomString rs = new RandomString();
        System.out.println( "Random size generated string: "  +  rs.generate(20));


//       split a sentence
        StringBuffer sb2 = new StringBuffer();
        sb2.append("This is a sentence lets split it");
        String str = sb2.toString();
        String[] splitedSentence = str.split(" ");
        System.out.println(Arrays.toString(splitedSentence));


    }

}

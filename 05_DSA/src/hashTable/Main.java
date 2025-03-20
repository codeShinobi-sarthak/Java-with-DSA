public class Main {
    public static void main(String[] args) {
        HashTables<Integer, String> hashTable = new HashTables<>(10);

        hashTable.put(34, "css");
        hashTable.put(24, "tailwind");
        hashTable.put(4, "mongodb");
        hashTable.put(38, "java");
        hashTable.put(21, "c++");
        hashTable.put(9, "c");
        hashTable.put(67, "javascript");
        hashTable.put(45, "react");
        hashTable.put(57, "html");


        hashTable.display();
        System.out.println(hashTable.get(38));
        System.out.println(hashTable.toString());
    }
}
import java.util.LinkedList;

public class HashTables<K, V> {
    private int capacity; // Number of buckets
    private float loadFactor = 0.7f;
    private LinkedList<HashNode<K, V>>[] table;
    private int size; // Number of nodes

    @SuppressWarnings("unchecked")
    public HashTables(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    class HashNode<K, V> {
        K key;
        V value;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hashFunction(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int i = hashFunction(key);
        int index = search(key, i);
        if (index == -1) {
            HashNode<K, V> node = new HashNode<>(key, value);
            table[i].add(node);
            size++;
        } else {
            HashNode<K, V> data = table[i].get(index);
            data.value = value;
        }
        if ((float) size / capacity > loadFactor) {
            rehash();
        }
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<HashNode<K, V>>[] oldTable = table;
        capacity *= 2;

        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }

        size = 0;
        for (LinkedList<HashNode<K, V>> bucket : oldTable) {
            for (HashNode<K, V> node : bucket) {
                put(node.key, node.value);
            }
        }
    }

    public V get(K key) {
        if (isEmpty()) throw new Error("Map is empty");
        int i = hashFunction(key);
        for (HashNode<K, V> node : table[i]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        if (isEmpty()) throw new Error("Map is empty");
        int i = hashFunction(key);
        for (HashNode<K, V> node : table[i]) {
            if (node.key.equals(key)) {
                table[i].remove(node);
                size--;
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    private int search(K key, int i) {
        LinkedList<HashNode<K, V>> bucket = table[i];
        for (int index = 0; index < bucket.size(); index++) {
            if (bucket.get(index).key.equals(key)) {
                return index;
            }
        }
        return -1;
    }

    public void display() {
        int i = 0;
        System.out.println("Hash table");
        for (LinkedList<HashNode<K, V>> bucket : table) {
            System.out.print("Bucket : " + i++ + " -> ");
            for (HashNode<K, V> node : bucket) {
                System.out.print("[" + node.key + ", " + node.value + "] -> ");
            }
            System.out.print("null \n");
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (LinkedList<HashNode<K, V>> bucket : table) {
            for (HashNode<K, V> node : bucket) {
                builder.append(node.key);
                builder.append(" = ");
                builder.append(node.value);
                builder.append(" , ");
            }
        }
        builder.append("}");

        return builder.toString();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
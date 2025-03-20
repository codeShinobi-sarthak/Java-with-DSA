public class MyHashSet {

    private HashNode[] set;
    private int capacity = 500;

    class HashNode {
        int key;
        HashNode next;

        public HashNode(int key, HashNode next) {
            this.key = key;
            this.next = next;
        }
    }

    public MyHashSet() {
        this.set = new HashNode[capacity];
    }

    private int hashFunction(int key) {
        return key % capacity;
    }

    public void add(int key) {
        int i = hashFunction(key);
        if (set[i] == null) {
            set[i] = new HashNode(key, null);
        } else {
            HashNode temp = set[i];
            if (temp.key == key)
                return;
            while (temp.next != null) {
                if (temp.key == key || temp.next.key == key)
                    return;
                temp = temp.next;
            }
            temp.next = new HashNode(key, null);
        }
    }

    public void remove(int key) {
        int i = hashFunction(key);
        if (set[i] != null) {
            HashNode temp = set[i];
            if (temp.key == key) {
                set[i] = temp.next;
                return;
            }
            while (temp.next != null) {
                if (temp.next.key == key) {
                    temp.next = temp.next.next;
                    return;
                }
                temp = temp.next;
            }
        }
    }

    public boolean contains(int key) {
        int i = hashFunction(key);
        if (set[i] != null) {
            HashNode temp = set[i];
            while (temp != null) {
                if (temp.key == key) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }
}


//! Product of the Last K Numbers
//Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.

//Implement the ProductOfNumbers class:
/*
  - ProductOfNumbers() Initializes the object with an empty stream.
  - void add(int num) Appends the integer num to the stream.
  - int getProduct(int k) Returns the product of the last k numbers in the current list.
     (You can assume that always the current list has at least k numbers)
 */

//The test cases are generated so that, at any time,
// the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.


import java.util.ArrayList;

public class ProductOfNumbers {
    ArrayList<Integer> list = new ArrayList<>();
    int size = 0;

    public ProductOfNumbers() {
        this.list.add(1);
        this.size = 0;
    }

    public void add(int num) {
        if (num == 0) {
            this.list.clear();
            this.list.add(1);
            this.size = 0;
        }else{
            this.list.add(num * this.list.get(size));
            this.size++;
        }
    }

    public int getProduct(int k) {
        if (k > this.size) {
            return 0;
        }

        return this.list.get(this.size)/ this.list.get(size-k);
    }
}

package stack;

import stack.*;

public class DynamicStack extends ArrayStack {
    public DynamicStack() {
        super(); //! it will call the MyStack()
    }

    public DynamicStack(int size) {
        super(size);
    }


    public void push(int item) throws StackException {
        // this takes care of it being full
        if (this.isFull()) {
            // double the array size
            int[] temp = new int[data.length * 2];

            // copy all previous items in new data
            System.arraycopy(data, 0, temp, 0, data.length);

            data = temp;
        }

        // at this point we know that array is not full
        // insert item
         super.push(item);
    }

    @Override
    void print() {
        super.print();
    }
}

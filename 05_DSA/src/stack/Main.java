public class Main {
    public static void main(String[] args) throws Exception {
// *        stack using array
//        ArrayStack stack = new ArrayStack();
//
//        stack.push(5);
//        stack.push(6);
//        stack.push(12);
//        stack.push(7);
//        stack.push(19);
//
//        System.out.println(stack);

//        * stack using linked list
        LLStack stack = new LLStack();

        stack.push(5);
        stack.push(6);
        stack.push(12);
        stack.push(7);
        stack.push(19);

        stack.print();
    }
}
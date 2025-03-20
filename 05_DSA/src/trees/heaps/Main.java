package heaps;

public class Main {
    public static void main(String[] args) {
        Heaps<Integer> heaps = new Heaps<>();
        heaps.add(9);
        heaps.add(5);
        heaps.add(8);
        heaps.add(11);
        heaps.add(4);

        System.out.println(heaps.isEmpty());
        System.out.println(heaps.removeMax());
        System.out.println(heaps.removeMax());

    }
}

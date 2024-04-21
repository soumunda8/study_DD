package HeapNTree;

import java.util.ArrayList;

public class TrickleUp<E extends Comparable<E>> {

    private int lastPosition = -1;
    ArrayList<E> array = new ArrayList<>();

    public void add(E obj) {
        array.add(obj);
        lastPosition++;
        trickleUp(lastPosition);
    }

    private void swap(int from, int to) {
        E tmp = array.get(from);
        array.set(from, array.get(to));
        array.set(to, tmp);
    }

    private void trickleUp(int position) {
        if (position == 0) return;
        int parent = (position - 1) / 2;
        if (array.get(position).compareTo(array.get(parent)) > 0) {
            swap(position, parent);
            trickleUp(parent);
        }
    }

    public static void main(String[] args) {
        TrickleUp<Integer> heap = new TrickleUp<>();
        heap.add(10);
        heap.add(15);
        heap.add(20);
        heap.add(17);
        heap.add(25);

        System.out.println("Heap elements after adding and trickling up:");
        for (Integer num : heap.array) {
            System.out.print(num + " ");
        }
    }

}
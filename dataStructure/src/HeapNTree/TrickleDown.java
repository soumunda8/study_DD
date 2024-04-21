package HeapNTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TrickleDown<E extends Comparable<E>> {
    private int lastPosition = -1;

    ArrayList<E> array = new ArrayList<>();

    public void add(E obj) {
        array.add(obj);
        lastPosition++;
        trickleUp(lastPosition);
    }

    public E remove() {
        if (lastPosition < 0) return null;

        E tmp = array.get(0);
        array.set(0, array.get(lastPosition));
        array.remove(lastPosition); // 마지막 요소 제거
        lastPosition--;
        trickleDown(0);
        return tmp;
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

    private void trickleDown(int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        int largest = parent;

        if (left <= lastPosition && array.get(left).compareTo(array.get(largest)) > 0) {
            largest = left;
        }

        if (right <= lastPosition && array.get(right).compareTo(array.get(largest)) > 0) {
            largest = right;
        }

        if (largest != parent) {
            swap(parent, largest);
            trickleDown(largest);
        }

    }

    public static void main(String[] args) {
        TrickleDown<Integer> heap = new TrickleDown<>();
        heap.add(10);
        heap.add(20);
        heap.add(15);
        heap.add(30);
        heap.add(40);

        System.out.println("Removed element: " + heap.remove());
        for (Integer num : heap.array) {
            System.out.print(num + " ");
        }
    }
}
package problem4;

import java.util.*;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;        // total elements
    private static final int OPERATIONS = 10_000;   // random operations to test

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();


        System.out.println("---- Performance Comparison ----");

        System.out.println("---- Populate both lists ----");
        for (int i = 0; i < SIZE; i++) {
            //code here
            //code here
            arrayList.add(i);
            linkedList.add(i);
        }

        // 2️⃣ Random insertions and deletions
        testRandomInsertDelete(arrayList, "ArrayList");
        testRandomInsertDelete(linkedList, "LinkedList");

        /*
        ArrayList is faster than LinkedList. ArrayList accesses by index in O(1), then shifts elements (O(n)),
        while LinkedList must traverse nodes sequentially to reach a random position (O(n) just to reach it),
        making random insertions/deletions much slower.
        */


        // 3️⃣ Sequential insertions/deletions at beginning and end
        testSequentialInsertDelete(arrayList, "ArrayList");
        testSequentialInsertDelete(linkedList, "LinkedList");
/*
        LinkedList is very fast (O(1)) because it just changes the head pointer.
        ArrayList is slower (O(n)) because all elements must be shifted to make room or fill the gap.

*/

        // 4️⃣ Random access test
        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");
        /*
        ArrayList is faster because get(index) is O(1) due to contiguous storage.
        LinkedList is slower for random access since get(index) is O(n) which requires traversal.
         */
    }

    // ------------------------------------------------------------

    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        for (int i = 0; i < OPERATIONS; i++) {
            int value = random.nextInt();
            int pos = list.isEmpty() ? 0 : random.nextInt(list.size());
            list.add(pos, value);
        }

        for (int i = 0; i < OPERATIONS && !list.isEmpty(); i++) {
            int pos = random.nextInt(list.size());
            list.remove(pos);
        }
        // insert your code here

        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();

        // Insertions at beginning and end
        for (int i = 0; i < OPERATIONS; i++) {
            list.add(0, -i);
            list.add(list.size(), SIZE+1);
        }
        // add your code here

        // Deletions at beginning and end
        for (int i = 0; i < OPERATIONS && list.size() > 1; i++) {
            list.remove(0);
            list.remove(list.size()-1);
        }
        // add your code here

        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        long sum = 0;
        boolean[] visited = new boolean[list.size()];
        int remaining = list.size();
        // sum of the all elements in the list
        // insert your code here
        while (remaining > 0) {
            int index = random.nextInt(list.size());
            if (!visited[index]) {
                sum += list.get(index);
                visited[index] = true;
                remaining--;
            }
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }
}


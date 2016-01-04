package javase06.t01;

import java.util.*;

public class Task {
    public static void main(String[] args) {

        // collections testing

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Vector<Integer> vector = new Vector<>();
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        Integer val = 5;
        Integer key = 4;

        arrayList.add(val);
        arrayList.add(val);

        linkedList.add(val);
        linkedList.add(val);

        stack.add(val);
        stack.add(val);

        vector.add(val);
        vector.add(val);

        hashSet.add(val);
        hashSet.add(val);

        linkedHashSet.add(val);
        linkedHashSet.add(val);

        hashMap.put(key, val);
        linkedHashMap.put(key, val);
        treeMap.put(key, val);
        treeSet.add(val);
        treeSet.add(val);

        System.out.println(arrayList);
        System.out.println(linkedList);
        System.out.println(stack);
        System.out.println(vector);
        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);

        System.out.println(hashMap);
        System.out.println(linkedHashMap);
        System.out.println(treeMap);

//        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
//        arrayDeque.add(val);
//        arrayDeque.add(val);
//        System.out.println(arrayDeque);

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.add(val);
//        priorityQueue.add(val);
//        System.out.println(priorityQueue);

        val = 5;
        ArrayDeque<Integer> priorityQueue = new ArrayDeque<>();
        priorityQueue.add(val);
        priorityQueue.add(val);
        System.out.println(priorityQueue);



    }
}

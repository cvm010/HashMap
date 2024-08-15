import java.util.LinkedList;
import  java.util.*;

class HashNode {
    int key;
    String val;

    public HashNode(int key, String val) {
        this.key = key;
        this.val = val;
    }
}

public class Main {
    public LinkedList<HashNode>[] list;
    public int size;

    // Initializing the array of LinkedLists
    public void fun(LinkedList<HashNode>[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Generate hash code
    public int formHashCode(int key) {
        int hc = key;
        return Math.abs(hc) % list.length;
    }

    // Find LinkedList index for a specific key
    public int findIndex(List<HashNode>[] list, int key, int arrInd) {
        for (int i = 0; i < list[arrInd].size(); i++) {
            if (list[arrInd].get(i).key == key) {
                return i;
            }
        }
        return -1;
    }

    // Put method to add or update key-value pair
    public void put(LinkedList<HashNode>[] list, int key, String val) {
        int arrInd = formHashCode(key);
        int found = findIndex(list, key, arrInd);
        if (found == -1) {
            list[arrInd].add(new HashNode(key, val));
            size++;
        } else {
            list[arrInd].get(found).val = val;
        }
    }

    // Get method to retrieve the value for a given key
    public String get(LinkedList<HashNode>[] list, int key) {
        int hc = formHashCode(key);
        int found = findIndex(list, key, hc);
        if (found == -1) {
            return "Not found";
        } else {
            return list[hc].get(found).val;
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();

        // Initialize list
        obj.list = new LinkedList[4];
        obj.fun(obj.list);

        obj.put(obj.list, 1, " one ");
        obj.put(obj.list, 2, "two");
        obj.put(obj.list, 3, "three");
        obj.put(obj.list, 4, "four");

        System.out.println(obj.get(obj.list, 1));  // Output: 1
        System.out.println(obj.get(obj.list, 3));  // Output: 3
        System.out.println(obj.get(obj.list, 5));  // Output: -1 (key not found)
    }
}

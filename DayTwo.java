import java.util.HashMap;
class LRUCache{
    HashMap<Integer,Node> itemReference = new HashMap<>();
    int capacity , currentSize, item;
    LRUCache(int capacity) {
        this.capacity = capacity;
    } 
    class Node {
        int data;
        Node previous;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }
    Node head;
    Node tail; 
    void cacheLookup(int item) {
        this.item = item;
        if(itemReference.get(item)==null) {
           cacheMiss();
        }
        else {
           cacheHit();
        }
    }
    void cacheHit() {
        Node nodeHit = itemReference.get(item);
        if(nodeHit.next == null) {
            nodeHit.previous.next = null;
            nodeHit.previous = null;
            tail = nodeHit;
            pushItem();
        }
        else if(nodeHit.previous == null){
            head = nodeHit;
        } 
        else {
            nodeHit.previous.next = nodeHit.next;
            nodeHit.next.previous = nodeHit.previous;
            pushItem();
        }
        itemReference.put(item,head);
    }
    void cacheMiss() {
        if(currentSize<capacity) {
            pushItem();
            currentSize++;
            itemReference.put(item,head);
        }
        else {
           removeLeastRecentlyUsed();
           pushItem();
           itemReference.put(item,head);
        }
    }
    void removeLeastRecentlyUsed() {
        tail = tail.previous;
        tail.next = null;
    }
    void pushItem() {
        Node node = new Node(item);
        node.next = head;
        node.previous = null;
        if(head!=null)
            head.previous = node;
        else
            tail = node;
        head = node;       
    }
    void displayCache() {
        Node n = head;
        while(n!=null){
            System.out.println(n.data);
            n = n.next;
        }
    }
}
public class DayTwo {
    public static void main(String args[]) {
    LRUCache lru = new LRUCache(4);
        lru.cacheLookup(23);
        lru.cacheLookup(5);
        lru.cacheLookup(6);
        lru.displayCache(); 
    } 
}

import org.w3c.dom.Node;

public class Sweeft_6_MyHashSet {

    private final int NUM_OF_BUCKETS = 10;
    private int numOfBuckets;
    private int curSize;

    Node[] data;

    public Sweeft_6_MyHashSet() {
        numOfBuckets = NUM_OF_BUCKETS;
        data = new Node[numOfBuckets];
        curSize = 0;

    }

    public void add(int key){
        Node node = findNode(key);
        if(node != null) return;
        node = new Node(key);
        int index = key % numOfBuckets;
        node.next = data[index];
        data[index] = node;
        curSize++;
        rehash();


    }

    private Node findNode(int key) {
        Node node = data[key % numOfBuckets];
        while(node != null) {
            if(node.key == key){
                return node;
            }
            node = node.next;
    }
        return null;
    }

    private void rehash() {
        if((double) size() / numOfBuckets <= 1) return;
        Node[] tmp = data;
        int newNumOfBuckets = numOfBuckets * 2;
        data = new Node[newNumOfBuckets];
        for(int i=0;i < numOfBuckets;i++){
            Node first = tmp[i];
            while(first != null){
                Node temp = first;
                first = first.next;
                int index = temp.key % newNumOfBuckets;
                temp.next = data[index];
                data[index] = temp;
            }
        }
        numOfBuckets = newNumOfBuckets;

    }
        // This method will work at amortised O(1) in case of good hash function.
    public void remove(int key){
        Node prev = null;
        Node cur = data[key % numOfBuckets];
        while(cur != null){
            if(cur.key == key){
                if(prev == null) data[key % numOfBuckets] = cur.next;
                else prev.next = cur.next;
                curSize--;
                return;

            }
            prev = cur;
            cur = cur.next;
        }

    }

    public boolean contains(int key){
        return findNode(key) != null;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return curSize;
    }


    public class Node{
         int key;
         Node previous;
         Node next;

        public Node(int key) {
            this.key = key;

        }
    }

}

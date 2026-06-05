class Deque {
    class Node {
        int val;
        Node next;
        Node prev;
    }
    Node head;
    Node tail;

    public Deque() {
        head = null;
        tail = head;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void append(int value) {
        if (tail == null) {
            tail = new Node();
            tail.val = value;
            tail.next = null;
            tail.prev = null;
            head = tail;
        } else {
            Node newNode = new Node();
            newNode.val = value;
            newNode.prev = tail;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void appendleft(int value) {
        if (head == null) {
            head = new Node();
            head.val = value;
            head.next = null;
            head.prev = null;
            tail = head;
        } else {
            Node newNode = new Node();
            newNode.val = value;
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        }
    }

    public int pop() {
        if (tail == null)
            return -1;
        int val = tail.val;
        if (tail.prev == null) {
            head = null;
            tail = null;
            return val;
        }
        tail = tail.prev;
        tail.next = null;
        return val;
    }

    public int popleft() {
        if (head == null) {
            return -1;
        }
        int val = head.val;

        if (head.next == null) {
            tail = null;
            head = null;
            return val;
        }
        head = head.next;
        head.prev = null;
        return val;
    }
}

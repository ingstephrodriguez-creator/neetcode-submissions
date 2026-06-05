class LinkedList {
    class Node {
        int val;
        Node next;
    }
    Node head;
    Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = head;
    }

    public int get(int index) {
        if (head == null || index < 0) {
            return -1;

        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            if (i == index) {
                return cur.val;
            }
            cur = cur.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        if (head != null) {
            Node newNode = new Node();
            newNode.val = val;
            newNode.next = head;
           head = newNode;
        } else {
            head = new Node();
            head.val = val;
            head.next = null;
            tail = head;
        }
    }

    public void insertTail(int val) {
        if (tail != null) {
            Node newNode = new Node();
            newNode.val = val;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        } else {
            tail = new Node();
            tail.val = val;
            tail.next = null;
            head = tail;
        }
    }

    public boolean remove(int index) {
        if (head == null || index < 0) {
            return false;
        }
        if (index == 0) {
            if (head == tail) {
                tail = null;
            }
            head = head.next;
            return true;
        }
        Node cur = head;
        int i = 0;
        while (cur.next != null) {
            if (i == index - 1) {
                if (cur.next == tail) {
                    tail = cur;
                }
                cur.next = cur.next.next;
                return true;
            }
            cur = cur.next;
            i++;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<Integer>();
        if (head == null) {
            return values;
        }
        Node cur = head;
        int i = 0;
        do {
            values.add(cur.val);
            cur = cur.next;
            i++;
        } while (cur != null);
        return values;
    }
}

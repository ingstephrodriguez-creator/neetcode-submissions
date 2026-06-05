class MyLinkedList {
    class Node {
        int val;
        Node prev;
        Node next;
    }
    Node head;
    Node tail;
    int size = 0;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            if (count == index) {
                return cur.val;
            }
            cur = cur.next;
            count++;
        }
        return -1;
    }
    private Node getNode(int index) {
        Node cur = head;
        int count = 0;
        while (cur != null) {
            if (count == index) {
                return cur;
            }
            cur = cur.next;
            count++;
        }
        return null;
    }

    public void addAtHead(int val) {
        Node newHead = new Node();
        newHead.val = val;
        if (head == null) {
            head = newHead;
            tail = newHead;

        } else {
            newHead.next = head;
            newHead.prev = null;
            head.prev = newHead;
            head = newHead;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node newTail = new Node();
        newTail.val = val;
        if (tail == null) {
            head = newTail;
            tail = newTail;

        } else {
            newTail.next = null;
            newTail.prev = tail;
            tail.next = newTail;
            tail = newTail;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index < size) {
            Node node = this.getNode(index);
            Node newNode = new Node();
            newNode.val = val;
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        Node nodeToDelete = this.getNode(index);
        if (nodeToDelete == null) return;

        if (nodeToDelete.prev == null && nodeToDelete.next == null) {
            head = null;
            tail = null;
        } else if (nodeToDelete.prev == null) {
            nodeToDelete.next.prev = null;
            head = nodeToDelete.next;
        } else if (nodeToDelete.next == null) {
            nodeToDelete.prev.next = null;
            tail = nodeToDelete.prev;
        } else {
            nodeToDelete.next.prev = nodeToDelete.prev;
            nodeToDelete.prev.next = nodeToDelete.next;
        }
        size--;
    }
}
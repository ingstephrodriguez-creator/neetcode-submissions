class MyStack {
    class Node {
        int val;
        Node next;
        Node prev;
    }

    Node tail;

    public MyStack() {
        tail = null;
    }
    
    public void push(int x) {
        if(tail == null){
            tail = new Node();
            tail.val = x;
            tail.next = null;
            tail.prev = null;
        } else {
            Node newTail = new Node();
            newTail.val = x;
            newTail.next = null;
            newTail.prev = tail;
            tail.next = newTail;
            tail = newTail;
        }
    }
    
    public int pop() {
        int val = tail.val;
        tail = tail.prev;
        if(tail != null){
            tail.next = null;
        }
        return val;
    }
    
    public int top() {
        return tail.val;
    }
    
    public boolean empty() {
        return tail == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class MinStack {
    int[] stack;
    int[] minstack;
    int indexTop = -1;
    Integer currentMin = null;

    public MinStack() {
        stack = new int[5];
        minstack = new int[5];
        indexTop = -1;
    }

    public void push(int val) {
        indexTop++;
        if (indexTop == stack.length) {
            this.resize();
        }
        stack[indexTop] = val;
        if (currentMin == null) {
            currentMin = val;
        } else
            currentMin = val < currentMin ? val : currentMin;
        minstack[indexTop] = currentMin;
    }

    public void pop() {
        indexTop--;
        if (indexTop < 0) {
            currentMin = null;
        } else {
            currentMin = minstack[indexTop];
        }
    }

    public int top() {
        return stack[indexTop];
    }

    public int getMin() {
        return minstack[indexTop];
    }

    private void resize() {
        stack = Arrays.copyOf(stack, stack.length * 2);
        minstack = Arrays.copyOf(minstack, minstack.length * 2);
    }
}
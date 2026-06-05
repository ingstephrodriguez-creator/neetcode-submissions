class MinStack {
    int[] stack;
    int[] minstack;
    int indexTop = 0;
    Integer currentMin = null;

    public MinStack() {
        stack = new int[5];
        minstack = new int[5];
        indexTop = 0;
    }

    public void push(int val) {
        if (indexTop == stack.length) {
            this.resize();
        }
        stack[indexTop] = val;
        if (currentMin == null) {
            currentMin = val;
        } else
            currentMin = val < currentMin ? val : currentMin;
        minstack[indexTop] = currentMin;
        indexTop++;
    }

    public void pop() {
        indexTop--;
        if (indexTop == 0) {
            currentMin = null;
        } else {
            currentMin = minstack[indexTop - 1];
        }
    }

    public int top() {
        return stack[indexTop - 1];
    }

    public int getMin() {
        return minstack[indexTop - 1];
    }

    private void resize() {
        stack = Arrays.copyOf(stack, stack.length * 2);
        minstack = Arrays.copyOf(minstack, minstack.length * 2);
    }
}
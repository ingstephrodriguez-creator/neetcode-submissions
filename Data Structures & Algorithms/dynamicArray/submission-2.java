class DynamicArray {
    Integer[] dynamic;
    int size;

    public DynamicArray(int capacity) {
        dynamic = new Integer[capacity];
        size = 0;
    }

    public int get(int i) {
        return dynamic[i];
    }

    public void set(int i, int n) {
        dynamic[i] = n;
    }

    public void pushback(int n) {
        if (size >= dynamic.length) {
            this.resize();
        }
        dynamic[size] = n;
        size++;
    }

    public int popback() {
        int element = dynamic[size - 1];
        size--;
        return element;
    }

    private void resize() {
        Integer[] newSize = new Integer[dynamic.length * 2];
        for (int i = 0; i < dynamic.length; i++) {
            newSize[i] = dynamic[i];
        }
        dynamic = newSize;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return dynamic.length;
    }
}

class DynamicArray {
    private Integer[] dynamic;
    private int size = 0;

    public DynamicArray(int capacity) {
        dynamic = new Integer[capacity];
    }

    public int get(int i) {
        return dynamic[i];
    }

    public void set(int i, int n) {
        dynamic[i] = n;
    }

    public void pushback(int n) {
        if (size >= dynamic.length) {
            resize();
        }
        dynamic[size] = n;
        size++;
    }

    public int popback() {
        int element = dynamic[size - 1];
        dynamic[size-1] = null;
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

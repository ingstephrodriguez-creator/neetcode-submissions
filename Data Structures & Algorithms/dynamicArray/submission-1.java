class DynamicArray {
    int[] dynamic;
    int size;

    public DynamicArray(int capacity) {
        dynamic = new int[capacity];
        size = 0;
    }

    public int get(int i) {
        return dynamic[i];
    }

    public void set(int i, int n) {
        dynamic[i] = n;
    }

    public void pushback(int n) {
        if (this.getSize() >= this.getCapacity()) {
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
        int[] newSize = new int[this.getCapacity() * 2];
        for (int i = 0; i < this.getCapacity(); i++) {
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

class Solution {
    public int[] replaceElements(int[] arr) {
        for (int index = 0; index < arr.length - 1; index++) {
            int greatestElement = 0;
            for (int j = index + 1; j < arr.length; j++) {
                greatestElement = (arr[j] > greatestElement) ? arr[j] : greatestElement;
            }
            arr[index] = greatestElement;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}
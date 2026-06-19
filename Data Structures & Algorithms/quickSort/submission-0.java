// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSort(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> quickSort(List<Pair> pairs, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return pairs;
        }

        int pivote = pairs.get(highIndex).key;
        int left = lowIndex;
        for (int i = left; i < highIndex; i++) {
            if (pairs.get(i).key < pivote) {
                Pair temp = pairs.get(left);
                pairs.set(left, pairs.get(i));
                pairs.set(i, temp);
                left++;
            }
        }
        if (left < highIndex) {
            Pair temp = pairs.get(left);
            pairs.set(left, pairs.get(highIndex));
            pairs.set(highIndex, temp);
        }

        quickSort(pairs, lowIndex, left-1);
        quickSort(pairs, left+1, highIndex);

        return pairs;
    }
}

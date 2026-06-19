class Solution {
    public int[][] kClosest(int[][] points, int k) {
        points = sort(points, 0, points.length-1);
        int[][] result = new int [k][2];
      int count = 0;
        for(int i = 0; i<points.length; i++){
            double currentDistance = getDistance(points[i]);
            if(count < k){
                result[count] = points[i];
                count++;
            } else {
                break;
            }
        }
        return result;

    }

    private int[][] sort(int[][] points, int lowIndex, int highIndex) {
        if(lowIndex>=highIndex) {
            return points;
        }

        int left = lowIndex;
        double pivote = getDistance(points[highIndex]);

        for(int i = lowIndex; i<highIndex; i++) {
            if(getDistance(points[i])< pivote) {
                int[] temp = points[left];
                points[left] = points[i];
                points[i]= temp;
                left++;
            }
        }

        if(left < highIndex) {
            int[] temp = points[left];
            points[left] = points[highIndex];
            points[highIndex]= temp;
        }

        points = sort(points, lowIndex, left-1 );
        points = sort(points, left+1, highIndex);
        return points;
    }

    private double getDistance(int[] cordenates) {
        return Math.sqrt(Math.pow(cordenates[0], 2) + Math.pow(cordenates[1],2));
    }
}

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> record = new Stack<Integer>();
        for (String s : operations) {
            if (containsNumbersRegex(s)) {
                record.push(Integer.valueOf(s))
                ;
            } else if (s.equalsIgnoreCase("+")) {
                Integer last = record.pop();
                Integer secondToLast = record.peek();
                record.push(last)
                ;
                record.push(secondToLast + last)
                ;
            } else if (s.equalsIgnoreCase("D")) {
                Integer last = record.peek();
           
                record.push(last * 2)
                ;
            } else if (s.equalsIgnoreCase("C")) {
                record.pop()
                ;
            }
        }
        Integer total = 0;
        while (!record.isEmpty()) {
            Integer value = record.pop();
  
            total += value;
        }
        return total;
    }

    private static boolean containsNumbersRegex(String input) {
        return input.matches(".*\\d.*");
    }
}
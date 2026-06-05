class Solution {
    //0 circular 
    //1 square
    // sandwiches == student
    // if the student wants the sandwich it takes it, other wise it will get in the line again
    // ends when non of the students wants to take the top
    public int countStudents(int[] students, int[] sandwiches) {
       
        ArrayDeque<Integer> sandwichesQ =
            Arrays.stream(sandwiches)
                  .boxed()
                  .collect(Collectors.toCollection(ArrayDeque::new));
        Queue<Integer> studentsQ =
            Arrays.stream(students)
                  .boxed()
                  .collect(Collectors.toCollection(ArrayDeque::new));
    
        
        int studetsLookedAtSandwichAtTop = 0;

 
        while (studentsQ.peek()!= null && studetsLookedAtSandwichAtTop < studentsQ.size()) {
            Integer student = studentsQ.poll();
            if(student.equals(sandwichesQ.peek())){
                sandwichesQ.remove();
                studetsLookedAtSandwichAtTop = 0;
            } else {
                studentsQ.add(student);
                studetsLookedAtSandwichAtTop++;
            }
        }
        return studentsQ.size();
    }
}
class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String s: strs){
            builder.append(s.length());
            builder.append("-");
            builder.append(s);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int elements = 0;
        for(int i = 0; i < str.length(); i++) {
            StringBuilder s = new StringBuilder();
        
            while(str.charAt(i) != "-".charAt(0)){
                s.append(str.charAt(i));
                i++;
                
            }
           
         
        
            elements = Integer.parseInt(s.toString());
            s.setLength(0);
            while(elements>0){
                i++;
               
                s.append(str.charAt(i));
                elements--;
            }
             strs.add(s.toString());
        }
        return strs;
    }
}

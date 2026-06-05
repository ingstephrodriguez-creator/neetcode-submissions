class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<String> validation = new Stack<String>();
        for (int index = 0; index < s.length(); index++) {
            String c = String.valueOf(s.charAt(index));
            if ("(".equals(c) || "[".equals(c) || "{".equals(c)) {
                validation.push(c);
            } else {
                if(validation.isEmpty()) return false;
                switch (c) {
                    case ")":
                        if (!"(".equals(validation.peek())) {
                            return false;
                        }else {
                            validation.pop();
                        }
                        break;
                    case "}":
                        if (!"{".equals(validation.peek())) {
                            return false;
                        } else {
                            validation.pop();
                        }
                        break;
                    case "]":
                        if (!"[".equals(validation.peek())) {
                            return false;
                        } else {
                            validation.pop();
                        }
                        break;
                    default:
                        return false;
                }
            }
        }

        return validation.isEmpty();
    }
}







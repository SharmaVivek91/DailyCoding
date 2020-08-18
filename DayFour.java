import java.util.Stack;

class BalancedParenthesis {
    boolean dpa(String input) {
        char inputChars[] = input.toCharArray();
        Stack<Character> st = new Stack<Character>();
        for(char c: inputChars) {
            if(c=='(' || c=='{' || c=='[') st.push(c);
            else {
                char stackTop = st.peek();
                if(c=='}'&& stackTop == '{' 
                    || c==')'&& stackTop == '(' 
                    || c==']'&& stackTop == '[' ) {
                    st.pop();
                }
                else st.push(c);
            }
        }
        if(st.size() == 0) return true;
        return false;
    }
}
public class DayFour {
   public static void main(String args[]) {
        BalancedParenthesis balancedParenthesis = new BalancedParenthesis();
        System.out.println(balancedParenthesis.dpa("((({)))")); 
   } 
}

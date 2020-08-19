import java.util.Stack;

class SimplePath {
    String canonicalPath(String inputPath) {
        Stack<String> stack = new Stack<String>();
        String pathArr[] = inputPath.split("/");
        for(String str:pathArr) {
            if(str.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            }
            else if(!(str.equals("")||str.equals("."))) stack.push(str); 
        }
        if(stack.isEmpty()) return"/";
        StringBuilder sb = new StringBuilder();
        for(String res:stack) {
         sb.append("/"+res);   
        }
        return sb.toString();
    }
}
public class DayFive {
    public static void main(String args[]) {
        SimplePath sp = new SimplePath();
        System.out.println(sp.canonicalPath("/home/./test//../welcome"));
    }
}

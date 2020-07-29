import java.util.Stack;

public class validParenthis {
    public static void main(String[] args) {
        String s = "*)";
        System.out.println(checkValidString(s));
    }
    static boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        return helper(sum , s, 0, s.length());
    }
    static boolean helper(int sum, String s, int l, int len) {
        if(l==len) return sum==0?true:false;
        if(s.charAt(l)=='(')  return helper(sum+1, s, l+1, len);
        if(s.charAt(l)==')') {
            if(sum==0) return false;
            else return helper(sum-1, s, l+1, len);
        }
        else {
            boolean a = helper(sum+1, s, l+1, len);
            boolean b = helper(sum, s, l+1, len);
            boolean c = sum==0? false: helper(sum-1, s, l+1, len);
            return a||b||c;
        }
    }
}

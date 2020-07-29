import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsPopOrder {
    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {2};
        System.out.println(IsPopOrder(a,b));
    }
    static boolean IsPopOrder(int [] pushA,int [] popA) {
        int p2 = 0;
        Stack<Integer> s= new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        int p1 = 0;
        while(p1<pushA.length) {
            s.push(pushA[p1]);
            if(pushA[p1]==popA[p2]) {
                s.pop();
                p2++;
            }
            p1++;
        }
        while(p2<popA.length) {
            if(s.peek()==popA[p2]) {
                s.pop();
                p2++;
            }
            else break;
        }
        if(p2==popA.length) return true;
        else return false;
    }
}

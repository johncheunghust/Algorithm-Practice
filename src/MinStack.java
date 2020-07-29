import java.util.Stack;
public class MinStack {
    public static void main(String[] args) {
        MyMinStack s = new MyMinStack();
        s.push(152);
        System.out.println(s.pop());
        s.push(163);
        System.out.println(s.min());
    }

}
class MyMinStack {
    Stack<Integer> s;
    Stack<Integer> m;
    public MyMinStack() {
        // do intialization if necessary
        s = new Stack<>();
        m = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        s.push(number);
        if(m.isEmpty()) m.push(number);
        else if(m.peek()>=number) m.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
//        int a = s.peek();
//        int b = m.peek();
        if(s.peek().equals(m.peek())) m.pop();
        return s.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return m.peek();
    }
}
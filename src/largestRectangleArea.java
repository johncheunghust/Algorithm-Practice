import java.util.Stack;

public class largestRectangleArea {
    public  static void main(String[] args) {
        int[] h = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(h));
    }
    static int largestRectangleArea(int[] height) {
        // write your code here
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for(int i=0; i<height.length; i++) {
            if(i==0) {
                s.push(i);
                continue;
            }
            if(height[i]>=height[s.peek()]) {
                s.push(i);
                continue;
            }
            else {
                int len= 0;
                while(s.size()>0&&height[s.peek()]>height[i]) {
                    max = Math.max(height[s.pop()]*(++len), max);
                }
                while(len>=0) {
                    s.push(i);
                    len--;
                }
            }
        }
        int len=0;
        while (s.size()>0) {
            max = Math.max(height[s.pop()]*(++len), max);
        }

        return max;
    }
}

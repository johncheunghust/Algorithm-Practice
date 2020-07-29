public class sqrt {
    static public void main(String[] args) {
        System.out.println(sqrt(100000000));
    }
    static int sqrt(int x) {
        // write your code here
        if(x<0) return -1;
        return bsfind(x,0,x);
    }
    static int bsfind(int x,int l, int r) {
        if(l<r) {
            long  m = (l+r)/2;
            if(m*m<=x) {
                if((m+1)*(m+1)>x) return (int)m;
                return bsfind(x, (int)(m+1),r);
            }
            else return bsfind(x,0,(int)m-1);
        }
        return l;
    }
}

import java.util.ArrayList;
import java.util.List;

public class convert {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 2));
    }
    static String convert(String s, int numRows) {
        List<List<Character>> l = new ArrayList<>();
        if(numRows==1) return s;
        for(int i=0;i<numRows;++i) {
            l.add(new ArrayList<>());
        }
        int zz=0;
        int count = 0;
        int a = 1;
        for(int i=0;i<s.length();++i) {
            if(count==numRows-1) a=-1;
            if(count==0) a=1;
            l.get(zz).add(s.charAt(i));
            zz+=a;
            count+=a;
        }
        String ret = new String();
        for(int i=0;i<l.size();++i) {
            for(int j=0;j<l.get(i).size();++j) {
                ret+= String.valueOf(l.get(i).get(j));
            }
        }
        return ret;
    }
}

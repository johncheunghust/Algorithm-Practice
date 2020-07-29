import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class SetPractice {

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        l1.add("caonima");
        l1.add(null);
        System.out.println(l1.size());
        List<String> list = List.of("fuck", "shit", "bitch");
        for(Iterator<String> it = list.iterator(); it.hasNext();) {
            String s = it.next();
            System.out.println(s);
        }
        String[] a = list.toArray(new String[list.size()]);
        for(String i: a) {
            System.out.println(i);
        }
    }


}

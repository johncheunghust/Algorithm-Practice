import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class validanagram {
    public static void main(String[] args) {
        String s = "fucu";
        String t = "fcuu";
        System.out.println(anagram(s,t));
    }



    static boolean anagram(String s, String t) {
        // write your code here
        if(s==null&&t==null) return true;
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        CharacterIterator it = new StringCharacterIterator(s);
        while(it.current()!=CharacterIterator.DONE) {
            if(charMap.containsKey(it.current())) {
                int i = charMap.get(it.current());
                charMap.put(it.current(), ++i);
            }
            else {
                charMap.put(it.current(),1);
            }
            it.next();
        }
        CharacterIterator itt = new StringCharacterIterator(t);
        while(itt.current()!=CharacterIterator.DONE) {
            if(charMap.containsKey(itt.current())) {
                int i = charMap.get(itt.current());
                if(i==0) return false;
                else {
                    charMap.put(itt.current(),--i);
                }
                itt.next();
            }
            else return false;
        }//the first loop
        //the second loop is to find whether s>t
        for(Character key: charMap.keySet()) {
            if(charMap.get(key)!=0) return false;
        }
        return true;
    }
}

public class cmpstr {
    public static void main(String[] args) {
        String a = "ABCD";
        String b= "ACD";
        System.out.println(compareStrings(a,b));
    }
    static boolean compareStrings(String A, String B) {
        // write your code here
        int[] a = new int[26];
        int[] b = new int[26];
        for(char c: A.toCharArray()) {
            a[c-'A'] +=1;
        }
        for(char d: B.toCharArray()) {
            b[d-'A']+=1;
        }
        for(int i=0;i<26;++i) {
            if(a[i]<b[i]) return false;
        }
        return true;
    }
}

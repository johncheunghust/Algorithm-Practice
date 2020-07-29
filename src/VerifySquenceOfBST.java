public class VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] seq = {4,7,8,5,2,6,3,1};
        System.out.println(VerifySquenceOfBST(seq));
    }
    static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0) return false;
        int root = sequence[sequence.length-1];
        int i;
        if(sequence.length==1||sequence.length==2) return true;
        for(i=0;i<sequence.length;++i) {
            if(sequence[i]<root) continue;
            else break;
        }
        for(int j=i+1;j<sequence.length-1;++j) {
            if(sequence[j]<root) return false;
        }
        if(i>0) {
            int[] l = new int[i];
            for(int j=0;j<i;++j) l[j]=sequence[j];
            if(!VerifySquenceOfBST(l)) return false;
        }
        if(sequence.length-i-1>0) {
            int[] r = new int[sequence.length-i-1];
            for(int j=i;j<sequence.length-1;++j) r[j-i] = sequence[j];
            if(!VerifySquenceOfBST(r)) return false;
        }
        return true;
    }


}

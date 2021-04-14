package RepeatingSubstring;

public class Solution {
    public boolean repeatedSubStringPattern(String s) {
        if(s.length()==1)return false;
        String r="";

        StringBuffer a=new StringBuffer();

        for(int i=1;i<s.length();i++)
        {
            if(s.length()%s.substring(0,i).length()!=0)
                continue;
            for(int j=1;j<=(s.length()/s.substring(0,i).length());j++)
                a.append(s.substring(0,i));
            if(a.toString().equals(s))
                return true;
            a=new StringBuffer(r);
        }


        return false;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        String str = "abab";
        boolean res = s.repeatedSubStringPattern(str);
        System.out.println(res);
    }
}

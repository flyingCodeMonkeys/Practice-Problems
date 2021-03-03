package RussianMult;

class Solution{
    public int RussianMult(int a, int b) {
        int result = 0;
        while(b > 1){
            a = a * 2;
            b = (int)Math.floor((double)b / 2);
            if(b%2 > 0) {
                result += a;
            }
        }
        return result;
    }
}

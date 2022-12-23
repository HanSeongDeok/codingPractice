public class Main {
    public static void main(String[] args) {
        int n = 100000000;
        int len = 1;
        int tenX = 1;
        int totalLen = 10;
        int output = 0;
        String s = "";
        String outputStr = "";

        while(true) {
            if (n>=totalLen){
                len++;
                tenX *= 10;
                totalLen += (len * tenX * 9);
            } else {
                break;
            }
       }
        if(n<10){
            output = n;
        } else {
            totalLen -= len*tenX*9;
            int test = n-totalLen;
            int test2 = test/len;
            int test3 = test%len;

            s = String.valueOf(test2+tenX);
            output = Character.getNumericValue(s.charAt(test3));
        }
    }
}
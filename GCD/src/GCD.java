/**
 * Created by Panda on 2016/5/26.
 */
public class GCD {
    public static int gcd(int a, int b){
        if(0 == b)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int result = GCD.gcd(10,15);
        System.out.println(result);
    }
}

public class zadanie2 {
    public static void main(String[] args){
        int a =124;
        int b = 6;
        System.out.println("NWD liczb " + a + " i " + b + ": " + nwd_euklides(a, b));
        System.out.println("NWD metodą odejmowania liczb " + a + " i " + b + ": " + nwd_odejmowanie(a, b));
    }
    public static int nwd_euklides(int a, int b) {
        while (a%b != 0) {
            if (a%b == 0) {
                return b;
            }
            else {
                int tempb = b, tempa = a;
                a = tempb;
                b = tempa%tempb;
            }
        }
        return b;
    }
    public static int nwd_odejmowanie(int a, int b) {
        while (a!=b) {
            if (a>b) {
                a -= b;
            }
            else {
                b -= a;
            }
        }
        return a;
    }
}

public class Main {

    public static void main(String[] args) {
        int a = 100, b = 20;
        System.out.println("Najwiekszy wspolny dzielnik " + a + " i " + b + " to " + nwd_euklides(a, b));
        System.out.println("Najwiekszy wspolny dzielnik " + a + " i " + b + " to " + nwd_odejmowanie(a, b));
        tabliczka(10);
        System.out.println(" ");
        System.out.println(" ");
        tablica_mat(2);
    }

    public static long silnia(int n) {
        long wynik = 1;
        for (int i = 2; i<=n; i++) {
            wynik *= i;
        }
        return wynik;
    }
    public static double stirling(int n) {
        double przyblizenie;
        przyblizenie = Math.pow(n/Math.E, n) * Math.sqrt(2*Math.PI*n);
        return przyblizenie;
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
    public static boolean czy_pierwsza(int n) {
        boolean wynik = true;
        int do_kiedy = (int) Math.floor(Math.sqrt(n));
        if (n<2) {
            return false;
        }
        for (int i = 2; i <= do_kiedy; i++){
            if ((n%i) == 0) {
                wynik = false;
            }
        }
        return wynik;
    }
    public static void liczby_pierwsze(int a, int b) {
        for (int liczba=a; liczba<=b; liczba++){
            if (czy_pierwsza(liczba)) System.out.println(liczba);
        }
    }
    public static void tabliczka(int n) {
        for (int i = 1; i<=n; i++) {
            System.out.println();
            for (int j = 1; j <= n; j++) {
                System.out.printf("%5d", i * j);
            }
        }
    }
    public static void tablica_mat(double x) {
        System.out.println("x  x^2  x^3  e^x  ln(x)");
        System.out.printf("%3f", x);
        System.out.printf("%3f", Math.pow(x, 2));
        System.out.printf("%3f", Math.pow(x, 3));
        System.out.printf("%3f", Math.exp(x));
        System.out.printf("%3f", Math.log(x));
    }
}



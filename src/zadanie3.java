public class zadanie3 {
    public static void main(String[] args){
        int a = 10, b=34;
        System.out.println("Liczby pierwsze w przedziale " + a + "-" + b + ": ");
        liczby_pierwsze(a, b);
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
                break;
            }
        }
        return wynik;
    }
    public static void liczby_pierwsze(int a, int b) {
        for (int liczba=a; liczba<=b; liczba++){
            if (czy_pierwsza(liczba)) System.out.println(liczba);
        }
    }

}

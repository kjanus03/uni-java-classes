public class zadanie1 {
    public static void main(String[] args){
        int n = 14;
        System.out.println("Silnia liczby " + n + ": " + silnia(n));
        System.out.println("Przyblizenie wzorem Stirlinga silnii " + n + ": " + stirling(n));
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
}

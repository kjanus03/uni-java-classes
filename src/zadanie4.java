public class zadanie4 {
    public static void main(String[] args){
        int n = 10;
        System.out.println("Tabliczka mnozenie " + n + "x" + n);
        tabliczka(n);
    }
    public static void tabliczka(int n) {
        for (int i = 1; i<=n; i++) {
            System.out.println();
            for (int j = 1; j <= n; j++) {
                System.out.printf("%5d", i * j);
            }
        }
    }
}

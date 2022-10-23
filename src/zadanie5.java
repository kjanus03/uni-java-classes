public class zadanie5 {
    public static void main(String[] args){
        int x = 6;
        System.out.println("Tablica matematyczna dla x = " + x + ": ");
        tablica_mat(x);
    }
    public static void tablica_mat(double x) {
        System.out.println("x    x^2    x^3    e^x    ln(x)");
        System.out.printf("%0,4.3f", x);
        System.out.print(" ");
        System.out.printf("%0,4.2f", Math.pow(x, 2));
        System.out.print(" ");
        System.out.printf("%0,4.2f", Math.pow(x, 3));
        System.out.print(" ");
        System.out.printf("%0,4.2f", Math.exp(x));
        System.out.print(" ");
        System.out.printf("%0,4.2f", Math.log(x));
    }

}

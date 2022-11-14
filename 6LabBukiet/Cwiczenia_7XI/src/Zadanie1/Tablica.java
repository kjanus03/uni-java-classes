package Zadanie1;

import java.util.Random;

public class Tablica {
    private int[] arr;
    private int n = 10;

    public Tablica() {
        arr = new int[n];
    }

    public Tablica(int n) {
        this.n = n;
        arr = new int[n];
    }

    public void wypelnij(int a, int b) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(b - a + 1) + a;
            arr[i] = num;
        }
    }

    public String toString() {
        String wynik = "[";
        StringBuilder sB = new StringBuilder(wynik);
        for (int k = 0; k < n; k++) {
            sB.append(arr[k]);
            if (k != n - 1) {
                sB.append(", ");
            }
        }
        sB.append("]");
        wynik = sB.toString();
        return wynik;
    }

    public void odwroc() {
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    public int wyszukaj(int e) {
        int indeks = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == e) {
                indeks = i;
                break;
            }
        }
        return indeks;
    }

    public int max() {
        double Max = Double.NEGATIVE_INFINITY;
        for (int k : arr) {
            if (k > Max) {
                Max = k;
            }
        }
        return (int) Max;
    }

    public int min() {
        double Min = Double.POSITIVE_INFINITY;
        for (int k : arr) {
            if (k < Min) {
                Min = k;
            }
        }
        return (int) Min;
    }

    public int max_ind() {
        int Max = this.max();
        return wyszukaj(Max);
    }

    public int min_ind() {
        int Min = this.min();
        return wyszukaj(Min);
    }

    public boolean czy_roznowartosciowa() {
        int i = 0;
        int j = 1;
        boolean wynik = true;
        while (i < n) {
            while (j < n) {
                if (arr[i] == arr[j]) {
                    wynik = false;
                    break;
                }
                if (!wynik) {
                    break;
                }
                j++;
            }
            j = i + 2;
            i++;
        }
        return wynik;
    }

    public int policz(int k) {
        int wynik = 0;
        for (int a : arr) {
            if (a == k) {
                wynik += 1;
            }
        }
        return wynik;
    }

    public void zrob_roznowartosciowa() {
        double dlugosc_wyniku = 0;
        boolean[] czy_dodac = new boolean[n];
        for (int i = 0; i < n; i++) {
            czy_dodac[i] = this.wyszukaj(arr[i]) == i;
        }
        for (int a : arr) {
            dlugosc_wyniku += 1.0 / this.policz(a);
        }
        int dlugosc_wyniku1 = (int) dlugosc_wyniku;
        int[] new_arr = new int[dlugosc_wyniku1];
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (czy_dodac[j]) {
                new_arr[i] = arr[j];
                i++;
            }
        }
        this.arr = new_arr;
        this.n = dlugosc_wyniku1;
    }


    public static void main(String[] args) {
        Tablica tablica = new Tablica(20);
        tablica.wypelnij(1, 15);
        tablica.odwroc();
        int szukana = 7;
        System.out.println("Liczba " + szukana + " znajduje sie na poczycji: " + tablica.wyszukaj(szukana));
        System.out.println("Najwieksza wartosc w tablicy to " + tablica.max() + " i znajduje sie na pozycji " + tablica.max_ind());
        System.out.println("Najmniejsza wartosc w tablicy to " + tablica.min() + " i znajduje sie na pozycji " + tablica.min_ind());
        System.out.println("Czy tablica jest roznowartosciowa: " + tablica.czy_roznowartosciowa());
        tablica.zrob_roznowartosciowa();
        System.out.println("Czy tablica jest roznowartosciowa: " + tablica.czy_roznowartosciowa());

    }

}

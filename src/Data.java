import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private int dzien;
    private int miesiac;
    private int rok;

    public Data(int dzien, int miesiac, int rok) {
        this.dzien = dzien;
        this.miesiac = miesiac;
        this.rok = rok;
    }

    public Data() {
        this.dzien = 24;
        this.miesiac = 10;
        this.rok = 2022;
    }

    @SuppressWarnings("SameParameterValue")
    void setDzien(int dzien) {
        this.dzien = dzien;
    }

    @SuppressWarnings("SameParameterValue")
    void setMiesiac(int miesiac) {
        this.miesiac = miesiac;
    }

    @SuppressWarnings("SameParameterValue")
    void setRok(int rok) {
        this.rok = rok;
    }

    int getDzien() {
        return dzien;
    }

    int getMiesiac() {
        return miesiac;
    }

    int getRok() {
        return rok;
    }

    String to_string() {
        return dzien + "." + miesiac + "." + rok;
    }

    @SuppressWarnings("SameParameterValue")
    void ustawDate(int dzien, int miesiac, int rok) {
        this.dzien = dzien;
        this.miesiac = miesiac;
        this.rok = rok;
    }

    boolean czyRokPrzestepny() {
        return ((this.rok % 400 == 0) || (this.rok % 4 == 0) & (this.rok % 100 != 0));
    }

    boolean czyDataPoprawna() {
        if (dzien <= ileDniMaMiesiac() && dzien >= 1) {
            return miesiac <= 12 && miesiac >= 1;
        }
        return false;
    }

    int ileDniMaMiesiac() {
        Integer[] a;
        if (czyRokPrzestepny()) {
            a = new Integer[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        } else {
            a = new Integer[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }

        ArrayList<Integer> month_lengths = new ArrayList<>(Arrays.asList(a));
        return month_lengths.get(miesiac - 1);
    }

    int ktoryDzienRoku() {
        int[] dlugosci = czyRokPrzestepny() ? new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} : new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ktory = 0;
        for (int i = 0; i < miesiac - 1; i++) {
            ktory += dlugosci[i];
        }
        ktory += dzien;
        return ktory;
    }

    int compareDate(Data data) {
        if (data.rok == this.rok) {
            if (data.miesiac == this.miesiac) {
                return Integer.compare(this.dzien, data.dzien);
            }
            return Integer.compare(this.miesiac, data.miesiac);
        }
        return Integer.compare(this.rok, data.rok);
    }

    int ileDniWRoku() {
        return czyRokPrzestepny() ? 366 : 365;
    }

    // METODA STARTOWA
    public static void main(String[] args) {
        Data data1 = new Data();
        Data data2 = new Data(25, 1, 1995);
        data1.setDzien(7);
        data1.setMiesiac(9);
        data1.setRok(2003);
        System.out.println("Data 1 to " + data1.to_string());
        System.out.println("Dzien daty 1 to " + data1.getDzien());
        System.out.println("Miesiac daty 1 to " + data1.getMiesiac());
        System.out.println("Rok daty 1 to " + data1.getRok());
        data1.ustawDate(4, 5, 1972);
        System.out.println("Data 1 to " + data1.to_string());
        System.out.println("Czy data 1 jest poprawna: " + data1.czyDataPoprawna());
        System.out.println("Dzien " + data1.to_string() + " to " + data1.ktoryDzienRoku() + " dzien roku.");
        System.out.println(data1.compareDate(data2));
        System.out.println("Rok " + data1.getRok() + " ma " + data1.ileDniWRoku() + " dni.");

    }
}


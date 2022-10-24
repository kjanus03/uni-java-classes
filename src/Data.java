import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    int dzien;
    int miesiac;
    int rok;

    public Data() {
        dzien = 24;
        miesiac = 10;
        rok = 2022;
    }

    void setDzien(int dzien) {
        this.dzien = dzien;
    }

    void setMiesiac(int miesiac) {
        this.miesiac = miesiac;
    }

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
        return Integer.toString(dzien) + "." + Integer.toString(miesiac) + "." + Integer.toString(rok);
    }

    void ustawDate(int d1, int m1, int r1) {
        dzien = d1;
        miesiac = m1;
        rok = r1;
    }

    boolean czyRokPrzestepny() {
        if (rok % 400 == 0) {
            return true;
        } else if (rok % 100 == 0) {
            return false;
        } else return rok % 4 == 0;
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

        ArrayList<Integer> month_lengths = new ArrayList<Integer>(Arrays.asList(a));
        return month_lengths.get(miesiac - 1);
    }

    int ktoryDzienRoku() {
        int[] dlugosci = czyRokPrzestepny() ? new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}: new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ktory = 0;
        for (int i = 0; i < miesiac-1; i++){
            ktory += dlugosci[i];
        }
        ktory += dzien;
        return ktory;
    }

    int compareDate(Data data){
        if (data.rok == this.rok){
            if (data.miesiac == this.miesiac) {
                return Integer.compare(this.dzien, data.dzien);
            }
            return Integer.compare(this.miesiac, data.miesiac);
        }
        return Integer.compare(this.rok, data.rok);
    }

    int ileDniWRoku(){
        return czyRokPrzestepny() ? 366 : 365;
    }

    // METODA STARTOWA
    public static void main(String[] args){
        Data data1 = new Data();
        System.out.println();

    }
}


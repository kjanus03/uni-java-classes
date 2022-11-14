package Zadanie1;

import java.util.Arrays;
import java.util.Random;

public class Array {
    private int n = 10;
    private int tab[];

    public Array(int n) {
        tab = new int[n];
    }

    public Array() {
        tab = new int[this.n];
    }

    public void set_n(int n) {
        this.n = n;
    }

    public void fill_tab() {
        int max = 10, min = 1;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(max - min + 1) + min;
            tab[i] = num;
        }
    }

    public String show_tab() {
        String result = "[";
        StringBuilder sB = new StringBuilder(result);
        for (int i = 0; i < n; i++) {
            int liczba = tab[i];
            sB.append(liczba);
            if (i != n - 1) {
                sB.append(", ");
            }
        }
        sB.append("]");
        result = sB.toString();
        return result;
    }

    public int find_in_any(int k){
        for (int i = 0; i<n; i++){
            if (tab[i] == k){
                return i;
            }
        }
        return -1;
    }

    public int find_in_sorted(int k){
        int low = 0;
        int high = n;
        while(low <= high){
            int mid = low + ((high - low)/2);
            if (tab[mid] < k){
                low = mid + 1;
            }
            else if (tab[mid] > k){
                high = mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    public void bubbleSort()
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (tab[j] > tab[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    temp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }
    public void add_element(int k){
        int [] new_tab = new int[n+1];
        for (int i = 0; i<n; i++){
            new_tab[i] = tab[i];
        }
        new_tab[n] = k;
        n++;
        tab = new_tab;
    }
    public void add_element_to_sorted(int k){
        int [] new_tab = new int[n+1];
        int i = 0;
        boolean added = false;
        while (i<n){
            if (tab[i] <= k) {
                new_tab[i] = tab[i];
                i++;
            }
            else if(tab[i] > k & !added){
                new_tab[i] = k;
                added = true;
            }
            else {
                new_tab[i + 1] = tab[i];
                i++;
            }
        }
        tab = new_tab;
        n++;
    }
    public long suma(){
        long wynik = 0;
        for (int k: tab){
            wynik += k;
        }
        return wynik;
    }
    public double srednia(){
        return (double) this.suma() / n;
    }
    public void zamiana(int a, int b){
        int [] new_tab = new int[n];
        for (int i = 0; i < n; i++){
            if (i==a){
                new_tab[i] = tab[b];
            }
            else if (i==b){
                new_tab[i] = tab[a];
            }
            else{
                new_tab[i] = tab[i];
            }
        }
        tab = new_tab;
    }
    public static void main(String[] args) {
        Array arr = new Array();
        arr.fill_tab();
        System.out.println(arr.show_tab());
        arr.bubbleSort();
        System.out.println(arr.show_tab());
        System.out.println(arr.find_in_sorted(6));
        arr.add_element(111);
        System.out.println(arr.show_tab());
        arr.add_element_to_sorted(4);
        System.out.println(arr.show_tab());
        System.out.println("Suma: " + arr.suma());
        System.out.println("Srednia: " + arr.srednia());
        arr.zamiana(2, 5);
        System.out.println(arr.show_tab());

    }
}

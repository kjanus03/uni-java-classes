import java.util.Arrays;

public class Hotel{
    // liczba pokoi na kazdym pietrze
    private int[] pokNaPietrze;
    private Pokoj[][] hotel;
    private int n;
    public Hotel(){
        this.pokNaPietrze = new int[]{4, 4, 4, 6, 5};
        n=pokNaPietrze.length;
        hotel = new Pokoj [n][];

    }
    public Hotel(int[] pokNaPietrze){
        this.pokNaPietrze = pokNaPietrze;
        n=pokNaPietrze.length;
        hotel = new Pokoj [n][];
    }
    public void wypelnijHotel(){
        for (int i = 0; i<n; i++){
            int a = pokNaPietrze[i];
            Pokoj[] pokoje = new Pokoj[a];
            for (int j = 0; j<a; j++){
                int numer = (i+1)*100 + (j+1);
                pokoje[j] = new Pokoj(numer, new Osoba());
            }
            hotel[i] = pokoje;
        }
    }
    public String toString(){
        String wynik = "[\n";
        StringBuilder sb = new StringBuilder(wynik);
        for (int i = 0; i < n-1; i++){
            sb.append(Arrays.toString(hotel[i]));
            sb.append(",\n");
        }
        sb.append(Arrays.toString(hotel[n-1]));
        sb.append("]\n");
        wynik = sb.toString();
        return wynik;
    }
    public int ileWolnychPokoi(){
        int wynik = 0;
        for (int i = 0; i<n; i++){
            Pokoj[] pietro = hotel[i];
            for(int j = 0; j<pokNaPietrze[i]; j++){
                if (pietro[j].czyWolnyPokoj()){
                    wynik++;
                }
            }
        }
        return wynik;
    }
    public void zwolnijPokoj(int numer){
        for (int i = 0; i<n; i++) {
            Pokoj[] pietro = hotel[i];
            for (int j = 0; j < pietro.length; j++) {
                Pokoj pokoj=pietro[j];
                if (pokoj.getNumer() == numer){
                    pokoj.zwolnijPokoj();
                    System.out.println(pokoj.toString());
                }
            }
        }
    }
    public int znajdzWolnyPokoj(){
        int result = -1;
        for (int i = 0; i<n; i++){
            for (int j = 0; j<pokNaPietrze[i]; j++){
                if (hotel[i][j].czyWolnyPokoj()){
                    result = hotel[i][j].getNumer();
                    return result;
                }
            }
        }
        return result;
    }
    public void wynajmijPokoj(Osoba os){
        int numer_pokoju = znajdzWolnyPokoj();
        if (numer_pokoju!=-1){
            for(int i = 0; i<n; i++){
                for (Pokoj pokoj: hotel[i]){
                    if (pokoj.getNumer() == numer_pokoju){
                        pokoj.setKlient(os);
                    }
                }
            }
        }
    }
    public boolean czyOsobaWynajmuje(Osoba o){
        boolean w = false;
        for (int i = 0; i<n; i++){
            for (Pokoj pokoj: hotel[i]){
                if (pokoj.getKlient().equals(o)){
                    w = true;
                }
            }
        }
        return w;
    }
    public void zwolnijZajetePrzez(Osoba os){
        for (int i = 0; i<n; i++){
            for (Pokoj pokoj: hotel[i]){
                if (pokoj.getKlient().equals(os)){
                    pokoj.zwolnijPokoj();
                }
            }
        }
    }
    public Pokoj[] listaWolnychPokoi(){
        Pokoj[] lista = new Pokoj[this.ileWolnychPokoi()];
        int j = 0;
        for (int i=0; i<n; i++){
            for(Pokoj pokoj: hotel[i]){
                if (pokoj.czyWolnyPokoj()){
                    lista[j] = pokoj;
                    j++;
                }
            }
        }
        return lista;
    }

}

public class Pokoj {
    private int numer;
    private Osoba klient = null;
    public Pokoj(){
        numer = 0;
        klient = new Osoba();
    }
    public Pokoj(int numer, Osoba klient){
        this.numer = numer;
        this.klient = klient;
    }
    public void setNumer(int numer){
        this.numer = numer;
    }
    public void setKlient(Osoba klient){
        this.klient = klient;
    }
    public int getNumer(){
        return numer;
    }
    public Osoba getKlient(){
        return klient;
    }
    boolean czyWolnyPokoj(){
        return (klient==null);
    }
    void zwolnijPokoj(){
        klient = null;
    }
    public String toString(){
        String wynik = "";
        StringBuilder sb = new StringBuilder(wynik);
        sb.append("Pokoj numer: ");
        sb.append(numer);
        if (klient != null) {
            sb.append(", Klient: ");
            sb.append(klient.toString());
        }
        else{
            sb.append(", pusty");
        }
        return sb.toString();
    }
}

public class Osoba {
    private String nazwisko =null;
    private String imie=null;
    private int wiek;

    public Osoba(){
        imie = "Jan";
        nazwisko = "Kowalski";
        wiek = 25;
    }
    public Osoba(String imie, String nazwisko, int wiek){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }
    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }
    public void setImie(String imie){
        this.imie = imie;
    }
    public void setWiek(int wiek){
        this.wiek = wiek;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    public String getImie(){
        return imie;
    }
    public int getWiek(){
        return wiek;
    }
    public String toString(){
        String wynik = "";
        StringBuilder sb = new StringBuilder(wynik);
        sb.append(imie);
        sb.append(" ");
        sb.append(nazwisko);
        sb.append(", wiek: ");
        sb.append(wiek);
        sb.append("\n");
        wynik = sb.toString();
        return wynik;
    }
    boolean equals(Osoba o){
        boolean w1 = (o.wiek == this.wiek);
        boolean w2 = (o.imie.equals(this.imie));
        boolean w3 = (o.nazwisko.equals(this.nazwisko));
        return (w1 && w2 && w3);
    }

}

public class Book {
    private String autor;
    private String tytul;
    private int strony;
    private boolean wypozyczona;
    public Book(String autor, String tytul, int strony){
        this.autor = autor;
        this.tytul = tytul;
        this.strony = strony;
        this.wypozyczona = false;
    }
    public String getAutor(){
        return autor;
    }
    public String getTytul(){
        return tytul;
    }
    public int getStrony(){
        return strony;
    }
    public boolean getWypozyczona(){
        return wypozyczona;
    }
    public void setAutor(String autor){this.autor = autor;}

    public void setTytul(String tytul){this.tytul = tytul;}

    public void setStrony(int strony){this.strony = strony;}

    public void setWypozyczona(boolean wypozyczona){this.wypozyczona = wypozyczona;}

    public String toString(){
        return autor + "\n" + tytul + "\n" + "Liczba stron: " + strony + "\n" + "wypozyczona: " + wypozyczona;
    }

    public void wywswietl(){
        String dane = this.toString();
        System.out.println(dane);
    }
    public boolean czyDostepna(){
        return !wypozyczona;
    }
    public void wypozycz(){
        if (czyDostepna()){
            wypozyczona = true;
            System.out.println("OK");
        }
        else{
            System.out.println("Ksiazka jest juz wypozyczona");
        }
    }
    public void zwrot(){
        if (wypozyczona){
            wypozyczona = false;
            System.out.println("Ksiazka zwrocona");
        }
        else{
            System.out.println("Ta ksiazka nie jest wypozyczona!");
        }
    }

    public static void main(String[] args){
        Book ksiazka = new Book("Fiodor Dostojewski", "Zbrodnia i Kara", 543);
        ksiazka.wywswietl();
        ksiazka.wypozycz();
        ksiazka.wypozycz();
        ksiazka.zwrot();
    }
}

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Hotel motel = new Hotel();
        motel.wypelnijHotel();
        System.out.println(motel.toString());
        motel.zwolnijPokoj(505);
        System.out.println("Jest " + motel.ileWolnychPokoi() + " wolnych pokoi.");
        System.out.println(motel.toString());
        System.out.println(motel.znajdzWolnyPokoj());
        Osoba alex = new Osoba("Alex", "Turner", 35);
        motel.wynajmijPokoj(alex);
        System.out.println(motel.toString());
        System.out.println(motel.czyOsobaWynajmuje(alex));
        motel.zwolnijZajetePrzez(new Osoba());
        System.out.println(motel.toString());
        Osoba kacper = new Osoba("Kacper", "Janus", 19);
        motel.wynajmijPokoj(kacper);
        System.out.println(motel.toString());
        System.out.println(Arrays.toString(motel.listaWolnychPokoi()));
    }
}
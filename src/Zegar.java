public class Zegar {
    private int godz;
    private int min;
    private int sek;
    static int ile;

    public Zegar(int godz, int min, int sek) {
        ile += 1;
        this.godz = godz;
        this.min = min;
        this.sek = sek;
    }

    public Zegar() {
        ile += 1;
        godz = 0;
        min = 0;
        sek = 0;
    }

    public int get_godz() {
        return godz;
    }

    public int get_min() {
        return min;
    }

    public int get_sek() {
        return sek;
    }

    public void set_godz(int godz) {
        this.godz = godz;
    }

    public void set_min(int min) {
        this.min = min;
    }

    public void set_sek(int sek) {
        this.sek = sek;
    }

    public String toString() {
        String g = String.valueOf(godz);
        String m = String.valueOf(min);
        String s = String.valueOf(sek);
        if (godz < 10) g = "0" + g;
        if (min < 10) m = "0" + m;
        if (sek < 10) s = "0" + s;
        return g + ":" + m + ":" + s;
    }

    public boolean equals(int g, int m, int s) {
        return godz == g && min == m && sek == s;
    }

    public void plusGodz() {
        godz = godz + 1;
        godz = godz % 24;
    }

    public void minusGodz() {
        if (godz > 0) godz = godz - 1;
        else godz = 23;
    }

    public void plusSek() {
        if (sek == 59) {
            if (min == 59) {
                plusGodz();
                min = 0;
                sek = 0;
            } else {
                min += 1;
                sek = 0;
            }
        } else {
            sek += 1;
        }
    }

    public void plusSek(int n) {
        for (int i = 0; i < n; i++) {
            plusSek();
        }
    }

    public int compare(int g, int m, int s) {
        if (godz == g) {
            if (min == m) {
                return Integer.compare(sek, s);
            }
            return Integer.compare(min, m);
        }
        return Integer.compare(godz, g);
    }

    public static void main(String[] args) {
        Zegar zegar1 = new Zegar(23, 37, 15);
        System.out.println("Przed doaniem: " + zegar1.toString());
        zegar1.plusGodz();
        System.out.println("Po dodaniu: " + zegar1.toString());
        System.out.println();

        Zegar zegar2 = new Zegar(0, 23, 7);
        System.out.println("Przed odjeciem: " + zegar2.toString());
        zegar2.minusGodz();
        System.out.println("Po odjeciu: " + zegar2.toString());
        System.out.println();

        Zegar zegar3 = new Zegar(23, 54, 56);
        zegar3.plusSek(3000);
        System.out.println(zegar3.toString());
        System.out.println();

        Zegar zegar4 = new Zegar(23, 23, 23);
        System.out.println("Czy zegar jest wiekszy: " + zegar4.compare(23, 23, 23));
        System.out.println();

        System.out.println("Liczba zegrow: " + ile);
    }
}

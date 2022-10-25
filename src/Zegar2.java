public class Zegar2 {
    private int godz;
    private int min;
    private int sek;
    static int ile;

    public Zegar2(int sek) {
        ile += 1;
        this.godz = sek / 3600;
        this.min = (sek - (sek/3600) * 3600) / 60;
        this.sek = sek%60;
    }

    public Zegar2() {
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
        Zegar2 zegar1 = new Zegar2(12345);
        System.out.println("Przed doaniem: " + zegar1.toString());
        zegar1.plusGodz();
        System.out.println("Po dodaniu: " + zegar1.toString());
        System.out.println();

        Zegar2 zegar2 = new Zegar2(23234);
        System.out.println("Przed odjeciem: " + zegar2.toString());
        zegar2.minusGodz();
        System.out.println("Po odjeciu: " + zegar2.toString());
        System.out.println();

        Zegar2 zegar3 = new Zegar2(17999);
        zegar3.plusSek(3000);
        System.out.println(zegar3.toString());
        System.out.println();

        Zegar2 zegar4 = new Zegar2(43333);
        System.out.println("Czy zegar jest wiekszy: " + zegar4.compare(23, 23, 23));
        System.out.println();

        System.out.println("Liczba zegarow: " + ile);
    }
}

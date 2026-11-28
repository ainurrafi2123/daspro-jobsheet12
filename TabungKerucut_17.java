import java.util.Scanner;

public class TabungKerucut_17 {

    public static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    public static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }

    public static double luasPermukaanTabung(double r, double t) {
        double luasSelimut = 2 * Math.PI * r * t;
        return (2 * luasLingkaran(r)) + luasSelimut;
    }

    public static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU TABUNG & KERUCUT ===");
            System.out.println("1. Luas Lingkaran");
            System.out.println("2. Volume Tabung");
            System.out.println("3. Luas Permukaan Tabung");
            System.out.println("4. Volume Kerucut");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-4): ");
            pilihan = input.nextInt();

            if (pilihan >= 1 && pilihan <= 4) {
                System.out.print("Masukkan jari-jari (r): ");
                double r = input.nextDouble();

                if (pilihan == 1) {
                    System.out.printf("Luas Lingkaran = %.2f\n", luasLingkaran(r));
                } else {
                    System.out.print("Masukkan tinggi (t): ");
                    double t = input.nextDouble();

                    if (pilihan == 2) {
                        System.out.printf("Volume Tabung = %.2f\n", volumeTabung(r, t));
                    } else if (pilihan == 3) {
                        System.out.printf("Luas Permukaan Tabung = %.2f\n", luasPermukaanTabung(r, t));
                    } else if (pilihan == 4) {
                        System.out.printf("Volume Kerucut = %.2f\n", volumeKerucut(r, t));
                    }
                }
            } else if (pilihan != 0) {
                System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);

        System.out.println("Program selesai.");
        input.close();
    }
}

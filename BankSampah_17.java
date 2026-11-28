import java.util.Scanner;

public class BankSampah_17 {
    static Scanner input = new Scanner(System.in);

    public static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = input.nextDouble();
        }
        return setoran;
    }

    public static void tampilSetoran(double[] setoran) {
        System.out.println("\n--- Daftar Berat Setoran Nasabah ---");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    public static double totalSetoran(double[] setoran) {
        double total = 0;
        for (int i = 0; i < setoran.length; i++) {
            total += setoran[i];
        }
        return total;
    }

    public static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    public static int nasabahTerbanyak(double[] setoran) {
        int indeksMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[indeksMax]) {
                indeksMax = i;
            }
        }
        return indeksMax;
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = input.nextInt();

        double[] dataSetoran = inputSetoran(n);

        tampilSetoran(dataSetoran);

        double totalBerat = totalSetoran(dataSetoran);
        System.out.println("\nTotal berat setoran seluruh nasabah: " + totalBerat + " kg");

        double hargaPerKg = 3000;
        System.out.println("\n--- Saldo Setiap Nasabah (Rp3.000/kg) ---");
        for (int i = 0; i < dataSetoran.length; i++) {
            double saldo = hitungSaldo(dataSetoran[i], hargaPerKg);
            System.out.printf("Nasabah ke-%d: Rp%,.2f\n", (i + 1), saldo);
        }

        int indeksTerbanyak = nasabahTerbanyak(dataSetoran);
        System.out.println("\nNasabah dengan setoran terbanyak adalah Nasabah ke-" + (indeksTerbanyak + 1) 
                + " (Indeks array: " + indeksTerbanyak + ") dengan berat " + dataSetoran[indeksTerbanyak] + " kg.");
    }
}

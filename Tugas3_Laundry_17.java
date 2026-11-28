import java.util.Scanner;

public class Tugas3_Laundry_17 {
    static Scanner sc = new Scanner(System.in);

    static void inputData(int[][] data, String[] layanan, String[] hari) {
        System.out.println("=== INPUT DATA BERAT CUCIAN (KG) ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Layanan: " + layanan[i]);
            for (int j = 0; j < hari.length; j++) {
                System.out.print("  " + hari[j] + ": ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilTabel(int[][] data, String[] layanan, int[] harga, String[] hari) {
        System.out.println("\n=== REKAP BERAT CUCIAN LAUNDRY PAK RUDI ===");
        System.out.print("Layanan\t\tHarga/kg\t");
        for (String h : hari) {
            System.out.print(h + "\t");
        }
        System.out.println("\n=========================================================================");

        for (int i = 0; i < layanan.length; i++) {
            System.out.print(layanan[i] + "\tRp" + harga[i] + "\t\t");
            for (int j = 0; j < hari.length; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    static void layananTertinggi(int[][] data, String[] layanan) {
        int maxBerat = -1;
        int idxMax = 0;

        for (int i = 0; i < layanan.length; i++) {
            int total = totalPerLayanan(data, i);
            if (total > maxBerat) {
                maxBerat = total;
                idxMax = i;
            }
        }
        System.out.println("\nLayanan dengan berat tertinggi: " + layanan[idxMax] + " (" + maxBerat + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int maxBerat = -1;
        int idxHariMax = 0;
        int jumlahHari = data[0].length;

        for (int j = 0; j < jumlahHari; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (totalHari > maxBerat) {
                maxBerat = totalHari;
                idxHariMax = j;
            }
        }
        return idxHariMax;
    }

    static void hitungPendapatan(int[][] data, String[] layanan, int[] harga) {
        System.out.println("\n=== LAPORAN PENDAPATAN ===");
        int totalSemuaPendapatan = 0;

        for (int i = 0; i < layanan.length; i++) {
            int totalKg = totalPerLayanan(data, i);
            int pendapatanLayanan = totalKg * harga[i];
            totalSemuaPendapatan += pendapatanLayanan;
            System.out.println(layanan[i] + "\t: Rp" + pendapatanLayanan + " (" + totalKg + " kg)");
        }
        System.out.println("Total Pendapatan 6 Hari: Rp" + totalSemuaPendapatan);
    }

    public static void main(String[] args) {
        String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] harga = {6000, 8000, 5000, 12000};
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        int[][] data = new int[layanan.length][hari.length];

        inputData(data, layanan, hari);
        tampilTabel(data, layanan, harga, hari);
        layananTertinggi(data, layanan);

        int idxSibuk = hariTersibuk(data);
        System.out.println("Hari tersibuk: " + hari[idxSibuk]);

        hitungPendapatan(data, layanan, harga);
    }
}

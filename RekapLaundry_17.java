import java.util.Scanner;

public class RekapLaundry_17 {
    static Scanner sc = new Scanner(System.in);

    static void inputMasterLayanan(String[] layanan, int[] harga) {
        System.out.println("=== INPUT DATA LAYANAN ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = sc.nextLine();
            System.out.print("Harga per kg (" + layanan[i] + "): Rp");
            harga[i] = sc.nextInt();
            sc.nextLine();
        }
    }

    static void inputData(int[][] data, String[] layanan, int jumlahHari) {
        System.out.println("\n=== INPUT DATA BERAT CUCIAN (KG) ===");
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Layanan: " + layanan[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.print("  Hari ke-" + (j + 1) + ": ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilTabel(int[][] data, String[] layanan, int[] harga, int jumlahHari) {
        System.out.println("\n=== REKAP BERAT CUCIAN LAUNDRY ===");
        System.out.print("Layanan\t\tHarga/kg\t");
        for (int j = 0; j < jumlahHari; j++) {
            System.out.print("Hari ke-" + (j + 1) + "\t");
        }
        System.out.println("\n-------------------------------------------------------------------------");

        for (int i = 0; i < layanan.length; i++) {
            String tabLayanan = (layanan[i].length() < 8) ? "\t\t" : "\t";

            System.out.print(layanan[i] + tabLayanan + "Rp" + harga[i] + "\t\t");
            for (int j = 0; j < jumlahHari; j++) {
                System.out.print(data[i][j] + "\t\t");
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

    static void hitungPendapatan(int[][] data, String[] layanan, int[] harga, int jumlahHari) {
        System.out.println("\n=== LAPORAN PENDAPATAN ===");
        int totalSemuaPendapatan = 0;

        for (int i = 0; i < layanan.length; i++) {
            int totalKg = totalPerLayanan(data, i);
            int pendapatanLayanan = totalKg * harga[i];
            totalSemuaPendapatan += pendapatanLayanan;
            System.out.println(layanan[i] + "\t: Rp" + pendapatanLayanan + " (" + totalKg + " kg)");
        }
        System.out.println("Total Pendapatan (" + jumlahHari + " Hari): Rp" + totalSemuaPendapatan);
    }

    public static void main(String[] args) {
        System.out.print("Masukkan jumlah layanan: ");
        int jmlLayanan = sc.nextInt();
        System.out.print("Masukkan jumlah hari: ");
        int jmlHari = sc.nextInt();
        sc.nextLine();

        String[] layanan = new String[jmlLayanan];
        int[] harga = new int[jmlLayanan];
        int[][] data = new int[jmlLayanan][jmlHari];

        inputMasterLayanan(layanan, harga);
        inputData(data, layanan, jmlHari);
        tampilTabel(data, layanan, harga, jmlHari);
        layananTertinggi(data, layanan);

        int idxSibuk = hariTersibuk(data);
        System.out.println("Hari tersibuk: Hari ke-" + (idxSibuk + 1));

        hitungPendapatan(data, layanan, harga, jmlHari);
    }
}

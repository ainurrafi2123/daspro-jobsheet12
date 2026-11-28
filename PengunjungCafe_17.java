public class PengunjungCafe_17 {
  // Fungsi untuk menjumlahkan seluruh harga
  static int hitungTotalBelanja(int... harga) {
    int total = 0;
    for (int h : harga) {
      total += h;
    }
    return total;
  }

  public static void main(String[] args) {
    // Uji dengan 1 argumen
    int total1 = hitungTotalBelanja(15000);
    System.out.println("Total belanja (1 item): Rp" + total1);

    // Uji dengan 3 argumen
    int total3 = hitungTotalBelanja(15000, 20000, 10000);
    System.out.println("Total belanja (3 item): Rp" + total3);

    // Uji dengan 5 argumen
    int total5 = hitungTotalBelanja(15000, 20000, 10000, 12000, 18000);
    System.out.println("Total belanja (5 item): Rp" + total5);
  }
  // public static void main(String[] args) {
  // String[] tamu = { "Ali", "Budi", "Citra" };
  // daftarPengunjung(tamu);
  // }

}

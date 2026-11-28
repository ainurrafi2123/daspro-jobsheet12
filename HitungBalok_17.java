import java.util.Scanner;
public class HitungBalok_17 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int p, l, t, L, vol;

    System.out.print("Masukkan Panjang: ");
    p = input.nextInt();
    System.out.print("Masukkan Lebar: ");
    l = input.nextInt();
    System.out.print("Masukkan Tinggi: ");
    t = input.nextInt();

    L = p * l;
    System.out.println("Luas Persegi Panjang = " + L);

    vol = p * l * t;
    System.out.println("Volume Balok = " + vol);

    input.close();
  }
} 


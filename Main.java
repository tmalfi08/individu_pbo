package projek_pbo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bus transKoetaradja = new Bus();
        Scanner input = new Scanner(System.in);
        int pilihan = 0;
        int idCounter = 1;

        while (pilihan != 4) {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Naikkan Penumpang");
            System.out.println("2. Turunkan Penumpang");
            System.out.println("3. Lihat Status Bus");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");

            if (input.hasNextInt()) {
                pilihan = input.nextInt();
                input.nextLine(); // Membersihkan baris baru (enter)
            } else {
                System.out.println("Error: Masukkan angka!");
                input.next(); // Buang input yang salah
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Penumpang: ");
                    String nama = input.nextLine();

                    System.out.print("Umur: ");
                    int umur = 0;
                    if (input.hasNextInt()) {
                        umur = input.nextInt();
                    } else {
                        System.out.println("Umur harus angka! Dianggap 0.");
                        input.next();
                    }

                    System.out.print("Apakah Hamil? (ketik 'y' jika ya,atau tidak): ");
                    String hamilStr = input.next();
                    boolean hamil = hamilStr.equalsIgnoreCase("y");

                    Penumpang p = new Penumpang(nama, idCounter++, umur, hamil);
                    
                    if (transKoetaradja.naikkanPenumpang(p)) {
                        System.out.println("-> BERHASIL: " + nama + " naik ke dalam bus.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan nama penumpang yang turun: ");
                    String namaTurun = input.nextLine();
                    
                    if (transKoetaradja.turunkanPenumpang(namaTurun)) {
                        System.out.println("-> BERHASIL: " + namaTurun + " telah turun.");
                    } else {
                        System.out.println("-> GAGAL: Nama tidak ditemukan di dalam bus.");
                    }
                    break;

                case 3:
                    System.out.println(transKoetaradja.toString());
                    break;

                case 4:
                    System.out.println("Program Selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        input.close();
    }
}

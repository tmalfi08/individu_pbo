package projek_pbo;

import java.util.InputMismatchException; // Import Exception
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

            // --- PENERAPAN EXCEPTION HANDLING (TRY-CATCH) ---
            try {
                pilihan = input.nextInt();
                input.nextLine(); // Membersihkan newline
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Input harus berupa angka!");
                input.nextLine(); // Bersihkan buffer input yang salah
                pilihan = 0; // Reset pilihan agar loop berulang
                continue;
            }

            switch (pilihan) {
                case 1:
                    try {
                        System.out.print("Nama Penumpang: ");
                        String nama = input.nextLine();

                        System.out.print("Umur: ");
                        int umur = input.nextInt(); // Bisa error jika diisi huruf

                        System.out.print("Apakah Hamil? (ketik y/n): ");
                        String hamilStr = input.next();
                        boolean hamil = hamilStr.equalsIgnoreCase("y");

                        Penumpang p = new Penumpang(nama, idCounter++, umur, hamil);
                        
                        if (transKoetaradja.naikkanPenumpang(p)) {
                            System.out.println("-> BERHASIL: " + nama + " naik ke dalam bus.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Data umur harus angka! Ulangi proses.");
                        input.nextLine(); // Bersihkan buffer
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

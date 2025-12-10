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

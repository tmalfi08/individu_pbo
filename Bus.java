package projek_pbo;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    // atribut List Penumpang
    private ArrayList<Penumpang> penumpangBiasa;
    private ArrayList<Penumpang> penumpangPrioritas;
    private ArrayList<Penumpang> penumpangBerdiri;

    private static final int ONGKOS_BUS = 2000;
    private int totalPendapatan;

    // constructor Bus
    public Bus() {
        penumpangBiasa = new ArrayList<>();
        penumpangPrioritas = new ArrayList<>();
        penumpangBerdiri = new ArrayList<>();
        totalPendapatan = 0;
    }

    // Method Naikkan Penumpang
    public boolean naikkanPenumpang(Penumpang p) {
        // 1. Cek Saldo
        if (p.getSaldo() < ONGKOS_BUS) {
            System.out.println("Gagal: Saldo kurang! Saldo anda: " + p.getSaldo());
            return false;
        }

        // 2. Cek Prioritas (Lansia > 60, Anak < 10, atau Hamil)
        boolean isPrioritas = (p.getUmur() < 10 || p.getUmur() > 60 || p.getHamil());
        boolean berhasilNaik = false;

        if (isPrioritas) {
            // Prioritas masuk ke: Kursi Prioritas -> Kursi Biasa -> Berdiri
            if (penumpangPrioritas.size() < 4) {
                penumpangPrioritas.add(p);
                berhasilNaik = true;
            } else if (penumpangBiasa.size() < 16) {
                penumpangBiasa.add(p);
                berhasilNaik = true;
            } else if (penumpangBerdiri.size() < 20) {
                penumpangBerdiri.add(p);
                berhasilNaik = true;
            }
        } else {
            // Penumpang Biasa masuk ke: Kursi Biasa -> Berdiri (TIDAK BOLEH KE PRIORITAS)
            if (penumpangBiasa.size() < 16) {
                penumpangBiasa.add(p);
                berhasilNaik = true;
            } else if (penumpangBerdiri.size() < 20) {
                penumpangBerdiri.add(p);
                berhasilNaik = true;
            }
        }

        // Jika berhasil naik, potong saldo
        if (berhasilNaik) {
            p.kurangiSaldo(ONGKOS_BUS);
            totalPendapatan += ONGKOS_BUS;
            return true;
        } else {
            System.out.println("Gagal: Bus Penuh!");
            return false;
        }
    }

    // Method Turunkan Penumpang
    public boolean turunkanPenumpang(String nama) {
        // Cek di list Prioritas
        for (int i = 0; i < penumpangPrioritas.size(); i++) {
            if (penumpangPrioritas.get(i).getNama().equalsIgnoreCase(nama)) {
                penumpangPrioritas.remove(i);
                return true;
            }
        }
        // Cek di list Biasa
        for (int i = 0; i < penumpangBiasa.size(); i++) {
            if (penumpangBiasa.get(i).getNama().equalsIgnoreCase(nama)) {
                penumpangBiasa.remove(i);
                return true;
            }
        }
        // Cek di list Berdiri
        for (int i = 0; i < penumpangBerdiri.size(); i++) {
            if (penumpangBerdiri.get(i).getNama().equalsIgnoreCase(nama)) {
                penumpangBerdiri.remove(i);
                return true;
            }
        }
        return false; // Tidak ditemukan
    }
    
    // Method toString 
    public String toString() {
        String result = "\n=== STATUS BUS TRANS KOETARADJA ===\n";
        
        result += "1. Penumpang Prioritas (" + penumpangPrioritas.size() + "/4) : ";
        if (penumpangPrioritas.isEmpty()) {
            result += "<kosong>";
        } else {
            for (Penumpang p : penumpangPrioritas) {
                // Menampilkan Nama + Saldo
                result += p.getNama() + " [Rp " + p.getSaldo() + "], ";
            }
        }
        result += "\n";

        result += "2. Penumpang Biasa (" + penumpangBiasa.size() + "/16)     : ";
        if (penumpangBiasa.isEmpty()) {
            result += "<kosong>";
        } else {
            for (Penumpang p : penumpangBiasa) {
                result += p.getNama() + " [Rp " + p.getSaldo() + "], ";
            }
        }
        result += "\n";

        result += "3. Penumpang Berdiri (" + penumpangBerdiri.size() + "/20)   : ";
        if (penumpangBerdiri.isEmpty()) {
            result += "<kosong>";
        } else {
            for (Penumpang p : penumpangBerdiri) {
                result += p.getNama() + " [Rp " + p.getSaldo() + "], ";
            }
        }
        result += "\n";

        result += "----------------------------------------\n";
        result += "Total Pendapatan Bus: Rp " + totalPendapatan + "\n";
        return result;
    }
}

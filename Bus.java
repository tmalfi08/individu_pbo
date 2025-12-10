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

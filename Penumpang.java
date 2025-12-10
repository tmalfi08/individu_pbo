package projek_pbo;

public class Penumpang {
    private String nama; // Ditambahkan agar sesuai logika hapus by nama
    private int id; // Sesuai diagram 
    private int umur;
    private boolean hamil;
    private int saldo;

    public Penumpang(String nama, int id, int umur, boolean hamil) {
        this.nama = nama;
        this.id = id;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = 10000; // Saldo awal 10.000 [cite: 41]
    }

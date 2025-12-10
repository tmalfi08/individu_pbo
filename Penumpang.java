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
        this.saldo = 10000; // Saldo awal 10.000 
    }
 
    // Accessor Methods (Getters)
    public String getNama() { return nama; }
    public int getId() { return id; }
    public int getUmur() { return umur; }
    public boolean getHamil() { return hamil; }
    public int getSaldo() { return saldo; }

    // Method tambah saldo 
    public void tambahSaldo(int saldoBaru) {
        this.saldo += saldoBaru;
    }

    // Method kurangi saldo 
    public void kurangiSaldo(int ongkos) {
        this.saldo -= ongkos;
    }
}

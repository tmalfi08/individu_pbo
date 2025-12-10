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

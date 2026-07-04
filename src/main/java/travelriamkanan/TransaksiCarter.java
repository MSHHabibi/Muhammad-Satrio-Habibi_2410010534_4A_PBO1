package travelriamkanan;

// No.1 CLASS 
public class TransaksiCarter {
    // No.3 ATRIBUT + No.7 ENCAPSULATION 
    private String pemesan;
    private TransportAir armada;      // tipe induk -> siap Polymorphism
    private LokasiWisata lokasi;
    private MenuKonsumsi menu;
    private int penumpang;
    private int jamSewa;
    private boolean akhirPekan;

    private static final double ASURANSI_PER_ORANG = 3000;

    //  No.4 CONSTRUCTOR 
    public TransaksiCarter(String pemesan, TransportAir armada, LokasiWisata lokasi,
                           MenuKonsumsi menu, int penumpang, int jamSewa, boolean akhirPekan) {
        this.pemesan = pemesan;
        this.armada = armada;
        this.lokasi = lokasi;
        this.menu = menu;
        this.penumpang = penumpang;
        this.jamSewa = jamSewa;
        this.akhirPekan = akhirPekan;
    }

    //  No.6 ACCESSOR 
    public String getPemesan()      { return pemesan; }
    public TransportAir getArmada() { return armada; }
    public LokasiWisata getLokasi() { return lokasi; }
    public MenuKonsumsi getMenu()   { return menu; }
    public int getPenumpang()       { return penumpang; }
    public int getJamSewa()         { return jamSewa; }
    public boolean isAkhirPekan()   { return akhirPekan; }

    //  No.5 MUTATOR 
    public void setPemesan(String pemesan)        { this.pemesan = pemesan; }
    public void setPenumpang(int penumpang)       { this.penumpang = penumpang; }
    public void setJamSewa(int jamSewa)           { this.jamSewa = jamSewa; }
    public void setAkhirPekan(boolean akhirPekan) { this.akhirPekan = akhirPekan; }

    //  No.9 POLYMORPHISM - OVERLOADING (nama sama, beda parameter) 
    public double hitungTotal() {
        return hitungTotal(promoOtomatis());
    }

    public double hitungTotal(double persenPromo) {
        //  No.9 POLYMORPHISM - DYNAMIC DISPATCH (estimasiHarga sesuai jenis armada) 
        double subtotal = armada.estimasiHarga(penumpang, jamSewa)
                        + lokasi.getBiayaRute()                 // biaya rute per trip (sekali)
                        + menu.getTarifPerKepala() * penumpang
                        + ASURANSI_PER_ORANG * penumpang;

        //  No.10 SELEKSI (if) - surcharge akhir pekan 
        if (akhirPekan) {
            subtotal += subtotal * 0.10; // naik 10% di akhir pekan
        }
        return subtotal - (subtotal * persenPromo / 100.0);
    }

    // Diskon bertingkat
    public double promoOtomatis() {
        //  No.10 SELEKSI (if-else bertingkat)
        if (penumpang >= 10) {
            return 7.0;
        } else if (penumpang >= 6) {
            return 3.0;
        } else {
            return 0.0;
        }
    }

    // Nota dalam bentuk teks (dipakai untuk cetak ke layar & ke file)
    public String notaSebagaiText(int urutan) {
        double promo = promoOtomatis();
        double sebelumPromo = hitungTotal(0.0);
        double total = hitungTotal();
        StringBuilder sb = new StringBuilder();
        sb.append("\n############ NOTA CARTER #").append(urutan).append(" ############\n");
        sb.append(" Pemesan      : ").append(pemesan).append("\n");
        sb.append(" Armada       : ").append(armada.getNamaJenis())
          .append(" (").append(armada.getKodeArmada()).append(")\n");
        sb.append(" Keunggulan   : ").append(armada.keunggulan()).append("\n");
        sb.append(" Tujuan       : ").append(lokasi.getNamaLokasi())
          .append(" (biaya rute Rp ").append(format(lokasi.getBiayaRute())).append(")\n");
        sb.append(" Konsumsi     : ").append(menu.getLabelMenu()).append("\n");
        sb.append(" Penumpang    : ").append(penumpang).append(" orang\n");
        sb.append(" Sewa         : ").append(jamSewa).append(" jam")
          .append(akhirPekan ? " (akhir pekan +10%)" : "").append("\n");
        sb.append(" Sebelum promo: Rp ").append(format(sebelumPromo)).append("\n");
        sb.append(" Promo        : ").append(promo).append("%\n");
        sb.append(" TOTAL BAYAR  : Rp ").append(format(total)).append("\n");
        sb.append("#######################################\n");
        return sb.toString();
    }

    public void cetakNota(int urutan) {
        //  No.12 IO SEDERHANA (output ke layar) 
        System.out.println(notaSebagaiText(urutan));
    }

    private String format(double nilai) {
        return String.format("%,.0f", nilai).replace(',', '.');
    }
}
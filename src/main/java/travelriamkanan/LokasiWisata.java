package travelriamkanan;

// No.1 CLASS 
public class LokasiWisata {
    // No.3 ATRIBUT + No.7 ENCAPSULATION
    private String namaLokasi;
    private double biayaRute;   // biaya per trip (sekali carter)

    // No.4 CONSTRUCTOR 
    public LokasiWisata(String namaLokasi, double biayaRute) {
        this.namaLokasi = namaLokasi;
        this.biayaRute = biayaRute;
    }

    // No.6 ACCESSOR
    public String getNamaLokasi() { return namaLokasi; }
    public double getBiayaRute()  { return biayaRute; }

    // No.5 MUTATOR 
    public void setNamaLokasi(String namaLokasi) { this.namaLokasi = namaLokasi; }
    public void setBiayaRute(double biayaRute)   { this.biayaRute = biayaRute; }
}
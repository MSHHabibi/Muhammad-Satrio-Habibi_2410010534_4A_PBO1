package travelriamkanan;

// [No.1] CLASS (abstract = induk untuk Inheritance)
public abstract class TransportAir {
    // [No.3] ATRIBUT + [No.7] ENCAPSULATION
    private String kodeArmada;
    private String namaJenis;
    private int dayaTampung;
    private double biayaSewaHarian;

    //  [No.4] CONSTRUCTOR 
    public TransportAir(String kodeArmada, String namaJenis, int dayaTampung, double biayaSewaHarian) {
        this.kodeArmada = kodeArmada;
        this.namaJenis = namaJenis;
        this.dayaTampung = dayaTampung;
        this.biayaSewaHarian = biayaSewaHarian;
    }

    //  [No.6] ACCESSOR
    public String getKodeArmada()      { return kodeArmada; }
    public String getNamaJenis()       { return namaJenis; }
    public int getDayaTampung()        { return dayaTampung; }
    public double getBiayaSewaHarian() { return biayaSewaHarian; }

    //  [No.5] MUTATOR 
    public void setKodeArmada(String kodeArmada)     { this.kodeArmada = kodeArmada; }
    public void setNamaJenis(String namaJenis)       { this.namaJenis = namaJenis; }
    public void setDayaTampung(int dayaTampung)      { this.dayaTampung = dayaTampung; }
    public void setBiayaSewaHarian(double biayaSewa) { this.biayaSewaHarian = biayaSewa; }

    //  [No.9] POLYMORPHISM (method abstract wajib di-override) 
    public abstract double estimasiHarga(int penumpang, int jamSewa);
    public abstract String keunggulan();
}
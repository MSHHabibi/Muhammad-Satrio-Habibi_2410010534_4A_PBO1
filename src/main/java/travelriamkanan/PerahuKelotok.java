package travelriamkanan;

// No.1 CLASS + No.8 INHERITANCE (extends TransportAir) 
public class PerahuKelotok extends TransportAir {
    // No.3 ATRIBUT + No.7 ENCAPSULATION
    private boolean adaAtap;
    private int jumlahMesin;

    // No.4 CONSTRUCTOR (super = warisan constructor induk) 
    public PerahuKelotok(String kodeArmada, int dayaTampung, double biayaSewaHarian,
                         boolean adaAtap, int jumlahMesin) {
        super(kodeArmada, "Perahu Kelotok", dayaTampung, biayaSewaHarian);
        this.adaAtap = adaAtap;
        this.jumlahMesin = jumlahMesin;
    }

    // [No.6] ACCESSOR 
    public boolean isAdaAtap()  { return adaAtap; }
    public int getJumlahMesin() { return jumlahMesin; }
    // [No.5] MUTATOR
    public void setAdaAtap(boolean adaAtap)     { this.adaAtap = adaAtap; }
    public void setJumlahMesin(int jumlahMesin) { this.jumlahMesin = jumlahMesin; }

    // No.9 POLYMORPHISM (OVERRIDE method induk)
    @Override
    public double estimasiHarga(int penumpang, int jamSewa) {
        double harga = getBiayaSewaHarian() + (jamSewa * 20000); // biaya per jam operasi
        // No.10 SELEKSI (if) 
        if (adaAtap) {
            harga += 40000; // sewa atap peneduh
        }
        harga += jumlahMesin * 25000; // bahan bakar per mesin
        return harga;
    }

    @Override
    public String keunggulan() {
        return (adaAtap ? "Beratap nyaman" : "Terbuka lega")
             + ", " + jumlahMesin + " mesin, cocok rombongan keluarga besar";
    }
}
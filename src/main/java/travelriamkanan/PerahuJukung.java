package travelriamkanan;

//  No.1 CLASS + No.8 INHERITANCE (extends TransportAir)
public class PerahuJukung extends TransportAir {
    //  No.3 ATRIBUT + No.7 ENCAPSULATION 
    private String bahanKayu;
    private boolean bermotor;

    //  No.4 CONSTRUCTOR 
    public PerahuJukung(String kodeArmada, int dayaTampung, double biayaSewaHarian,
                        String bahanKayu, boolean bermotor) {
        super(kodeArmada, "Perahu Jukung", dayaTampung, biayaSewaHarian);
        this.bahanKayu = bahanKayu;
        this.bermotor = bermotor;
    }

    // No.6 ACCESSOR 
    public String getBahanKayu() { return bahanKayu; }
    public boolean isBermotor()  { return bermotor; }
    //No.5 MUTATOR
    public void setBahanKayu(String bahanKayu) { this.bahanKayu = bahanKayu; }
    public void setBermotor(boolean bermotor)  { this.bermotor = bermotor; }

    // No.9 POLYMORPHISM (OVERRIDE)
    @Override
    public double estimasiHarga(int penumpang, int jamSewa) {
        double harga = getBiayaSewaHarian() + (jamSewa * 10000);
        //No.10 SELEKSI (if-else) 
        if (bermotor) {
            harga += 60000; // motor tempel
        } else {
            harga += 15000; // tenaga pendayung
        }
        harga += penumpang * 4000; // pelampung per orang
        return harga;
    }

    @Override
    public String keunggulan() {
        return "Kayu " + bahanKayu + (bermotor ? ", bermotor lincah" : ", dayung tradisional")
             + ", cocok susur sungai & memancing";
    }
}
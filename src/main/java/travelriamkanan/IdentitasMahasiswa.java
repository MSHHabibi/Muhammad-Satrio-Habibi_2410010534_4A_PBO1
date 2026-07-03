package travelriamkanan;

// [No.1] CLASS 
public class IdentitasMahasiswa {
    //  [No.3] ATRIBUT + [No.7] ENCAPSULATION
    private String nama;
    private String npm;
    private String kelas;
    private String prodi;

    //  [No.4] CONSTRUCTOR
    public IdentitasMahasiswa(String nama, String npm, String kelas, String prodi) {
        this.nama = nama;
        this.npm = npm;
        this.kelas = kelas;
        this.prodi = prodi;
    }

    // [No.6] ACCESSOR
    public String getNama()  { return nama; }
    public String getNpm()   { return npm; }
    public String getKelas() { return kelas; }
    public String getProdi() { return prodi; }

    //  [No.5] MUTATOR 
    public void setNama(String nama)   { this.nama = nama; }
    public void setNpm(String npm)     { this.npm = npm; }
    public void setKelas(String kelas) { this.kelas = kelas; }
    public void setProdi(String prodi) { this.prodi = prodi; }

  
    public String ringkas() {
        return nama + " - " + npm;
    }

    public void banner() {
        // [No.12] IO SEDERHANA (output) 
        System.out.println("****************************************************");
        System.out.println("*   CARTER KELOTOK & JUKUNG WISATA RIAM KANAN     *");
        System.out.println("*        Waduk Riam Kanan - Kalimantan Selatan    *");
        System.out.println("****************************************************");
        System.out.println(" Pembuat : " + nama);
        System.out.println(" NPM     : " + npm);
        System.out.println(" Kelas   : " + kelas + "   Prodi : " + prodi);
        System.out.println("****************************************************\n");
    }
}
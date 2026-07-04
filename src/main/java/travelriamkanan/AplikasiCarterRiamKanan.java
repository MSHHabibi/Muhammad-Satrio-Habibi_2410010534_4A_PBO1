package travelriamkanan;

import java.util.Scanner;      // ===== [No.12] IO SEDERHANA (input) =====
import java.util.ArrayList;    // ArrayList untuk arsip transaksi (dinamis)
import java.io.FileWriter;     // ===== [No.12] IO (tulis file) =====
import java.io.IOException;    // ===== [No.14] ERROR HANDLING (exception file) =====

// ===== [No.1] CLASS (kelas utama) =====
public class AplikasiCarterRiamKanan {
    // ===== [No.13] ARRAY (data master tetap pakai array) =====
    static TransportAir[] armadaTersedia;
    static LokasiWisata[] daftarLokasi;
    static MenuKonsumsi[] daftarMenu;

    // ArrayList untuk arsip transaksi (bisa bertambah tanpa batas)
    static ArrayList<TransaksiCarter> arsip = new ArrayList<>();

    // Data pembuat (dipakai di menu & file)
    static IdentitasMahasiswa profil;

    // ===== [No.12] IO SEDERHANA (Scanner) =====
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // ===== [No.2] OBJECT ===== (GANTI identitas Anda di sini!)
        profil = new IdentitasMahasiswa("NAMA LENGKAP ANDA", "NPM ANDA", "KELAS ANDA", "Teknik Informatika");
        profil.banner();

        siapkanData();

        boolean aktif = true;
        // ===== [No.11] PERULANGAN (do-while) =====
        do {
            // ===== [No.14] ERROR HANDLING (try-catch) =====
            try {
                cetakMenu();
                int opsi = inputAngka("Masukkan pilihan");
                // ===== [No.10] SELEKSI (switch) =====
                switch (opsi) {
                    case 1: lihatArmada();       break;
                    case 2: lihatLokasi();       break;
                    case 3: lihatMenu();         break;
                    case 4: prosesCarter();      break;
                    case 5: lihatArsip();        break;
                    case 6: simpanTransaksi();   break; // FITUR SIMPAN
                    case 7: cetakNota();         break; // FITUR CETAK
                    case 0:
                        aktif = false;
                        System.out.println("Terima kasih, selamat menikmati wisata Riam Kanan!");
                        break;
                    default:
                        // ===== [No.14] ERROR HANDLING (throw custom exception) =====
                        throw new CarterException("Pilihan " + opsi + " tidak ada di menu.");
                }
            } catch (CarterException e) {
                System.out.println("[Peringatan] " + e.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("[Error] " + e.getMessage() + "\n");
            }
        } while (aktif);

        scan.close();
    }

    static void siapkanData() {
        // ===== [No.2] OBJECT + [No.13] ARRAY + [No.8] INHERITANCE =====
        armadaTersedia = new TransportAir[] {
            new PerahuKelotok("KLT-11", 18, 375000, true, 2),
            new PerahuKelotok("KLT-12", 12, 310000, false, 1),
            new PerahuJukung("JKG-21", 5, 130000, "Ulin", true),
            new PerahuJukung("JKG-22", 3, 95000, "Meranti", false)
        };

        // ===== [No.13] ARRAY (pilihan wisata Riam Kanan) =====
        daftarLokasi = new LokasiWisata[] {
            new LokasiWisata("Pulau Pinus Aranio",         300000),
            new LokasiWisata("Pulau Alimpung",             150000),
            new LokasiWisata("Bukit Batu",                 180000),
            new LokasiWisata("Keliling Waduk Riam Kanan",  600000),
            new LokasiWisata("Mancing (Spot Waduk)",       800000)
        };

        daftarMenu = new MenuKonsumsi[] {
            new MenuKonsumsi("Tanpa Konsumsi",             0),
            new MenuKonsumsi("Kudapan + Air Mineral",   17000),
            new MenuKonsumsi("Nasi Kuning Banjar",       28000),
            new MenuKonsumsi("Paket Iwak Bakar Patin",   52000)
        };
    }

    static void cetakMenu() {
        // ===== [No.12] IO SEDERHANA (output) =====
        System.out.println("========= APLIKASI CARTER RIAM KANAN =========");
        System.out.println(" 1. Daftar Armada (Kelotok & Jukung)");
        System.out.println(" 2. Daftar Pilihan Wisata");
        System.out.println(" 3. Daftar Menu Konsumsi");
        System.out.println(" 4. Proses Carter Baru");
        System.out.println(" 5. Arsip Transaksi");
        System.out.println(" 6. Simpan Transaksi ke File");
        System.out.println(" 7. Cetak Nota (layar + file)");
        System.out.println(" 0. Keluar");
        System.out.println("----------------------------------------------");
        System.out.println(" Pembuat: " + profil.ringkas()); // nama + NPM
        System.out.println("==============================================");
    }

    static void lihatArmada() {
        System.out.println("\n--- ARMADA TERSEDIA ---");
        // ===== [No.11] PERULANGAN (for) + [No.13] ARRAY =====
        for (int i = 0; i < armadaTersedia.length; i++) {
            TransportAir a = armadaTersedia[i];
            // ===== [No.9] POLYMORPHISM (keunggulan() sesuai jenis) =====
            System.out.println((i + 1) + ". " + a.getNamaJenis() + " [" + a.getKodeArmada() + "]"
                + " | daya tampung " + a.getDayaTampung() + " org"
                + " | sewa dasar Rp " + rp(a.getBiayaSewaHarian()));
            System.out.println("     Keunggulan: " + a.keunggulan());
        }
        System.out.println();
    }

    static void lihatLokasi() {
        System.out.println("\n--- PILIHAN WISATA RIAM KANAN ---");
        // ===== [No.11] PERULANGAN (for-each) + [No.13] ARRAY =====
        int no = 1;
        for (LokasiWisata l : daftarLokasi) {
            System.out.println(no++ + ". " + l.getNamaLokasi()
                + " | biaya rute Rp " + rp(l.getBiayaRute()));
        }
        System.out.println();
    }

    static void lihatMenu() {
        System.out.println("\n--- MENU KONSUMSI ---");
        // ===== [No.11] PERULANGAN (for-each) + [No.13] ARRAY =====
        int no = 1;
        for (MenuKonsumsi m : daftarMenu) {
            System.out.println(no++ + ". " + m.getLabelMenu()
                + " | Rp " + rp(m.getTarifPerKepala()) + "/org");
        }
        System.out.println();
    }

    static void prosesCarter() throws CarterException {
        // ===== [No.12] IO SEDERHANA (input) =====
        System.out.print("Nama pemesan: ");
        String nama = scan.nextLine().trim();
        // ===== [No.14] ERROR HANDLING + [No.10] SELEKSI =====
        if (nama.isEmpty()) {
            throw new CarterException("Nama pemesan wajib diisi.");
        }

        lihatArmada();
        int ia = inputAngka("Pilih nomor armada") - 1;
        if (ia < 0 || ia >= armadaTersedia.length) {
            throw new CarterException("Nomor armada tidak valid.");
        }
        TransportAir armada = armadaTersedia[ia]; // [No.13] ARRAY

        int pnp = inputAngka("Jumlah penumpang");
        if (pnp <= 0) {
            throw new CarterException("Penumpang minimal 1 orang.");
        }
        if (pnp > armada.getDayaTampung()) {
            throw new CarterException("Melebihi daya tampung " + armada.getNamaJenis()
                + " (maks " + armada.getDayaTampung() + " org).");
        }

        int jam = inputAngka("Lama sewa (jam)");
        if (jam <= 0) {
            throw new CarterException("Lama sewa minimal 1 jam.");
        }

        lihatLokasi();
        int il = inputAngka("Pilih nomor tujuan wisata") - 1;
        if (il < 0 || il >= daftarLokasi.length) {
            throw new CarterException("Nomor tujuan tidak valid.");
        }
        LokasiWisata lokasi = daftarLokasi[il];

        lihatMenu();
        int im = inputAngka("Pilih nomor menu") - 1;
        if (im < 0 || im >= daftarMenu.length) {
            throw new CarterException("Nomor menu tidak valid.");
        }
        MenuKonsumsi menu = daftarMenu[im];

        System.out.print("Carter di akhir pekan? (y/t): ");
        String jawab = scan.nextLine().trim().toLowerCase();
        boolean weekend = jawab.equals("y"); // [No.10] SELEKSI

        // ===== [No.2] OBJECT =====
        TransaksiCarter trx = new TransaksiCarter(nama, armada, lokasi, menu, pnp, jam, weekend);
        arsip.add(trx);                 // simpan ke ArrayList (dinamis)
        trx.cetakNota(arsip.size());
    }

    static void lihatArsip() {
        // ===== [No.10] SELEKSI (if) =====
        if (arsip.isEmpty()) {
            System.out.println("\nBelum ada transaksi.\n");
            return;
        }
        System.out.println("\n===== ARSIP TRANSAKSI (" + arsip.size() + ") =====");
        double pemasukan = 0;
        // ===== [No.11] PERULANGAN (for) + ArrayList =====
        for (int i = 0; i < arsip.size(); i++) {
            TransaksiCarter t = arsip.get(i);
            System.out.println((i + 1) + ". " + t.getPemesan()
                + " - " + t.getArmada().getNamaJenis()
                + " - " + t.getLokasi().getNamaLokasi()
                + " - Rp " + rp(t.hitungTotal()));
            pemasukan += t.hitungTotal();
        }
        System.out.println("Total pemasukan: Rp " + rp(pemasukan));
        System.out.println("==================================\n");
    }

    // ===== FITUR SIMPAN: tulis semua transaksi ke file .txt =====
    static void simpanTransaksi() throws CarterException {
        // ===== [No.10] SELEKSI + [No.14] ERROR HANDLING =====
        if (arsip.isEmpty()) {
            throw new CarterException("Belum ada transaksi untuk disimpan.");
        }
        String namaFile = "transaksi_riamkanan.txt";
        // ===== [No.14] ERROR HANDLING (try-with-resources untuk file) =====
        try (FileWriter fw = new FileWriter(namaFile)) {
            fw.write("DAFTAR TRANSAKSI CARTER WISATA RIAM KANAN\n");
            fw.write("Dibuat oleh : " + profil.ringkas() + "\n"); // nama + NPM
            fw.write("=========================================\n");
            double pemasukan = 0;
            // ===== [No.11] PERULANGAN (for) + ArrayList =====
            for (int i = 0; i < arsip.size(); i++) {
                TransaksiCarter t = arsip.get(i);
                fw.write((i + 1) + ". " + t.getPemesan()
                    + " - " + t.getArmada().getNamaJenis()
                    + " - " + t.getLokasi().getNamaLokasi()
                    + " - Rp " + rp(t.hitungTotal()) + "\n");
                pemasukan += t.hitungTotal();
            }
            fw.write("-----------------------------------------\n");
            fw.write("Total pemasukan : Rp " + rp(pemasukan) + "\n");
            System.out.println("\n>> Berhasil disimpan ke file: " + namaFile + "\n");
        } catch (IOException e) {
            // ===== [No.14] ERROR HANDLING (tangani gagal tulis file) =====
            System.out.println("[Error] Gagal menyimpan file: " + e.getMessage() + "\n");
        }
    }

    // ===== FITUR CETAK: cetak 1 nota ke layar + simpan ke file siap print =====
    static void cetakNota() throws CarterException {
        // ===== [No.10] SELEKSI + [No.14] ERROR HANDLING =====
        if (arsip.isEmpty()) {
            throw new CarterException("Belum ada transaksi untuk dicetak.");
        }
        lihatArsip();
        int nomor = inputAngka("Pilih nomor transaksi yang dicetak");
        if (nomor < 1 || nomor > arsip.size()) {
            throw new CarterException("Nomor transaksi tidak valid.");
        }
        TransaksiCarter t = arsip.get(nomor - 1); // ArrayList
        String isiNota = t.notaSebagaiText(nomor);

        // ===== [No.12] IO SEDERHANA (cetak ke layar) =====
        System.out.println(isiNota);

        // ===== [No.14] ERROR HANDLING (cetak ke file) =====
        String namaFile = "nota_" + nomor + ".txt";
        try (FileWriter fw = new FileWriter(namaFile)) {
            fw.write("Dicetak oleh : " + profil.ringkas() + "\n"); // nama + NPM
            fw.write(isiNota);
            System.out.println(">> Nota disimpan ke file: " + namaFile + " (siap dicetak)\n");
        } catch (IOException e) {
            System.out.println("[Error] Gagal mencetak ke file: " + e.getMessage() + "\n");
        }
    }

    // ===== [No.12] IO SEDERHANA + [No.14] ERROR HANDLING + [No.11] PERULANGAN =====
    static int inputAngka(String label) {
        while (true) { // [No.11] PERULANGAN
            System.out.print(label + ": ");
            String baris = scan.nextLine().trim();
            try { // [No.14] ERROR HANDLING
                return Integer.parseInt(baris);
            } catch (NumberFormatException e) {
                System.out.println("  >> Harus angka. Coba lagi.");
            }
        }
    }

    static String rp(double nilai) {
        return String.format("%,.0f", nilai).replace(',', '.');
    }
}
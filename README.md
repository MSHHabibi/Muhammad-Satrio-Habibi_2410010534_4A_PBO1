# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah aplikasi Sistem Carter Kapal Wisata Riam Kanan menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa data pemesanan carter perahu wisata Riam Kanan seperti nama pemesan, jenis perahu, tujuan wisata, jumlah penumpang, dan lama sewa, lalu memberikan output berupa perhitungan total biaya carter, arsip transaksi, serta nota yang dapat disimpan dan dicetak ke file. Tersedia dua jenis armada yaitu Perahu Kelotok dan Perahu Jukung, pilihan destinasi wisata (Pulau Pinus Aranio, Pulau Alimpung, Bukit Batu, Keliling Waduk Riam Kanan, dan Mancing Spot Waduk), paket konsumsi, biaya asuransi per penumpang, surcharge akhir pekan, serta promo rombongan.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `TransportAir`, `PerahuKelotok`, `TransaksiCarter`, dan `AplikasiCarterRiamKanan` adalah contoh dari class.

```java
public abstract class TransportAir {
    ...
}

public class PerahuKelotok extends TransportAir {
    ...
}

public class TransaksiCarter {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `arsip.add(new TransaksiCarter(...))` adalah contoh pembuatan object.

```java
TransaksiCarter trx = new TransaksiCarter(nama, armada, lokasi, menu, pnp, jam, weekend);
arsip.add(trx);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `kodeArmada`, `namaJenis`, dan `biayaSewaHarian` adalah contoh atribut.

```java
String kodeArmada;
String namaJenis;
double biayaSewaHarian;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `TransportAir` dan `PerahuKelotok`.

```java
public TransportAir(String kodeArmada, String namaJenis, int dayaTampung, double biayaSewaHarian) {
    this.kodeArmada = kodeArmada;
    this.namaJenis = namaJenis;
    this.dayaTampung = dayaTampung;
    this.biayaSewaHarian = biayaSewaHarian;
}

public PerahuKelotok(String kodeArmada, int dayaTampung, double biayaSewaHarian, boolean adaAtap, int jumlahMesin) {
    super(kodeArmada, "Perahu Kelotok", dayaTampung, biayaSewaHarian);
    this.adaAtap = adaAtap;
    this.jumlahMesin = jumlahMesin;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setBiayaSewaHarian` dan `setAdaAtap` adalah contoh method mutator.

```java
public void setBiayaSewaHarian(double biayaSewaHarian) {
    this.biayaSewaHarian = biayaSewaHarian;
}

public void setAdaAtap(boolean adaAtap) {
    this.adaAtap = adaAtap;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getKodeArmada`, `getNamaJenis`, `getBiayaSewaHarian`, dan `isAdaAtap` adalah contoh method accessor.

```java
public String getKodeArmada() {
    return kodeArmada;
}

public boolean isAdaAtap() {
    return adaAtap;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `kodeArmada` dan `biayaSewaHarian` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```java
private String kodeArmada;
private double biayaSewaHarian;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `PerahuKelotok` dan `PerahuJukung` mewarisi `TransportAir` dengan sintaks `extends`.

```java
public class PerahuJukung extends TransportAir {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `hitungTotal(double persenPromo)` di `TransaksiCarter` merupakan overloading method `hitungTotal`, dan `estimasiHarga` di `PerahuKelotok` merupakan override dari method `estimasiHarga` di `TransportAir`.

```java
public double hitungTotal(double persenPromo) {
    return hitungTotal() - (hitungTotal() * persenPromo / 100.0);
}

@Override
public double estimasiHarga(int penumpang, int jamSewa) {
    ...
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `switch` dalam menu utama dan seleksi `if` untuk biaya akhir pekan.

```java
switch (opsi) {
    case 1:
        lihatArmada();
        break;
    case 4:
        prosesCarter();
        break;
    default:
        throw new CarterException("Pilihan " + opsi + " tidak ada di menu.");
}

if (akhirPekan) {
    subtotal += subtotal * 0.10;
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` untuk menampilkan data dan `do-while` untuk menu.

```java
for (int i = 0; i < armadaTersedia.length; i++) {
    TransportAir a = armadaTersedia[i];
    System.out.println((i + 1) + ". " + a.getNamaJenis());
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output, serta `FileWriter` untuk menyimpan dan mencetak ke file.

```java
Scanner scan = new Scanner(System.in);
System.out.print("Nama pemesan: ");
String nama = scan.nextLine();

System.out.println(trx.notaSebagaiText(nomor));
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `TransportAir[] armadaTersedia` digunakan untuk data master perahu, sedangkan arsip transaksi memakai `ArrayList` agar bisa bertambah tanpa batas.

```java
TransportAir[] armadaTersedia = new TransportAir[4];
ArrayList<TransaksiCarter> arsip = new ArrayList<>();
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` dan exception buatan sendiri `CarterException` untuk menangani error input.

```java
try {
    return Integer.parseInt(baris);
} catch (NumberFormatException e) {
    System.out.println("Error: Input harus angka!");
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Muhammad Satrio Habibi
NPM: 2410010534
